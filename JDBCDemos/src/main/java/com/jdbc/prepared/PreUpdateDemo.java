package com.jdbc.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreUpdateDemo {

	public static void main(String[] args) {
		 String url = "jdbc:mysql://localhost:3306/jfsjanbatch";
		 String username="root";
		 String password="root";
		 String sql = "update student set city=? where stud_id=?";
		 try(Connection connection = DriverManager.getConnection(url,username,password);
			 PreparedStatement	statement = connection.prepareStatement(sql);) {
			 // use the position of the ? not the column index
			 // first ? is for city, second ? assign studentId
			 statement.setString(1, "Bangalore");
			 statement.setInt(2, 5);
			 int result = statement.executeUpdate();
			System.out.println("Table updated"+ result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
