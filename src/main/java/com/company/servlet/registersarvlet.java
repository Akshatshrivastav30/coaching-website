package com.company.servlet;
import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registersarvlet
 */
@WebServlet("/registersarvlet")
public class registersarvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	///private static userDaoimp userDao =new userDaoimp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registersarvlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usernamee=request.getParameter("username");
		String passwordss=request.getParameter("password");
		String email=request.getParameter("email");
         int rowsAffecteds=0;
	     try {
	            String url = "jdbc:mysql://localhost:3306/company";
	            String userName = "root";
	            String password = "Babu934oo";
	            
	            // Using parameterized query to prevent SQL injection
	            
	            String query2 = "INSERT INTO register (uname, password,email) VALUES (?, ?,?)";

	            Class.forName("com.mysql.jdbc.Driver"); // Load the MySQL JDBC driver

	            Connection con = DriverManager.getConnection(url, userName, password);
	            
	            PreparedStatement qt = con.prepareStatement(query2);
	            
	            // Set username and password as parameters
	            qt.setString(1, usernamee);
	            qt.setString(2, passwordss);
	            qt.setString(3, email);

	           
	             rowsAffecteds = qt.executeUpdate(); 
	            // Execute the query and get the number of rows affected

	           
	            System.out.println("Number of rows affected by this query: " + rowsAffecteds);
	            
	            // Close PreparedStatement and Connection
	            qt.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	     if(rowsAffecteds==1) {
	    	 response.sendRedirect("index.html");
	    	 
	     }
	     else {
	    	 response.sendRedirect("register.jsp");
	     }
        
		
	}
		

}
