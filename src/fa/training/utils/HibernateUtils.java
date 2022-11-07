package fa.training.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import fa.training.entities.Account;
import fa.training.entities.Employee;

public class HibernateUtils {
	private static SessionFactory sessionFactory;

	 public static SessionFactory getSessionFactory() {
	  if (sessionFactory == null) {
	   try {
	    Configuration configuration = new Configuration();

	    // Hibernate settings equivalent to hibernate.cfg.xml's properties
	    Properties settings = new Properties();
	    settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    settings.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=CarPark");
	    settings.put(Environment.USER, "sa");
	    settings.put(Environment.PASS, "1234567890");
	    settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2012Dialect");

	    settings.put(Environment.SHOW_SQL, "true");
	    settings.put(Environment.FORMAT_SQL, "true");

	    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	    settings.put(Environment.HBM2DDL_AUTO, "update");

	    configuration.setProperties(settings);
	    configuration.addAnnotatedClass(Employee.class);
	    configuration.addAnnotatedClass(Account.class);

	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	      .applySettings(configuration.getProperties()).build();
	    System.out.println("Hibernate Java Config serviceRegistry created");
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;

	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  return sessionFactory;
	 }
	
}
