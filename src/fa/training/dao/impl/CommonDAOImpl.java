package fa.training.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fa.training.dao.CommonDAO;
import fa.training.utils.HibernateUtils;

public class CommonDAOImpl<E> implements CommonDAO<E>{

	private static SessionFactory factory = HibernateUtils.getSessionFactory();
	
	
	@Override
	public boolean save(E entity) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			session = factory.openSession();
			
			transaction = session.beginTransaction();
			
			Serializable result = session.save(entity);
			
			transaction.commit();
			
			return (result != null);
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		
	}

	@Override
	public boolean update(E entity) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			session = factory.openSession();
			
			transaction = session.beginTransaction();
			
			session.update(entity);
			
			transaction.commit();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	
	
}
