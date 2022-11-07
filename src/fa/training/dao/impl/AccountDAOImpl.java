package fa.training.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.dao.AccountDAO;
import fa.training.entities.Account;
import fa.training.entities.Employee;
import fa.training.utils.HibernateUtils;

public class AccountDAOImpl extends CommonDAOImpl<Account> implements AccountDAO{

	private static SessionFactory factory = HibernateUtils.getSessionFactory();
	
	@Override
	public Account findByUsername(String username) {
		
		Session session = null;
		
		try {
			String hql = "SELECT a FROM Account a WHERE a.account =: username";
			
			session = factory.openSession();
			
			Query<Account> query = session.createQuery(hql, Account.class);
			query.setParameter("username", username);
			
			Account account = query.uniqueResult();
			
			return account;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean deleteByid(int accountId) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			String hql = "DELETE Account a WHERE a.accountId = :accountId";	
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Query<Account> query = session.createQuery(hql);
			query.setParameter("accountId", accountId);
			
			int rowEffect = query.executeUpdate();
			
			transaction.commit();
			
			return rowEffect > 0;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

}
