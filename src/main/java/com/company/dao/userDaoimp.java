package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.util.DBUtil;

public class userDaoimp implements userDao {

	@Override
	public boolean isValiduser(String username, String password) {
		String query="select * from users where username= ? AND password=?";
		try (Connection connection=DBUtil.getConnection();
				PreparedStatement preparedstatement=connection.prepareStatement(query)){
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);
			ResultSet resultset=preparedstatement.executeQuery();
			System.out.println("query run ho gai");
			return resultset.next();
			
				}catch(SQLException e)
		{
					e.printStackTrace();
		}
			
		
		
		return false;
	}
	@Override
	public boolean addUser(user user) {
		String query="insert into user (username,password,email) values (?, ?, ?)";
		try (Connection connection=DBUtil.getConnection();
				PreparedStatement preparedstatement=connection.prepareStatement(query)){
			preparedstatement.setString(1, user.getUsername());
			preparedstatement.setString(2, user.getPassword());
			preparedstatement.setString(3, user.getEmail());
			int rows =preparedstatement.executeUpdate();
			System.out.println("user added");
			return rows>0;	
	}
		catch(SQLException e)
		{
		e.printStackTrace();
}
		return false;
	
	}}
