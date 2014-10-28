package com.planit.operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.planit.utils.DatabaseUtil;


public class BasicEvents {
	
	public static void main(String[] args) {
		Register.register();
	}
	
	public static class Register {
		public static void register() {
			Scanner scan = new Scanner(System.in);
			System.out.print("input username : ");
			String userName = scan.next();
			System.out.println("input password : ");
			String password = scan.next();

			DatabaseUtil.connect();
			try {
				String sql = "insert into User (Name,Password) values(?,?)";
				PreparedStatement preparedStmt = DatabaseUtil.conn.prepareStatement(sql);
				preparedStmt.setString(1, userName);
				preparedStmt.setString(2, password);
				preparedStmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				Logout.logout();
			}
		
		}
	}
	
	public static class Login {

		public static void login(String userName, String password) {
			DatabaseUtil.connect();
			try {
				Statement stmt = DatabaseUtil.conn.createStatement();
				String sql = "select Password from User where Name = '"+userName+"'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next() && rs.getString(1).equals(password)) {
					//load user jiemian and data
					System.out.println("login....");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				Logout.logout();
			}
		} 
	}
	
	public static class Logout {
		public static void logout() {
			
		}
	}
}

