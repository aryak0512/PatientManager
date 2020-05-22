package com.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.model.Patient;
import com.demo.model.Session;
import com.demo.model.User;


	@Component
	public class DB {
		String url="jdbc:mysql://localhost:3306/medical";
		String username="root";
		String password="";
		String driverClassName="com.mysql.jdbc.Driver";
		Connection conn;
	
		//Step 2
		private void dbConnect() throws ClassNotFoundException, SQLException{
			//Load the driver
			Class.forName(driverClassName);
			//establish the connection
			conn = DriverManager.getConnection(url, username, password);
		}
        /*
		//connect DB class to datasource
		private NamedParameterJdbcTemplate jdbc;
		@Autowired
		public void setDataSource(DataSource dataSource) {
			jdbc=new NamedParameterJdbcTemplate(dataSource);
		}
		*/
		public void insertPatient(Patient p) throws ClassNotFoundException, SQLException {
			
			LocalDate date= LocalDate.now();
			//System.out.println(date);
			dbConnect();
			String sql="insert into patients (name,mobile,date) values(?,?,?)";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, p.getName().toUpperCase());
			pstmt.setString(2, p.getMobile());
			pstmt.setObject(3, date);
			pstmt.executeUpdate();	
			
			/*
			String[] names = p.getName().toUpperCase().split(" ");
			
			int id=0;
			String sql1="select id from patients where name=?";
			 //Step 3: creating the statement
			 PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			 pstmt1.setString(1,p.getName().toUpperCase());
			 ResultSet rst1=pstmt1.executeQuery();
			 while(rst1.next()) {	
			 id=rst1.getInt("id");
			 }
			 String table_name=names[0]+id;
			 //System.out.println("TABLE NAME IS:"+table_name);
			 String sql2="CREATE TABLE "+table_name+" ( `arrival` INT(11) NOT NULL AUTO_INCREMENT , `visited` DATE NOT NULL , `issue` TEXT NOT NULL , `medicines` VARCHAR(100) NOT NULL , `amount` DOUBLE NOT NULL , `balance` DOUBLE NOT NULL DEFAULT '0.00' , PRIMARY KEY (`arrival`)) ENGINE = InnoDB;";
			 //Step 3: creating the statement
			 PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			 pstmt2.executeUpdate();
			 */
		}
		
		
		public List<Patient> getPatients() throws SQLException, ClassNotFoundException{
			dbConnect();
			String sql="select * from patients";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			ResultSet rst=pstmt.executeQuery();
			List<Patient> list=new ArrayList();
			while(rst.next()) {
				int id=rst.getInt("id");
				String name=rst.getString("name");
				String mobile=rst.getString("mobile");
				Date date=rst.getDate("date");
				Patient p =new Patient();
				p.setId(id);
				p.setName(name);
				p.setMobile(mobile);
				p.setDate(date);
				list.add(p);	
			}
			rst.close();
			return list;
		}
		public List<Patient> searchPatient(String nameLike) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			
			dbConnect();
			String sql="select * from patients where name like '%"+nameLike+"%'";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			//pstmt.setString(1, nameLike.toUpperCase());
			ResultSet rst=pstmt.executeQuery();
			List<Patient> list=new ArrayList();
			while(rst.next()) {
				int id=rst.getInt("id");
				String name=rst.getString("name");
				String mobile=rst.getString("mobile");
				Date date=rst.getDate("date");
				Patient p =new Patient();
				p.setId(id);
				p.setName(name);
				p.setMobile(mobile);
				p.setDate(date);
				list.add(p);	
			}
			rst.close();
			return list;
			
		}
		public List<Patient> getPatient(int iD) throws ClassNotFoundException, SQLException {
			dbConnect();
			String sql="select * from patients where id=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, iD);
			ResultSet rst=pstmt.executeQuery();
			List<Patient> list=new ArrayList();
			while(rst.next()) {
				int id=rst.getInt("id");
				String name=rst.getString("name");
				String mobile=rst.getString("mobile");
				Date date=rst.getDate("date");
				Patient p =new Patient();
				p.setId(id);
				p.setName(name);
				p.setMobile(mobile);
				p.setDate(date);
				list.add(p);	
			}
			rst.close();
			return list;
		}
		public List<Session> getSession(int id) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			dbConnect();
			String sql="select * from session where id=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rst=pstmt.executeQuery();
			List<Session> session=new ArrayList();
			while(rst.next()) {
				Date date=rst.getDate("date");
				String issues= rst.getString("issues");
				String medicines= rst.getString("medicines");
				double balance = rst.getDouble("balance");
				double amount = rst.getDouble("amount");
				int sid=rst.getInt("sid");
				Session s=new Session();
				s.setAmount(amount);
				s.setId(sid);
				s.setBalance(balance);
				s.setIssues(issues);
				s.setMedicines(medicines);
				s.setDate(date);
				session.add(s);	
			}
			rst.close();
			return session;
		}
		public void addSession(Session s) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			LocalDate date= LocalDate.now();
			//System.out.println(date);
			dbConnect();
			String sql="insert into session (id,date,issues,medicines,amount,balance) values(?,?,?,?,?,?)";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1,s.getId());
			pstmt.setObject(2, date);
			pstmt.setString(3, s.getIssues());
			pstmt.setString(4, s.getMedicines());
			pstmt.setDouble(5, s.getAmount());
			pstmt.setDouble(6, s.getBalance());
			pstmt.executeUpdate();	
			
		}
		public double getTodaysIncome() throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			double todays_income=0.0;
			double total_amount=0.0;
			double total_balance=0.0;
			LocalDate date= LocalDate.now();
			
			//System.out.println(month);
			dbConnect();
			String sql="select sum(amount),sum(balance) from session where date=?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, date.toString());
			ResultSet rst=pstmt.executeQuery();
			while(rst.next()) {
				total_amount=rst.getDouble("sum(amount)");
				total_balance=rst.getDouble("sum(balance)");
			}
			todays_income=total_amount-total_balance;
			rst.close();
			return todays_income;
			
		}
		public double getMonthIncome() throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			double todays_income=0.0;
			double total_amount=0.0;
			double total_balance=0.0;
			LocalDate date= LocalDate.now();
			String month =date.toString().substring(5, 7);
			//System.out.println(month);
			dbConnect();
			String sql="select sum(amount),sum(balance) from session where date like '%-"+month+"-%'";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next()) {
				total_amount=rst.getDouble("sum(amount)");
				total_balance=rst.getDouble("sum(balance)");
			}
			todays_income=total_amount-total_balance;
			rst.close();
			return todays_income;
		}
		public void updatePatientinfo(Patient patient) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			dbConnect();
			String sql="update patients set name='"+patient.getName()+"', mobile='"+patient.getMobile()+"' where id="+patient.getId()+"";
			
			System.out.println(sql);
			PreparedStatement pstmt= conn.prepareStatement(sql);
			//pstmt.setString(1, patient.getName());
			//pstmt.setString(2, patient.getMobile());
			//pstmt.setInt(1, patient.getId());
			pstmt.executeUpdate(sql);

		
			
		}
		public double getMonthlyIncomes(String s) throws ClassNotFoundException, SQLException {
			double monthly_income=0.0;
			double total_amount=0.0;
			double total_balance=0.0;
			
			dbConnect();
			String sql="select sum(amount),sum(balance) from session where date like '%-"+s+"-%'";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next()) {
				total_amount=rst.getDouble("sum(amount)");
				total_balance=rst.getDouble("sum(balance)");
			}
			monthly_income=total_amount-total_balance;
			rst.close();
			return monthly_income;
		}
		public double getMonthlyLosses(String s) throws ClassNotFoundException, SQLException {
			double monthly_loss=0.0;
			dbConnect();
			String sql="select sum(balance) from session where date like '%-"+s+"-%'";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next()) {
				monthly_loss=rst.getDouble("sum(balance)");
			}
			rst.close();
			return monthly_loss;
		}

	}



