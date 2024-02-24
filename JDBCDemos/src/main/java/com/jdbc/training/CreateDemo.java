package com.jdbc.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDemo {
 public static void main(String[] args) {
	 Connection connection = null;
	 String url = "jdbc:mysql://localhost:3306/jfsjanbatch";
	 String username="root";
	 String password="root";
	 Statement statement = null;
	 String sql = "create table employee(emp_name varchar(20),emp_id integer primary key, salary float, city varchar(20))";
	 try {
		connection = DriverManager.getConnection(url,username,password);
		statement = connection.createStatement();
		boolean result = statement.execute(sql);
		System.out.println("Table created"+ result);
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
