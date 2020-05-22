package com.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.db.DB;
import com.demo.model.Patient;
import com.demo.model.Session;
import com.demo.model.User;
import com.demo.service.Service;

@Controller
public class MainController {
	@Autowired
	DB db;
	@Autowired
	Service service;
	
	@RequestMapping("/")
	public ModelAndView showIndex() {
		ModelAndView mav= new ModelAndView();
		User user=new User();
		mav.addObject("user", user);
		mav.setViewName("login");
		return mav;
	}
	
	
	@RequestMapping("/logout")
	public ModelAndView showLogin() {
		ModelAndView mav= new ModelAndView();
		User user=new User();
		mav.addObject("user", user);
		mav.setViewName("login");
		return mav;
	}
	/*
	@RequestMapping("/process-login")
	public ModelAndView processLogin(User user) {
		ModelAndView mav = new ModelAndView();
		if(user.getUsername().equals("") && user.getPassword().equals("")) {
			Patient patient=new Patient();
			mav.setViewName("home");
			return mav;
		}
		mav.addObject("msg", "INVALID CREDENTIALS");
		mav.setViewName("login");
		return mav;
	}
	*/
	@RequestMapping("/process-login")
	public String processLoginNew(User user,Model model) {
		if(user.getUsername().equals("admin") && user.getPassword().equals("1234")) {
			return "redirect:/home";
		}
		model.addAttribute("msg", "INVALID CREDENTIALS");
		return "login";
	}
	
	@RequestMapping("/home")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/register")
	public ModelAndView registerPatient() {
		ModelAndView mav = new ModelAndView();
		Patient patient=new Patient();
		mav.addObject("patient", patient);
		mav.setViewName("register");
		return mav;
	}
	
	@RequestMapping("/addNewPatient")
	public ModelAndView addNewPatient(Patient p) {
		ModelAndView mav = new ModelAndView();
		service.insertPatient(p);
		mav.addObject("msg", "Patient added successfully. Go home.");
		mav.setViewName("register");
		return mav;
	}
	
	@RequestMapping("/process-search")
	public ModelAndView searchPatient(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String name=request.getParameter("name");
		List<Patient>list=service.searchPatient(name);
		mav.addObject("list",list);
		if(list.size()==0) {
			mav.addObject("msg", "No such patient exists.");
		}
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping("/update-page")
	public ModelAndView update() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("update");
		return mav;
	}

	
	@RequestMapping("/process-update-search")
	public ModelAndView processUpdateSearch(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String name=request.getParameter("name");
		List<Patient>list=service.searchPatient(name);
		mav.addObject("list",list);
		if(list.size()==0) {
			mav.addObject("msg", "No such Patient exists.");
			mav.setViewName("update");
		}
		mav.setViewName("update");
		return mav;
	}
	
	@RequestMapping("/updatePatient")
	public ModelAndView updatePatient(HttpServletRequest request,@RequestParam int id) {
		ModelAndView mav = new ModelAndView();
		//int id=Integer.parseInt(request.getParameter("id"));
		//System.out.println("To be updated:"+id);
		List<Patient>list=service.getPatient(id);
		mav.addObject("patient",new Patient());
		mav.addObject("list",list);
		mav.setViewName("update-form");
		return mav;
	}
	
	@RequestMapping("/process-update-info")
	public ModelAndView updateInfo(Patient patient) {
		ModelAndView mav = new ModelAndView();
		service.updatePatientInfo(patient);
		mav.addObject("msg", "Patient info has been updated.");
		mav.setViewName("home");
		return mav;
	}
	
	
	
	@RequestMapping("/get-profile")
	public ModelAndView showProfile(@RequestParam int id) {
		ModelAndView mav = new ModelAndView();
		List<Patient>list=service.getPatient(id);
		List<Session>sessions =service.getSession(id);
		Session s =new Session();
		mav.addObject("sessionInfo",s);
		mav.addObject("list", list);
		mav.addObject("sessions", sessions);
		if(sessions.size()==0) {
			mav.addObject("msg", "No previous history of diagnosis.");
		}
		mav.setViewName("profile");
		return mav;
		
	}
	
	
	@RequestMapping("/process-diagnosis")
	public String processSession(Session sessionInfo,HttpServletRequest request,Model model) {
		ModelAndView mav = new ModelAndView();
		
        Session s=new Session();
        s.setAmount(sessionInfo.getAmount());
        s.setBalance(sessionInfo.getBalance());
        s.setId(Integer.parseInt(request.getParameter("id")));
        s.setIssues(sessionInfo.getIssues());
        s.setMedicines(sessionInfo.getMedicines());
        int pid=Integer.parseInt(request.getParameter("id"));
       // System.out.println("=====================");
		//System.out.println("PATIENT ID: "+request.getParameter("id"));
		//System.out.println(sessionInfo.getIssues());
		//System.out.println(sessionInfo.getMedicines());
		//System.out.println(sessionInfo.getBalance());
		//System.out.println(sessionInfo.getAmount());
		

		service.addSession(s);
	
		//details for sending message
		if(sessionInfo.getBalance()!=0) {
			String PatientName="";
			String PatientMobile="";
			double balance=sessionInfo.getBalance();
			List<Patient> defBalPatient=service.getPatient(pid);
			for(Patient p: defBalPatient ) {
				PatientName=p.getName();
				PatientMobile=p.getMobile();
			}
			//System.out.println(PatientName+" "+PatientMobile+" "+balance);
			service.sendMessage(PatientName,PatientMobile,balance);
		}
		
		model.addAttribute("msg", "Patient session has been recorded.");
		return "home";
		
	}
	

	@RequestMapping("/track-income")
	public String incomePage(Model model) {
		double todays_income=service.getTodaysIncome();
		double month_income=service.getMonthIncome();
		model.addAttribute("todays_income",todays_income);
        model.addAttribute("month_income",month_income);
        
        List <String> months=new ArrayList();
		months.add("January");
		months.add("February");
		months.add("March");
		months.add("April");
		months.add("May");
		months.add("June");
		months.add("July");
		months.add("August");
		months.add("September");
		months.add("October");
		months.add("November");
		months.add("December");
		//System.out.println(months);
		List<Double> incomes=service.getMonthlyIncomes();
		 model.addAttribute("months", months);
	     model.addAttribute("income", incomes);
		return "income-main";
	}

	@RequestMapping("/income-monthly")
	public String incomeMonthly(Model model) {
		List <String> months=new ArrayList();
		months.add("January");
		months.add("February");
		months.add("March");
		months.add("April");
		months.add("May");
		months.add("June");
		months.add("July");
		months.add("August");
		months.add("September");
		months.add("October");
		months.add("November");
		months.add("December");
		//System.out.println(months);
		List<Double> incomes=service.getMonthlyIncomes();
		 model.addAttribute("months", months);
	     model.addAttribute("income", incomes);
		 return "income-main";
		
	}
	
	@RequestMapping("/loss-monthly")
	public String lossMonthly(Model model) {
		double todays_income=service.getTodaysIncome();
		double month_income=service.getMonthIncome();
		model.addAttribute("todays_income",todays_income);
        model.addAttribute("month_income",month_income);
        
		List <String> months=new ArrayList();
		months.add("January");
		months.add("February");
		months.add("March");
		months.add("April");
		months.add("May");
		months.add("June");
		months.add("July");
		months.add("August");
		months.add("September");
		months.add("October");
		months.add("November");
		months.add("December");
		//System.out.println(months);
		List<Double> losses=service.getMonthlyLosses();
		 model.addAttribute("months", months);
	     model.addAttribute("income", losses);
		 return "losschart";
		
	}
	
	
	
	@RequestMapping("/index")
	public ModelAndView showIndex1() {
		ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
		return mav;
	}


}
