package com.demo.model;

import java.time.LocalDate;
import java.util.Date;

public class Patient {
	private int id;
	private String name;
	private String mobile;
	private Date date;
	
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", mobile=" + mobile + ", date=" + date + "]";
	}
	
	
	
	

}
