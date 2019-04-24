package com.bridgeit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.Dao.IUserDao;
import com.bridgeit.Dao.UserDaoImple;
import com.bridgeit.pojo.User;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LogInController  extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String userName= req.getParameter("userName");
		String password=req.getParameter("password");
		
		System.out.println(userName);
		System.out.println(password);
		
		User user=new User(null, null, userName, null, password, null);
		IUserDao userDao = UserDaoImple.getinstance();
		
		user.setUserName(userName);	
		user.setPassword(password);
		boolean flag=userDao.loginCustomer(userName, password);
		if(flag)
		{
			System.out.println("valid");
			req.setAttribute("username", userName);
			req.getRequestDispatcher("user.jsp").include(req, resp);;
		}
		else 
		{
			System.out.println("invalid");
		}
	}

}
