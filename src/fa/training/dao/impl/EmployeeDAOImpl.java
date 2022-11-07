package fa.training.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.dao.EmployeeDAO;
import fa.training.entities.Employee;
import fa.training.utils.HibernateUtils;

public class EmployeeDAOImpl extends CommonDAOImpl<Employee> implements EmployeeDAO{

	private static SessionFactory factory = HibernateUtils.getSessionFactory();
	
	
	@Override
	public List<Employee> findAll() {
		
		Session session = null;
		
		try {
			String hql = "SELECT e FROM Employee e";
			session = factory.openSession();
			
			Query<Employee> query = session.createQuery(hql, Employee.class);
			
			List<Employee> employees = query.getResultList();
			
			return employees;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}


	@Override
	public Employee findById(int empId) {
		
		Session session = null;
		
		Transaction transaction = null;
		
		try {
			session = factory.openSession();
			
			Employee emp = session.get(Employee.class, empId);
			
			return emp;
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}


	@Override
	public List<Employee> findAllAndPage(int index,int pageSize) {

		Session session = null;
		
		try {
			
			String hql = "SELECT e FROM Employee e ORDER BY e.employeeId DESC";
			
			session = factory.openSession();
			
			Query<Employee> query = session.createQuery(hql, Employee.class);
			query.setFirstResult((index-1)*pageSize);
			query.setMaxResults(pageSize);
			
			List<Employee> employess = query.getResultList();
			
			
			return employess;
		} finally {
			if(session != null) {
				session.close();
			}
		}

	}


	@Override
	public Long count() {
		
		Session session = null;
		
		try {
			String hql = "SELECT COUNT(e) FROM Employee e";
			
			session = factory.openSession();
			
			Query<Long> query = session.createQuery(hql, Long.class);
			
			query.getResultList();
			
			return query.getSingleResult();
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		
	}


	@Override
	public List<Employee> findAllAndPageAndSearch(int indexPage, int pageSize, String search) {
		Session session = null;
		
		try {
			
//			String hql = "SELECT e FROM Employee e WHERE e.firstName LIKE :search "
//					+ "OR e.lastName LIKE :search OR e.address LIKE :search OR "
//					+ "e.phone LIKE :search OR e.departmentName LIKE :search "
//					+ "ORDER BY e.dateOfBirth DESC";
			
			String sql = "select * from Employee where first_name like :search or last_name like :search\r\n"
					+ "or phone like :search or address like :search or department_name like :search";
			
			session = factory.openSession();
			
//			Query<Employee> query = session.createQuery(hql, Employee.class);
			Query<Employee> query = session.createNativeQuery(sql,Employee.class);
			query.setParameter("search", "%"+search+"%");
			query.setFirstResult((indexPage-1)*pageSize);
			query.setMaxResults(pageSize);
			
			List<Employee> employess = query.list();
	
			return employess;
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
	}


	@Override
	public int countSearch(String search) {
		Session session = null;
		
		try {
			String hql = "SELECT e FROM Employee e WHERE e.firstName LIKE :search "
					+ "OR e.lastName LIKE :search OR e.address LIKE :search "
					+ "OR e.phone LIKE :search OR e.departmentName LIKE :search";
			
			session = factory.openSession();
			
			Query<Employee> query = session.createQuery(hql, Employee.class);
			query.setParameter("search", "%"+search+"%");
			
			List<Employee> emps = query.getResultList();
			
			return emps.size();
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean deleteByid(int employeeId) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			String hql = "DELETE Employee e WHERE e.employeeId = :employeeId";	
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Query<Employee> query = session.createQuery(hql);
			query.setParameter("employeeId", employeeId);
			
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
