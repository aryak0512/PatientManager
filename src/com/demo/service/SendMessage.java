package com.demo.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;

public class SendMessage {
	
	
	/*
	// required variables
	 static String url = "https://www.sms4india.com";
	 static String apiKey="JSTC1KK75993XG7BQX6SI37KAKTP31MP";
	 static String secretKey="KHJ3PNAW8C7RO08L";
	 static String useType="stage";
	 static String phone="8928983835";
	 static String message="This is a message from doctors clinic ";
	 static String senderId="aryak.deshpande0512@gmail.com";
	 /*
	 
	 public static void main(String []args) {
		 sendCampaign(apiKey,secretKey,useType, phone,  message,  senderId);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public static String sendCampaign(String apiKey,String secretKey,String useType, String phone, String message, String senderId){
	   try{
	       // construct data
	     JSONObject urlParameters = new JSONObject();
	     urlParameters.put("apikey",apiKey);
	     urlParameters.put("secret",secretKey);
	     urlParameters.put("usetype",useType);
	     urlParameters.put("phone", phone);
	     urlParameters.put("message", URLEncoder.encode(message,"UTF-8"));
	     urlParameters.put("senderid", senderId);
	     URL obj = new URL(url + "/api/v1/sendCampaign");
	       // send data
	     HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
	     httpConnection.setDoOutput(true);
	     httpConnection.setRequestMethod("POST");
	     DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
	     wr.write(urlParameters.toString().getBytes());
	     // get the response  
	     BufferedReader bufferedReader = null;
	     if (httpConnection.getResponseCode() == 200) {
	         bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
	     } else {
	         bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
	     }
	     StringBuilder content = new StringBuilder();
	     String line;
	     while ((line = bufferedReader.readLine()) != null) {
	         content.append(line).append("\n");
	     }
	     bufferedReader.close();
	     return content.toString();
	   }catch(Exception ex){
	     System.out.println("Exception at:"+ex);
	     return "{'status':500,'message':'Internal Server Error'}";
	   }
	     
	 }


*/


	public void sendBalanceSMS(String messageToPatient, String patientMobile) {
		 String url = "https://www.sms4india.com";
		 String apiKey="JSTC1KK75993XG7BQX6SI37KAKTP31MP";
		 String secretKey="KHJ3PNAW8C7RO08L";
		 String useType="stage";
		 String senderId="aryak.deshpande0512@gmail.com";
		 sendSMS(url,apiKey, secretKey, useType, patientMobile, messageToPatient, senderId);
		
	}


	private String sendSMS(String url,String apiKey, String secretKey, String useType, String patientMobile,
			String messageToPatient, String senderId) {
		// TODO Auto-generated method stub
		 try{
		       // construct data
			 System.out.println("Half done...");
		     JSONObject urlParameters = new JSONObject();
		     urlParameters.put("apikey",apiKey);
		     urlParameters.put("secret",secretKey);
		     urlParameters.put("usetype",useType);
		     urlParameters.put("phone", patientMobile);
		     urlParameters.put("message", URLEncoder.encode(messageToPatient,"UTF-8"));
		     urlParameters.put("senderid", senderId);
		     URL obj = new URL(url + "/api/v1/sendCampaign");
		       // send data
		     HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
		     httpConnection.setDoOutput(true);
		     httpConnection.setRequestMethod("POST");
		     DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
		     wr.write(urlParameters.toString().getBytes());
		     // get the response  
		     BufferedReader bufferedReader = null;
		     if (httpConnection.getResponseCode() == 200) {
		         bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
		     } else {
		         bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
		     }
		     StringBuilder content = new StringBuilder();
		     String line;
		     while ((line = bufferedReader.readLine()) != null) {
		         content.append(line).append("\n");
		     }
		     bufferedReader.close();
		     return content.toString();
		   }catch(Exception ex){
		     System.out.println("Exception at:"+ex);
		     return "{'status':500,'message':'Internal Server Error'}";
		   }
		
	}
}
