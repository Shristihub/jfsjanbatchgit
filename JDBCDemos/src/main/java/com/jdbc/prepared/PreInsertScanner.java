package com.jdbc.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreInsertScanner {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jfsjanbatch";
		String username = "root";
		String password = "root";
		String sql = "insert into student values(?,?,?,?)";

		// try(// resource){}catch(Exception e){}
		
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement statement = connection.prepareStatement(sql);) {
			for (int i = 0; i <= 4; i++) {
				String name = scanner.next();
				int studId = scanner.nextInt();
				String dept = scanner.next();
				String city = scanner.next();

				statement.setString(1, name);
				statement.setInt(2, studId);
				statement.setString(3, dept);
				statement.setString(4, city);
				boolean result = statement.execute();
				System.out.println("One row inserted" + result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
