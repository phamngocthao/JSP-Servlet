
package fa.training.controller;

import java.io.IOException;
import java.util.List;

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
import fa.training.utils.SessionUtils;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/list")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static EmployeeDAO employeeDao;
	
	
	@Override
	public void init() throws ServletException {
	 	employeeDao = new EmployeeDAOImpl();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		loadPage(request, response);
		
		PageInfor.prepareForwardAfterLogin(request, response, PageType.EMPLOYEE_LIST_PAGE);
		
//		PrepareForwardAfterLogin.prepareForwardAfterLogin(request, response, PageType.EMPLOYEE_LIST_PAGE);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void loadToHome(HttpServletRequest request, HttpServletResponse response) {
		
		List<Employee> employees = employeeDao.findAll();
		
		request.setAttribute("employees", employees);
	}

	
	protected void loadPage(HttpServletRequest request, HttpServletResponse response) {
			
		try {
			String search = request.getParameter("search");
			
			int getTotal = Integer.parseInt(employeeDao.count().toString());
			
			List<Employee> employees = null;
			
			int pageSize = 2;
			
			int totalPage = 0;
				
			totalPage = getTotal/pageSize;
			
			if(getTotal % pageSize != 0) {
				totalPage++;
			}

			String index = request.getParameter("index");
			
			if(index == null) {
				index = "1";
			}
			int indexPage = Integer.parseInt(index);
			
			if(indexPage > totalPage) {
				indexPage = 1;
			}
			if(indexPage < 1) {
				indexPage = totalPage;
			}
			
//			List<Employee> employees = employeeDao.findAllAndPage(indexPage, pageSize);
			
			if(search == null || search.equals("")) {
				employees = employeeDao.findAllAndPage(indexPage, pageSize);
				
			}
			else {
							
				getTotal = employeeDao.countSearch(search);
				
				totalPage = getTotal/pageSize;
				
				if(getTotal % pageSize != 0) {
					totalPage++;
				}
				
				if(indexPage > totalPage) {
					indexPage = 1;
				}
				if(indexPage < 1) {
					indexPage = totalPage;
				}
					
				employees = employeeDao.findAllAndPageAndSearch(indexPage, pageSize, search);
				
			}

			request.setAttribute("employees", employees);
			
			request.setAttribute("indexPage", indexPage);
			
			request.setAttribute("totalPage", totalPage);
			
			request.setAttribute("index", index);
			
			request.setAttribute("search", search);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
}
