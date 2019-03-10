package com.sun.demo.login.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.demo.bean.User;
import com.sun.demo.domain.Employee;
import com.sun.demo.login.service.ILoginService;
import com.sun.demo.login.service.impl.LoginService;
/**
 * 登录模块的Servlet
 * @author daming
 *
 */
public class LoginServlet extends HttpServlet {
	/**
	 * 登录模块的Service
	 */
	private ILoginService loginService = new LoginService();

	/**
	 * doGet方法
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * doPost方法
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
