package com.demo.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.db.DB;
import com.demo.model.Patient;
import com.demo.model.Session;


@Component
public class Service {
	@Autowired
	DB db;

	public void insertPatient(Patient p) {
		// TODO Auto-generated method stub
		try {
			db.insertPatient(p);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	public List<Patient> searchPatient(String name) {
		// TODO Auto-generated method stub
		List<Patient> list=new ArrayList();
		try {
			list=db.searchPatient(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	public List<Patient> getPatient(int id) {
		// TODO Auto-generate<>
		List<Patient> list =new ArrayList();
		try {
			list= db.getPatient(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Session> getSession(int id) {
		// TODO Auto-generated method stub
		List<Session> session =new ArrayList();

	    try {
			session =db.getSession(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return session;
	}

	public void addSession(Session s) {
		// TODO Auto-generated method stub
		try {
			db.addSession(s);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public double getTodaysIncome() {
		double todays_income=0.0;
		try {
			todays_income = db.getTodaysIncome();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return todays_income;
	}

	public double getMonthIncome() {
		// TODO Auto-generated method stub
		double month_income=0.0;
		try {
			month_income = db.getMonthIncome();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return month_income;
	}

	public void updatePatientInfo(Patient patient) {
		// TODO Auto-generated method stub
		try {
			db.updatePatientinfo(patient);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(String patientName, String patientMobile, double balance) {
		// TODO Auto-generated method stub
		String message=constructMessage(patientName, balance);
		SendMessage sendSMS= new SendMessage();
		sendSMS.sendBalanceSMS(message,patientMobile );
		
	}
 
	public String constructMessage(String patientName,double balance){
		LocalDate date=LocalDate.now();
		String message="Attention: "+patientName+", "
	    + "you have a payment of Rs."+balance+" pending as of: "+date+". Regards, from Doctor's Clinic.";
		return message;
		
	}


	public List<Double> getMonthlyIncomes() {
		// TODO Auto-generated method stub
		List<Double>incomes=new ArrayList<>();
		
		String []months= {"01","02","03","04","05","06","07","08","09","10","11","12"};
		
		for(String s:months) {
			double monthly_income = 0;
			try {
				monthly_income = db.getMonthlyIncomes(s);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			incomes.add(monthly_income);
		}
		
		
		return incomes;
	}


	public List<Double> getMonthlyLosses() {
		// TODO Auto-generated method stub
		List<Double>losses=new ArrayList<>();
		
		String []months= {"01","02","03","04","05","06","07","08","09","10","11","12"};
		
		for(String s:months) {
			double monthly_loss = 0;
			try {
				monthly_loss = db.getMonthlyLosses(s);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			losses.add(monthly_loss);
		}
		
		return losses;
	}

}
