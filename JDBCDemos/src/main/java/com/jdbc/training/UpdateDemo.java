package com.jdbc.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {

	public static void main(String[] args) {
		 Connection connection = null;
		 String url = "jdbc:mysql://localhost:3306/jfsjanbatch";
		 String username="root";
		 String password="root";
		 Statement statement = null;
		 
		 String newcity="Ooty";
		 int employId = 1;
		 String sql = "Update employee set city='Hassan' where emp_Id=2";
		 String nsql = "Update employee set city='"+newcity+"' where emp_Id="+employId;
		 try {
			connection = DriverManager.getConnection(url,username,password);
			statement = connection.createStatement();
			
			int result = statement.executeUpdate(sql);
			System.out.println("Updated"+ result);
			
			int result1 = statement.executeUpdate(nsql);
			System.out.println("Updated"+ result1);
		
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
