package com.bridgeit.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bridgeit.hibernetUtility.HiberneatUtil;
import com.bridgeit.pojo.User;

public class UserDaoImple implements IUserDao {
	private static UserDaoImple userDaoImple = null;
	private static SessionFactory sessionFactory = HiberneatUtil.getSessionFactory();

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

	public boolean loginCustomer(String userName, String password) {
		Session session = sessionFactory.openSession();
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

}
