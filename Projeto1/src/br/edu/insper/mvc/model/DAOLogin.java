package br.edu.insper.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOLogin {
	private Connection connection =null;
	
	public DAOLogin(){
		try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		connection =DriverManager.getConnection("jdbc:mysql://localhost/projeto1","root","pbeatriz18");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	 public boolean validate(Login login) throws ClassNotFoundException {
	        boolean status = false;

	        Class.forName("com.mysql.jdbc.Driver");

	            PreparedStatement preparedStatement = null;
				try {
					preparedStatement = connection
					.prepareStatement("select * from users where username = ? and password = ? ");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} {
	            try {
					preparedStatement.setString(1, Login.getUsername());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            try {
					preparedStatement.setString(2, Login.getPassword());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	            System.out.println(preparedStatement);
	            ResultSet rs = null;
				try {
					rs = preparedStatement.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            try {
					status = rs.next();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           

	        return status;
	    }
				
				
	 }
	 
	 }
