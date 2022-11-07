package fa.training.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import fa.training.utils.SessionUtils;

public class PageInfor {

	public static Map<PageType, PageInfor> pageRouters = new HashedMap();
	
	static {
		pageRouters.put(PageType.EMPLOYEE_LIST_PAGE, new PageInfor("List Employee","/employee/list.jsp", null));
		pageRouters.put(PageType.DASH_BOARD, new PageInfor("Dashboard", "/employee/dashboard.jsp", null));
		pageRouters.put(PageType.ADD_EMPLOYEE_PAGE, new PageInfor("Add Employee", "/employee/add_employee.jsp", null));
		pageRouters.put(PageType.PROFILE_EMPLOYEE, new PageInfor("Profile","/employee/profile.jsp",null));
	}
	
	
	public static void prepareAndForward(HttpServletRequest request, HttpServletResponse response,PageType pageType) throws ServletException, IOException {
		PageInfor page = pageRouters.get(pageType);
		
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/layout.jsp").forward(request, response);
	}
	
	public static void prepareForwardAfterLogin(HttpServletRequest request,HttpServletResponse response,PageType pageType) throws ServletException, IOException {
		
		String username = SessionUtils.getLoginedUsername(request);
		
		if(username != null) {
			prepareAndForward(request, response, pageType);
		}
		else {
			response.sendRedirect("login");
		}
		
	}
	
	
	private String title;
	private String contentUrl;
	private String scriptUrl;
	
	
	public PageInfor(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContentUrl() {
		return contentUrl;
	}


	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}


	public String getScriptUrl() {
		return scriptUrl;
	}


	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
	
}
