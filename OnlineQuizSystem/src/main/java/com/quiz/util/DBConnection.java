package com.quiz.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Database driver loaded successfully.");
		} catch (Exception e) {
			System.out.println("Error: Database driver not found.");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		Properties prop = new Properties();
		InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("application.properties");
		prop.load(input);

		String url = prop.getProperty("db.url");
		String user = prop.getProperty("db.username");
		String password = prop.getProperty("db.password");

		return DriverManager.getConnection(url, user, password);
	}
}
