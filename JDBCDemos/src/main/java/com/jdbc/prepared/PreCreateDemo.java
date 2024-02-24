package com.jdbc.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreCreateDemo {

	public static void main(String[] args) {
		 String url = "jdbc:mysql://localhost:3306/jfsjanbatch";
		 String username="root";
		 String password="root";
		 String sql = "create table student(stud_name varchar(20),stud_id integer primary key, department varchar(20), city varchar(20))";
		 try(Connection connection = DriverManager.getConnection(url,username,password);
			 PreparedStatement	statement = connection.prepareStatement(sql);) {
			boolean result = statement.execute();
			System.out.println("Table created"+ result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
