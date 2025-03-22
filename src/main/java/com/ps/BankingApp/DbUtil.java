package com.ps.BankingApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	 private static final String URL = "jdbc:mysql://localhost:3306/your_database";
	    private static final String USER = "your_username";
	    private static final String PASSWORD = "your_password";

	    static {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("JDBC Driver loaded successfully.");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            System.err.println("Error loading JDBC Driver: " + e.getMessage());
	        }
	    }

	    public static Connection getConnection() throws SQLException {
	        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
	        System.out.println("Connected to the database.");
	        return connection;
	    }
}
