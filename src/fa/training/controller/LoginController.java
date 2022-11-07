package fa.training.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fa.training.constant.MessageConstant;
import fa.training.dao.AccountDAO;
import fa.training.dao.impl.AccountDAOImpl;
import fa.training.entities.Account;
import fa.training.entities.Employee;
import fa.training.utils.HibernateUtils;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static AccountDAO accountDao;
	
	@Override
		public void init() throws ServletException {
			accountDao = new AccountDAOImpl();
		}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Account accountExists =  accountDao.findByUsername(username);
		
		if(accountExists != null) {
			
			if(password.equals(accountExists.getPassword())) {
				
				
				request.getSession().setAttribute("username", accountExists);
				
				request.getSession().setAttribute(MessageConstant.LOGIN_SUCCESS, MessageConstant.LOGIN_SUCCESS);
				
				response.sendRedirect("home");
				return;
			}
			else {
				request.setAttribute("error-message", "Mật khẩu sai !!");
			}
		}
		else {
			request.setAttribute("error-message", "Tài khoản không tồn tại !!");
		}
		
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}

}
