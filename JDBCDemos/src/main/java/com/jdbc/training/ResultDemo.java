package com.jdbc.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultDemo {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs =null;
		String url = "jdbc:mysql://localhost:3306/jfsjanbatch";
		String username = "root";
		String password = "root";
		String ncity="Bangalore";
		String sql = "select * from employee where city='"+ncity+"'";
		// try with resources -> closing the resources
		// we dont have to use finally to close the resources
		// try(// add all the resources)
		
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("emp_name");
				int empId = rs.getInt("emp_id");
				double sal = rs.getDouble(3);
				String city = rs.getString("city");
				System.out.println(name + "\t" + empId + "\t" + sal + "\t" + city);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
