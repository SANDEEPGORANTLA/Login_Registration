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
@WebServlet("/Registration")
public class RegstrationController  extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		IUserDao userDao = UserDaoImple.getinstance(); 
		
		String name = req.getParameter("name");
		String doB= req.getParameter("dob");
		String userName= req.getParameter("userName");
		String password= req.getParameter("password");
		String confirmPassword= req.getParameter("confirmPassword");
		String phoneNumber= req.getParameter("phoneNumber");
		String email= req.getParameter("emailId");
		User user = new User(name, doB, userName, phoneNumber,password, email);
		

		System.out.println(user);
		if(password.equals(confirmPassword))
		{
			userDao.regCustomer(user);
			req.getRequestDispatcher("Login.jsp").include(req, resp);		
		}	
	}
}
