package com.jdbc.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDemoScanner {
	public static void main(String[] args) {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/jfsjanbatch";
		String username = "root";
		String password = "root";
		Statement statement = null;
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			for (int i = 0; i <= 4; i++) {
				String name = sc.next();
				int empId = sc.nextInt();
				double sal = sc.nextDouble();
				String city = sc.next();
				String sql = "insert into employee values('" + name + "'," + empId + "," + sal + ",'" + city + "')";

				connection = DriverManager.getConnection(url, username, password);
				statement = connection.createStatement();
				boolean result = statement.execute(sql);
				System.out.println("One row inserted" + result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
				sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
