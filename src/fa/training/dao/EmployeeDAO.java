package fa.training.dao;

import java.util.List;

import fa.training.entities.Employee;

public interface EmployeeDAO extends CommonDAO<Employee>{

	List<Employee> findAll();

	Employee findById(int empId);
	
	List<Employee> findAllAndPage(int indexPage,int pageSize);
	
	List<Employee> findAllAndPageAndSearch(int indexPage,int pageSize, String search);
	
	int countSearch(String search);
	
	Long count();

	boolean deleteByid(int employeeId);
	
}
