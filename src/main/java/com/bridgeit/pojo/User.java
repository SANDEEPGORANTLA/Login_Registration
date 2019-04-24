package com.bridgeit.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="user")  
public class User 
{
	@Column(name = "Name")
	private String Name;
	@Column(name="DoB")
	private String doB;
	@Id
	@Column(name="userName")
	private String userName;
	@Column
	private String Phone;
	@Column
	private String password;
	@Column
	private String Email;
	
	public User() 
	{
		
	}
	public User(String name, String doB, String userName, String phone, String password, String email) 
	{

		Name = name;
		this.doB = doB;
		this.userName = userName;
		Phone = phone;
		this.password = password;
		Email = email;
	}
	@Override
	public String toString() 
	{
		return "User [Name=" + Name + ", doB=" + doB + ", userName=" + userName + ", Email=" + Email + ", Phone="
				+ Phone + ", password=" + password +  "]";
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}	
	public String getName()
	{
		return Name;
	}
	public void setName(String name) 
	{
		Name = name;
	}
	public String getDoB() 
	{
		return doB;
	}
	public void setDoB(String doB) 
	{
		this.doB = doB;
	}
	public String getEmail()
	{
		return Email;
	}
	public void setEmail(String email) 
	{
		Email = email;
	}
	public String getPhone() 
	{
		return Phone;
	}
	public void setPhone(String phone) 
	{
		Phone = phone;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
}
