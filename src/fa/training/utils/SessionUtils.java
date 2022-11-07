package fa.training.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	public static void add(HttpServletRequest request, String name, Object value) {
		
		HttpSession session = request.getSession();
		
		session.setAttribute(name, value);
	}
	
	public static Object get(HttpServletRequest request, String name) {
		
		HttpSession session = request.getSession();
		
		return session.getAttribute(name);
	}
	
	public static <E> E getValueInsession(HttpServletRequest request,String name) {
		E object = null;
		
		try {
			HttpSession session = request.getSession();
			
			object = (E) session.getAttribute(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
	public static void invalidate(HttpServletRequest requet) {
		HttpSession session =  requet.getSession();
		session.removeAttribute("username");
		session.invalidate();
	}
	
	public static boolean isLogin(HttpServletRequest request) {
		return get(request, "username") != null;
	}
	
	public static String getLoginedUsername(HttpServletRequest request) {
		Object username = get(request, "username");
		return username == null ? null : username.toString();
	}
}
