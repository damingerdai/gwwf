package com.sun.demo.filter;

 

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * �û�����״̬�����Ĺ�����
 * @author daming
 *
 */
public class SessionFilter implements Filter {

	/**
	 * ������������
	 */
	@Override
	public void destroy() {

	}

	/**
	 * �������ľ������
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 
		HttpServletRequest req = (HttpServletRequest) request;
		String requestURI = req.getRequestURI();
		HttpSession session = req.getSession();
		if (requestURI.endsWith("login.jsp")
				|| requestURI.endsWith("LoginServlet")) {
			chain.doFilter(request, response);
			return;
		}
		if (requestURI.endsWith("jsp")) {
			if (session.getAttribute("user") == null) {
				((HttpServletResponse) response).sendRedirect("login.jsp");
				return;
			} else {
				chain.doFilter(request, response);
				return;
			}
		} else {
			chain.doFilter(request, response);
			return;
		}
	  
		//chain.doFilter(request, response);
	}

	/**
	 * �������ĳ�ʼ��
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
