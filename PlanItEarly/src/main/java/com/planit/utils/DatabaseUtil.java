package com.planit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

	public static Connection conn;
	
	public static void main(String[] args) {
		connect();
		close();
	}

	public static void connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("load com.mysql.jdbc.Driver failed...");
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/PlanItEarly";
		try {
			 conn =  DriverManager.getConnection(url, "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
