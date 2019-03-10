package org.daming.gwwf.login.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.daming.gwwf.bean.User;
import org.daming.gwwf.login.service.ILoginService;
import org.daming.gwwf.login.service.impl.LoginService;
import org.daming.gwwf.web.AbstractHttpServlet;

/**
 * 登录模块的Servlet
 * @author daming
 *
 */
public class LoginServlet extends AbstractHttpServlet {
	/**
	 * 登录模块的Service
	 */
	private ILoginService loginService = new LoginService();

	/**
	 * 用于判断用户输入的员工编号和密码是否正确
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empid = request.getParameter("empid");
		String password = request.getParameter("password");
		User user = new User(empid, password);
		String message = loginService.checkUser(user);
		if(message.equals("success"))
		{
			HttpSession session = request.getSession();
			user.setUsername(loginService.searchUsername(user.getEmpId()));
			user.setPrivilege(loginService.searchDepId(user.getEmpId()));
			session.setAttribute("user", user);
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(message);
	}
	
	/**
	 * 用户退出管理系统
	 * @param request ：请求
	 * @param response ： 响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ：IO异常
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("username");
			session.invalidate();
		}
		response.sendRedirect("login.jsp");
	}

}
