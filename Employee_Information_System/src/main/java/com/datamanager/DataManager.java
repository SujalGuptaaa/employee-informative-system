package com.datamanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.RegistrationModal;

public class DataManager {
	private Connection connection;
	public void getConnection() 
	{
		String url = "jdbc:mysql://localhost:3306/employeedb";
		String user = "root";
		String pasword = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registred...");
			connection = DriverManager.getConnection(url, user, pasword);
			System.out.println("Connection Established successfully...");
		}
		catch(Exception e) 
		{
			System.out.println("Exception caught: "+e);
		}
	}
	public int datainsert(RegistrationModal registrationModal) 
	{
		getConnection();
		String fname = registrationModal.getFirstName();
		String lname = registrationModal.getLastName();
		String email = registrationModal.getEmail();
		String contactno = registrationModal.getContactNo();
		String country = registrationModal.getCountry();
		int i = 0;
		try {
			String query = "insert into tbl_employee values (?,?,?,?,?)";
			PreparedStatement psmt = connection.prepareStatement(query);
			psmt.setString(1,fname);
			psmt.setString(2,lname);
			psmt.setString(3, contactno);
			psmt.setString(4, email);
			psmt.setString(5, country);
			
			i = psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Exception handaled: "+e);
		}
		return i;
		/*System.out.println("First Name is: "+fname);
		System.out.println("Last Name is: "+lname);
		System.out.println("Email is: "+email);
		System.out.println("Contact is: "+contactno);
		System.out.println("Country is: "+country);*/
	}
	public ResultSet displayInf() 
	{
		getConnection();
		try {
			String query = "select * from tbl_employee";
			PreparedStatement psmt = connection.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			return rs;
		}
		catch(Exception e)
		{
			System.out.println("Exception handaled: "+e);
		}
		return null;
	}

}
