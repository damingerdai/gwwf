package com.sun.demo.office.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.demo.bean.OfficeStationery;
import com.sun.demo.office.service.IOfficeService;
import com.sun.demo.office.service.impl.OfficeService;
/**
 * �칫��Ʒģ���Servlet
 * @author daming
 *
 */
public class OfficeServlet extends HttpServlet {
	/**
	 * �칫��Ʒ��̨�������
	 */
	private IOfficeService offService = new OfficeService();
 
	/**
	 * doGet����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * doPost����
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
	 * ��ð칫��Ʒ������Ϣ���ҽ���Щ��Ϣ����checkInventory.jsp��
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void getOffice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException
	{
		List<OfficeStationery> list = offService.getOffice();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Office_Stationery/CheckInventory.jsp").forward(request, response);
	}
	
	/**
	 * ���°칫��Ʒ�Ŀ����Ϣ
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
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
	 * ����ҳ������Ϣ��װ��OfficeStationery���͵ļ���
	 * @param unames ����Ű칫��Ʒ���Ƶ�String��������
	 * @param storeNumbersStr ����Ű칫��Ʒ������String��������
	 * @param units �� ��Ű칫��Ʒ��λ��String��������
	 * @return ����Ű칫��Ʒ��OfficeStationery��������
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
	 * ���°칫��Ʒ�����ģ����ҷ���CheckInventory.jsp
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
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
