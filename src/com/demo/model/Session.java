package com.demo.model;

import java.util.Date;

public class Session {
	private int id;
	private Date date;
	private String issues;
	private String medicines;
	private double amount;
	private double balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIssues() {
		return issues;
	}
	public void setIssues(String issues) {
		this.issues = issues;
	}
	public String getMedicines() {
		return medicines;
	}
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", date=" + date + ", issues=" + issues + ", medicines=" + medicines + ", amount="
				+ amount + ", balance=" + balance + "]";
	}
	
	
	
	

}
