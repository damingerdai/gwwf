package org.daming.gwwf.office.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.daming.gwwf.bean.OfficeStationery;
import org.daming.gwwf.office.service.IOfficeService;
import org.daming.gwwf.office.service.impl.OfficeService;

/**
 * 办公用品模块的Servlet
 * @author daming
 *
 */
public class OfficeServlet extends HttpServlet {
	/**
	 * 办公用品后台处理服务
	 */
	private IOfficeService offService = new OfficeService();
 
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
		try
		{
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request,response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	/**
	 * 获得办公用品库存的信息并且将这些信息放在checkInventory.jsp上
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void getOffice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException
	{
		List<OfficeStationery> list = offService.getOffice();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Office_Stationery/CheckInventory.jsp").forward(request, response);
	}
	
	/**
	 * 更新办公用品的库存信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void updateOfficeStationery(HttpServletRequest request,
			HttpServletResponse response ) throws ServletException,IOException
	{
		String[] unames = request.getParameterValues("uname");
		String[] storeNumbersStr = request.getParameterValues("storeNumber");
		String[] units = request.getParameterValues("unit");
		if(unames == null||storeNumbersStr == null||units == null)
		{
			request.getRequestDispatcher("Office_Stationery/ReceiveDepartment.jsp").forward(request, response);
			return;
		}
		String empid = request.getParameter("employee").trim();
		List<OfficeStationery> list = getOffceByInfo(unames, storeNumbersStr,
				units);
		offService.updateOfficeUsage(empid, list);
		request.getRequestDispatcher("Office_Stationery/ReceiveDepartment.jsp").forward(request, response);
	}

	/**
	 * 将从页面获得信息封装成OfficeStationery类型的集合
	 * @param unames ：存放办公用品名称的String类型数组
	 * @param storeNumbersStr ：存放办公用品数量的String类型数组
	 * @param units ： 存放办公用品单位的String类型数组
	 * @return ：存放办公用品的OfficeStationery类型数组
	 */
	private List<OfficeStationery> getOffceByInfo(String[] unames,
			String[] storeNumbersStr, String[] units) {
		int length = (unames.length < storeNumbersStr.length ? unames.length : storeNumbersStr.length) > units.length ? (unames.length < storeNumbersStr.length ? unames.length : storeNumbersStr.length) : units.length;  
		List<OfficeStationery> list = new ArrayList<>();
		for(int i = 0; i < length;i++)
		{
			OfficeStationery off = new OfficeStationery();
			off.setUname(unames[i].trim());
			int storeNumber = 0;
			try
			{
				if(!"".equals(storeNumbersStr[i].trim()))
				{
					storeNumber = Integer.parseInt(storeNumbersStr[i].trim());
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			off.setStoreNumber(storeNumber);
			off.setUnit(units[i].trim());
			list.add(off);
		}
		return list;
	}
	
	/**
	 * 更新办公用品的信心，并且返回CheckInventory.jsp
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void updateOfficeInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException
	{
		String[] unames = request.getParameterValues("uname");
		String[] numbers = request.getParameterValues("number");
		String[] units = request.getParameterValues("unit");
		if(unames == null || numbers == null || units ==null)
		{
			request.getRequestDispatcher("OfficeServlet?method=getOffice").forward(request, response);
			return;
		}
		List<OfficeStationery> list = getOffceByInfo(unames,numbers,units);
		offService.updateOfficeStationery(list);
		request.getRequestDispatcher("OfficeServlet?method=getOffice").forward(request, response);
	}
}
