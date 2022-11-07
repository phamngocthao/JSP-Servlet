package fa.training.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.common.PageInfor;
import fa.training.common.PageType;
import fa.training.constant.MessageConstant;
import fa.training.dao.AccountDAO;
import fa.training.dao.EmployeeDAO;
import fa.training.dao.impl.AccountDAOImpl;
import fa.training.dao.impl.EmployeeDAOImpl;
import fa.training.entities.Account;
import fa.training.entities.Employee;
import fa.training.utils.ConvertEmployeeUtils;
import fa.training.utils.DateUtils;

@WebServlet(urlPatterns = {"/add","/edit","/update_employee","/add_employee","/delete"})
public class AddEmployeeController extends HttpServlet{

	private static EmployeeDAO employeeDao;
	private static AccountDAO accountDao;
	
	@Override
	public void init() throws ServletException {
		
		employeeDao = new EmployeeDAOImpl();
		accountDao = new AccountDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getServletPath();
		
		try {
			if(uri.contains("/edit")) {
				loadToEditPage(req, resp);
			}
			if(uri.contains("/add")) {
				loadToAddPage(req,resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageInfor.prepareForwardAfterLogin(req, resp, PageType.ADD_EMPLOYEE_PAGE);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uri = req.getServletPath()
				;
		
		try {
			switch (uri) {
			case "/add_employee":
				addEmployee(req, resp);
				break;
			case "/update_employee":
				updateEmployee(req, resp);
				break;
			case "/delete":
				deleteEmployee(req,resp);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		PageInfor.prepareAndForward(req, resp, PageType.ADD_EMPLOYEE_PAGE);
	}
	
	private void loadToAddPage(HttpServletRequest request, HttpServletResponse respone) 
			throws ServletException, IOException, IllegalAccessException{
				
				
//		PageInfor.prepareAndForward(request, respone, PageType.ADD_EMPLOYEE_PAGE);
	}
	
	private void addEmployee(HttpServletRequest request, HttpServletResponse respone) 
			throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		
		respone.setCharacterEncoding("UTF-8");
		
		Employee employeeNew = new Employee();
		
		Employee employee = ConvertEmployeeUtils.convertEmployeeFromParameter(employeeNew,request, respone);
		
		if(employee != null) {
			employeeDao.save(employee);
		}

		request.getSession().setAttribute(MessageConstant.SUCCESS, MessageConstant.SUCCESS);
		
		respone.sendRedirect("list");
	}
	
	private void updateEmployee(HttpServletRequest request, HttpServletResponse respone) 
			throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		
		int empId = Integer.parseInt(request.getParameter("employeeId"));
		Employee empExists = employeeDao.findById(empId);
		
		Employee emp = ConvertEmployeeUtils.convertEmployeeFromParameter(empExists,request, respone);
		
		
		if(empExists != null) {
			
			employeeDao.update(emp);
			
			request.getSession().setAttribute(MessageConstant.SUCCESS, MessageConstant.SUCCESS);
		}
		
		respone.sendRedirect("list");
//		request.getRequestDispatcher("list").forward(request, respone);
		
	}
	
	protected void deleteEmployee(HttpServletRequest request, HttpServletResponse respone) {
		
		try {
			
			int employeeId = Integer.parseInt(request.getParameter("empId"));
			
			Employee employeeIsExists = employeeDao.findById(employeeId);
			
			if(employeeIsExists != null) {
				
				employeeDao.deleteByid(employeeIsExists.getEmployeeId());
				
				request.setAttribute(MessageConstant.SUCCESS, MessageConstant.SUCCESS);
			}
			else {
				request.setAttribute(MessageConstant.ERROR, MessageConstant.ERROR);
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(MessageConstant.ERROR, MessageConstant.ERROR);
		}
		
	}
	
	private void loadToEditPage(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException, IllegalAccessException {
		
		int empId = Integer.parseInt(request.getParameter("empId"));

		Employee employee = employeeDao.findById(empId);
		
		if(employee != null) {
			request.setAttribute("employee", employee);
			request.setAttribute("dateOfBirth", DateUtils.convertDateFromDB(employee.getDateOfBirth()));
		}
		
		
	}
	
	
}
