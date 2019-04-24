package com.bridgeit.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Parameter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridgeit.hibernetUtility.HiberneatUtil;
import com.bridgeit.pojo.User;

public class UserDaoImple implements IUserDao{
	private static  UserDaoImple userDaoImple = null;
	private static  SessionFactory sessionFactory = HiberneatUtil.getSessionFactory();
	
	public static UserDaoImple getinstance() {
		if (userDaoImple == null)
			userDaoImple = new UserDaoImple();
		return userDaoImple;

	}
	public String regCustomer(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String username = (String) session.save(user);
		transaction.commit();
		session.close();

		return username;
	}
	 @SuppressWarnings("deprecation")
	public static boolean getLoginDetails(User user){
		 Session  session=sessionFactory.openSession();
         Transaction tx = session.getTransaction();
         tx.begin();
         String userName=user.getUserName();
         System.err.println(userName);
         String password=user.getPassword();
         System.err.println(password);
         String SQL_QUERY =  "from User  where userName= :userName and password=:password";         
         Query q =session.createQuery(SQL_QUERY); 
         q.setString("userName", userName);
         q.setString("password", password);
         
         User resultSet = (User)q.uniqueResult();
         tx.commit();
         List<User> textList = session.createQuery("from User").list();
//         List<Integer> list=q.list();  
         System.out.println(textList);
//        for( Iterator it=resultSet.iterate();it.hasNext();)  
//      {  
//      User u = (User)it.next();  
//     
//     user.setUserName(u.getUserName());
//     user.setPassword(u.getPassword()); 
//   
//      } 
        if (userName.contains(user.getUserName())&& password.contains(user.getPassword()))
        		{
        	return true;
			
		}
       
//         System.out.println(list.get(0));  
         session.close();
//         Query query = (Query) session.createQuery(SQL_QUERY);     
////         query.ex
//            for(@SuppressWarnings("rawtypes")
//			Iterator it=query.iterate();it.hasNext();)  
//            {  
//            User u = (User)it.next();  
//            
//            user.setUserName(u.getUserName());
//            user.setPassword(u.getPassword()); 
//            
//            }  
//         session.getTransaction().commit();     
//         session.close();  
    return false;   
    }
	 
	 
	 
	 
	public boolean loginCustomer(String userName, String password) {
		 Session  session=sessionFactory.openSession();
		  if (session != null) {
		   try {
		    User user = (User) session.get(User.class, userName);
		    if (password.equals(user.getPassword())) {
		     System.out.println("User: " + user.toString());
		     return true;
		    }
		   } catch (Exception exception) {
		  		    return false;
		   }

		  } else {
		   System.out.println("DB server down.....");
		  }
		  return false;
		}


	
	

//	public boolean loginCustomer(String userName,String password) {
//		User user = getUserbyid(userName,password);
//		System.out.println(user.toString());
//		if(userName.contains(user.getUserName())&&password.contains(user.getPassword()))
//		{
//			return true;
//			
//		}		
//		return false;
//	}
	@SuppressWarnings("deprecation")
	public User getUserbyid(String userName,String password)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = null;
		try {
		transaction=session.getTransaction();
		//transaction.begin();
		String sqlQuery = "FROM user  where userName="+userName+"and password="+password;
		System.out.println("saef");
		Query query=session.createQuery(sqlQuery);
		//user= (User) query.getParameter("userName");
		
		transaction.commit();
	
		}catch (Exception e) {
			 if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
		}
		finally {
			session.close();
		}
		return user;
		
	}
//	public User getUserbyid(String userName,String password)
//	{
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		User user = null;
//		try {
//		transaction=session.getTransaction();
//		//transaction.begin();
//		 String query = "from Login login where loginId=? and password=?";
//		  Query queryObj = session.createQuery(query);
//		  queryObj.setString(0, userName);
//		  queryObj.setString(1, password);
//		  List<User> records = queryObj.list();
//		  if(records.size()>0){
//		 System.out.println("sessuuufd");
//		  }else{
//			  System.out.println("invalid");
//		  
//		  }
//		transaction.commit();
//	
//		}catch (Exception e) {
//			 if (transaction != null) {
//	                transaction.rollback();
//	            }
//	            e.printStackTrace();
//		}
//		finally {
//			session.close();
//		}
//		return user;
//		
//	}
//	public   List<User> getUsers(){
//		List<User> list= new ArrayList<User>();
//		Session session= sessionFactory.openSession();
//		Transaction transaction = null;
//		try {
//			transaction=session.beginTransaction();
//			transaction.begin();
//			list=session.createQuery("from user").list();
//			transaction.commit();
//			
//		} catch (Exception e) {
//			if (transaction != null) {
//                transaction.rollback();
//            }
//		}
//			finally 
//			{
//				session.close();
//			}
//		
//		return list;
//	}
//	

}
