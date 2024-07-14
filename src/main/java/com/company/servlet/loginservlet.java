package com.company.servlet;
//import com.company.dao.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.company.dao.userDaoimp;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")

public class loginservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public loginservlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernamee = request.getParameter("username");
        String passwordss = request.getParameter("password");
        
        try {
            String url = "jdbc:mysql://localhost:3306/company";
            String userName = "root";
            String password = "Babu934oo";
            
            // Using parameterized query to prevent SQL injection
            String query = "INSERT INTO coa (uname, password) VALUES (?, ?)";

            Class.forName("com.mysql.jdbc.Driver"); // Load the MySQL JDBC driver

            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(query);
            
            // Set username and password as parameters
            st.setString(1, usernamee);
            st.setString(2, passwordss);

            int rowsAffected = st.executeUpdate(); // Execute the query and get the number of rows affected

            System.out.println("Number of rows affected by this query: " + rowsAffected);
            
            // Close PreparedStatement and Connection
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
