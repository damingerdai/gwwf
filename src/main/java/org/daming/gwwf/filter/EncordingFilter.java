package org.daming.gwwf.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码过滤器
 * @author daming
 *
 */
public class EncordingFilter implements Filter {
	/**
	 * 编码
	 */
	private String encoding;
	/**
	 * 参数
	 */
	private Map<String,String> params = new HashMap<>();
	/**
	 * 过滤器的销毁
	 */
	@Override
	public void destroy() {
		 params=null;  
		 encoding=null;  		
	}
	/**
	 * 过滤器的具体操作
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 request.setCharacterEncoding(encoding);
		 chain.doFilter(request, response);
		
	}
	/**
	 * 过滤器的初始化
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		 encoding = config.getInitParameter("encoding");
		 for(Enumeration e = config.getInitParameterNames();e.hasMoreElements();)
		 {
			 String name = (String)e.nextElement();
			 String value = config.getInitParameter(name);
			 params.put(name, value);
		 }
	}

}
