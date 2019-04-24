package com.bridgeit.hibernetUtility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberneatUtil 
{
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			Configuration configuration= new Configuration().configure("hibernate.cfg.xml");
			sessionFactory=configuration.buildSessionFactory();	
		}
		return sessionFactory;	
	}	
}
