package fa.training.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.common.PageInfor;
import fa.training.common.PageType;
import fa.training.dao.EmployeeDAO;
import fa.training.dao.impl.EmployeeDAOImpl;
import fa.training.entities.Employee;


@WebServlet("/profile")
public class ProfileController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	private static EmployeeDAO employeeDao;
	
	@Override
	public void init() throws ServletException {
		employeeDao = new EmployeeDAOImpl();
	}
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		loadProfilePage(request,response);
		
		PageInfor.prepareAndForward(request, response, PageType.PROFILE_EMPLOYEE);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	protected void loadProfilePage(HttpServletRequest request, HttpServletResponse response) {
		
		int employeeId = Integer.parseInt(request.getParameter("empId"));
		
		Employee employee = employeeDao.findById(employeeId);
		
		request.setAttribute("employee", employee);
		
	}
	
}
