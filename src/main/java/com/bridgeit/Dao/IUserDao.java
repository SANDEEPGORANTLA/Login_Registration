package com.bridgeit.Dao;

import com.bridgeit.pojo.User;

public interface IUserDao 
{
	 String regCustomer(User user);
	 
	 public boolean loginCustomer(String userName,String password);

}
