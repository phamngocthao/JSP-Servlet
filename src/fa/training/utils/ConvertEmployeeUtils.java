package fa.training.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.entities.Account;
import fa.training.entities.Employee;

public class ConvertEmployeeUtils {

	
	public static Employee convertEmployeeFromParameter(
			Employee employee,HttpServletRequest request, HttpServletResponse respone) {

		employee.setFirstName(request.getParameter("firstName"));
		employee.setLastName(request.getParameter("lastName"));
		employee.setGender(Integer.parseInt(request.getParameter("gender")));
		employee.setDateOfBirth(DateUtils.convertDate(request.getParameter("dateOfBirth")));
		employee.setPhone(request.getParameter("phone"));
		employee.setAddress(request.getParameter("address"));
		employee.setDepartmentName(request.getParameter("departmentName"));
		employee.setRemark(request.getParameter("remark"));
		
		Account account = new Account();
		
		if(employee.getAccount() != null) {
			account = employee.getAccount();
		}
		
		
		System.out.println(request.getParameter("account"));
		
		account.setAccount(request.getParameter("account"));
		account.setEmail(request.getParameter("email"));
		account.setPassword(request.getParameter("password"));
		account.setStatus(Integer.parseInt(request.getParameter("status") == null ? "0" : request.getParameter("status")));
		
		employee.setAccount(account);
		
		account.setEmployee(employee);
		
		return employee;
	}
	
	
}
