package com.jdbc.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultDemoTryResources {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jfsjanbatch";
		String username = "root";
		String password = "root";
		String ncity="Bangalore";
		String sql = "select * from employee where city='"+ncity+"'";
		// try with resources -> closing the resources
		// we dont have to use finally to close the resources
		// try(// add all the resources)
		
		try( Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			){
			while (rs.next()) {
				String name = rs.getString("emp_name");
				int empId = rs.getInt("emp_id");
				double sal = rs.getDouble(3);
				String city = rs.getString("city");
				System.out.println(name + "\t" + empId + "\t" + sal + "\t" + city);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
