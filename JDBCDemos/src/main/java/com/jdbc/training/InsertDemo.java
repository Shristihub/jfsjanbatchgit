package com.jdbc.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {
	public static void main(String[] args) {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/jfsjanbatch";
		String username = "root";
		String password = "root";
		Statement statement = null;
//		String sql = "insert into employee values('Ram',1,2000,'Chennai')";
		String name="Jo";
		int empId = 2;
		double sal =2000;
		String city="Bangalore";
		
		String sql = "insert into employee values('"+name+"',"+empId+","+sal+",'"+city+"')";
		
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			boolean result = statement.execute(sql);
			System.out.println("One row inserted" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
