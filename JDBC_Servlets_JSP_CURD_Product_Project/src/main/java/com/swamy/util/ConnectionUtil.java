package com.swamy.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static Connection con;
	
	static {
		try {
			Class.forName(DRIVER_CLASS_NAME);
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return con;
	}
}

