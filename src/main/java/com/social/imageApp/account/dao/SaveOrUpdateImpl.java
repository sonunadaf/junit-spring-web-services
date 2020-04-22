package com.social.imageApp.account.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.social.imageApp.account.entity.User;

@Repository
public class SaveOrUpdateImpl implements ISaveOrUpdateDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = Logger.getLogger(SaveOrUpdateImpl.class);

	public SaveOrUpdateImpl() {
		logger.info("Created : " + this.getClass().getSimpleName());
	}

	public void saveOrUpdate(User user) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(user);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		}
	}

}
