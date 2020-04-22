package com.social.imageApp.account.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.social.imageApp.account.entity.User;
import com.social.imageApp.account.entity.UserType;

@Repository
public class GetUserDaoImpl implements IGetUserDao {
	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = Logger.getLogger(GetUserDaoImpl.class);

	public GetUserDaoImpl() {
		logger.info("Created : " + this.getClass().getSimpleName());
	}

	public User getUserByUserName(String userName) {
		Session session = sessionFactory.openSession();
		try {
			String hql = "from User where userName =:un";
			Query query = session.createQuery(hql);
			query.setParameter("un", userName);
			User user = (User) query.uniqueResult();
			return user;
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			throw new HibernateException(e.getMessage());
		} finally {
			session.close();
		}
	}

	public User getAdmin() throws Exception {
		Session session = sessionFactory.openSession();
		try {
			String hql = "from User where userRole=:ul";
			Query query = session.createQuery(hql);
			query.setParameter("ul", UserType.ADMIN.toString());
			User user = (User) query.uniqueResult();
			return user;
		} catch (HibernateException e) {
			throw new HibernateException(e.getMessage());
		} finally {
			session.close();
		}
	}

}
