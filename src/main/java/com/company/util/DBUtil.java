package com.company.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String url="jdbc:mysql://localhost:3306/coaching";
	private static final String username="root";
	private static final String password="Babu934oo";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
public static Connection getConnection() throws SQLException{
	System.out.println("connection built ho raha hai");
	return DriverManager.getConnection(url,username,password);
}
}
