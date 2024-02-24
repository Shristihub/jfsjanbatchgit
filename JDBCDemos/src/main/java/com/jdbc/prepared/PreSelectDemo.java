package com.jdbc.prepared;

import java.sql.*;

public class PreSelectDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jfsjanbatch";
		String username = "root";
		String password = "root";
//		String sql = "select * from student";
		
		try (Connection connection = DriverManager.getConnection(url, username, password);
			 PreparedStatement statement = connection.prepareStatement("select * from student where city=?");
			){
				statement.setString(1, "Bangalore");
		try(
			ResultSet rs = statement.executeQuery();){
			    
			while (rs.next()) {
				String studName = rs.getString("stud_name");
				int studId = rs.getInt("stud_Id");
				String department = rs.getString("department");
				String city = rs.getString("city");
				System.out.println(studName + "\t" + studId + "\t" + department + "\t" + city);

			}
		}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
