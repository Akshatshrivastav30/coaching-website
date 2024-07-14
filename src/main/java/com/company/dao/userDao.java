package com.company.dao;

public interface userDao {

	boolean isValiduser(String username, String password);
	public boolean addUser(user user);

}
