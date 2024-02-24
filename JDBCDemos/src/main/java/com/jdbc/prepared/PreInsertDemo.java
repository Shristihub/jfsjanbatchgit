package com.jdbc.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreInsertDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jfsjanbatch";
		String username = "root";
		String password = "root";
		String sql = "insert into student(stud_name,stud_id,department,city) values(?,?,?,?)";
		
		try(Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement statement = connection.prepareStatement(sql);){
			statement.setString(1, "John");
			statement.setInt(2, 1);
			statement.setString(3, "CSE");
			statement.setString(4, "Bangalore");
			boolean result = statement.execute();
			System.out.println("One row inserted" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
