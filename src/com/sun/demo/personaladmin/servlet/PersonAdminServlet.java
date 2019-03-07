package com.sun.demo.personaladmin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.sun.demo.bean.AttendanceRecord;
import com.sun.demo.bean.OfficeStationery;
import com.sun.demo.domain.Department;
import com.sun.demo.domain.Employee;
import com.sun.demo.office.service.IOfficeService;
import com.sun.demo.office.service.impl.OfficeService;
import com.sun.demo.personaladmin.service.IPersonAdminService;
import com.sun.demo.personaladmin.service.impl.PersonAdminService;
import com.sun.demo.web.Page;
/**
 * ���¹���ģ���Servlet
 * @author daming
 *
 */
public class PersonAdminServlet extends HttpServlet {
	/**
	 * ���¹����̨����
	 */
	private IPersonAdminService pService = new PersonAdminService();

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
		//System.out.println(methodName);
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
	 * ������Ա��
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void addEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Employee emp = getEmpByRequest(request);
		pService.addEmployee(emp);
		//response.sendRedirect("personnel_department/personInfo_Add.jsp");
		request.getRequestDispatcher("PersonAdminServlet?method=setDefaultAddPersonInfo").forward(request, response);
	}

	/**
	 * ͨ��ǰ��request�����employee����
	 * @param request ������
	 * @return Ա����Ϣ
	 */
	private Employee getEmpByRequest(HttpServletRequest request) {
		String empid = request.getParameter("empid").trim();
		String username = request.getParameter("username").trim();
		String gender = request.getParameter("gender").trim();
		String dep = request.getParameter("department").trim();
		String edu = request.getParameter("edu").trim();
		String college = request.getParameter("college").trim();
		String birthday = request.getParameter("birthday").trim();
		String major = request.getParameter("major").trim();
		String password = request.getParameter("password");
		return pService.getEmp(empid, username, password, dep, edu, college,
				birthday, major, gender);
	}

	/**
	 * ����Ա����ŵ�ǰ���ֻ�����п��ܵ�Ա����� 
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void searchEmpId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String empidPart = request.getParameter("empidPart").trim();
		List<String> list = pService.getEmpidByEmpidPart(empidPart);
		String str = pService.setMessage(list);
		if (str != null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(str);
		}

	}

	/**
	 * ����Ա����Ų���Ա��
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void searchEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empid").trim();
		Employee emp = pService.getEmpById(empId);
		String message = "success";
		if (emp == null) {
			message = "error";
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(message);

	}

	/**
	 * ����Ա������Ϣ
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void updateEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Employee emp = getEmpByRequest(request);
		String empId = request.getParameter("empid").trim();
		String username = request.getParameter("username").trim();
		String gender = request.getParameter("gender").trim();
		String birthday = request.getParameter("birthday").trim();
		String depart = request.getParameter("depart").trim();
		String college = request.getParameter("college").trim();
		String major = request.getParameter("major").trim();
		String edu = request.getParameter("edu").trim();
		String password = request.getParameter("password");
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setUsername(username);
		emp.setGender(gender);
		emp.setBirthday(birthday);
		emp.setDepId(depart);
		emp.setCollege(college);
		emp.setMajor(major);
		emp.setEdu(edu);
		emp.setPassword(password);
		 
		pService.updateEmployee(emp);
		response.sendRedirect("personnel_department/personInfo_revise.jsp");
	}

	/**
	 * ����µĲ���
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void addDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String depid = request.getParameter("depid").trim();
		String dname = request.getParameter("dname").trim();
		Department department = new Department(depid, dname);
		pService.addDepartment(department);
		//response.sendRedirect("personnel_department/Department_Add.jsp");
		request.getRequestDispatcher("PersonAdminServlet?method=getDepartment").forward(request, response);
	}

	/**
	 * ���ݲ��ű�Ų����Ƿ���ڸò���
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void searchDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String depid = request.getParameter("depid").trim();
		String dname = pService.searchDepId(depid);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		if (dname != null) {
			pw.write(dname);
		}
	}

	/**
	 * ������еĲ���
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void getDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Department> list = pService.getDepartment();
		request.setAttribute("list", list);
		request.getRequestDispatcher("personnel_department/Department_List.jsp")
				.forward(request, response);

	}

	/**
	 * ���²�����Ϣ
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void updateDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String depid = request.getParameter("depid");
		String dname = request.getParameter("dname");
		Department dep = new Department(depid, dname);
		pService.updateDepartment(dep);
	}

	/**
	 * ����Ա���Ŀ��ڼ�¼
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void addAttendance(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AttendanceRecord ar = getAttendRecByReq(request);
		boolean bool = pService.searchAttendanceRecord(ar);
		if (bool) {
			pService.updateAttendanceRecord(ar);
		} else {
			pService.addAttendanceRecord(ar);
		}
		response.sendRedirect("personnel_department/staffattendance_add.jsp");
		
	}

	/**
	 * ����������һ�����ڼ�¼
	 * @param request ������
	 * @return ���ڼ�¼
	 */
	private AttendanceRecord getAttendRecByReq(HttpServletRequest request) {
		String empid = request.getParameter("empid");
		String cdate = request.getParameter("cdate");
		String ontime = request.getParameter("ontime");
		String offtime = request.getParameter("offtime");
		String ctype = request.getParameter("ctype");
		AttendanceRecord ar = new AttendanceRecord();
		ar.setEmpid(empid);
		ar.setCdate(cdate);
		ar.setOfftime(offtime);
		ar.setOntime(ontime);
		ar.setCtype(ctype);
		return ar;
	}

	/**
	 * ���ȫ���Ŀ��ڼ�¼
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void getAttendanceRecord(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pageNoStr = request.getParameter("pageNo");
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<AttendanceRecord> page = pService.getPage(pageNo);
		request.setAttribute("page", page);
		request.getRequestDispatcher(
				"/personnel_department/staffattendance_List.jsp").forward(
				request, response);
		;
	}

	/**
	 * ����Ա����Ż��Ա����Ϣ
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void getEmployeeByEmpId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empid").trim();
		Employee emp = pService.getEmpById(empId);
		if (emp != null) {
			request.setAttribute("empid", emp.getEmpId());
			request.setAttribute("username", emp.getUsername());
			request.setAttribute("gender", emp.getGender());
			request.setAttribute("birthday", emp.getBirthday());
			request.setAttribute("department", emp.getDepId());
			request.setAttribute("college", emp.getCollege());
			request.setAttribute("major", emp.getMajor());
			request.setAttribute("edu", emp.getEdu());
			request.getRequestDispatcher(
					"personnel_department/personInforevise_update.jsp")
					.forward(request, response);
		} else {
			response.sendRedirect("personnel_department/personInfo_revise.jsp");
		}

	}

	/**
	 * ����Ա����Ϣʱ����Ĭ�ϵ�Ա�����
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void setDefaultAddPersonInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("empid", pService.getDefaultEmpId());
		request.setAttribute("list", pService.getDepartment());
		request.getRequestDispatcher("personnel_department/personInfo_Add.jsp")
				.forward(request, response);
	}
	
	/**
	 * Ϊ�칫��Ʒģ���ṩ������Ϣ
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void getDepartmentByOffice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Department> list =pService.getDepartment();
		JsonConfig jsonConfig = new JsonConfig();
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		String jsonString = jsonArray.toString();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(jsonString);
	}

	/**
	 * Ϊ�칫��Ʒģ���ṩԱ����Ϣ
	 * @param request ������
	 * @param response ����Ӧ
	 * @throws ServletException ��Servlet�쳣
	 * @throws IOException �� IO�쳣
	 */
	public void getEmployeeByOffice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String depid = request.getParameter("department"); 
		List<Employee> list = pService.getEmployeeByOffice(depid);
		IOfficeService offService = new OfficeService();
		List<OfficeStationery> offList = offService.getOffice();
		String dname = pService.getDname(depid);
		request.setAttribute("list", list);
		request.setAttribute("dname", dname);
		request.setAttribute("offList", offList);
		request.getRequestDispatcher("Office_Stationery/GetRegistration.jsp").forward(request, response);
	}

}
