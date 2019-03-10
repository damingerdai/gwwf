package org.daming.gwwf.personaladmin.servlet;

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

import org.daming.gwwf.bean.AttendanceRecord;
import org.daming.gwwf.bean.OfficeStationery;
import org.daming.gwwf.domain.Department;
import org.daming.gwwf.domain.Employee;
import org.daming.gwwf.office.service.IOfficeService;
import org.daming.gwwf.office.service.impl.OfficeService;
import org.daming.gwwf.personaladmin.service.IPersonAdminService;
import org.daming.gwwf.personaladmin.service.impl.PersonAdminService;
import org.daming.gwwf.web.Page;

/**
 * 人事管理模块的Servlet
 * @author daming
 *
 */
public class PersonAdminServlet extends HttpServlet {
	/**
	 * 人事管理后台服务
	 */
	private IPersonAdminService pService = new PersonAdminService();

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
	 * 增加新员工
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void addEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Employee emp = getEmpByRequest(request);
		pService.addEmployee(emp);
		//response.sendRedirect("personnel_department/personInfo_Add.jsp");
		request.getRequestDispatcher("PersonAdminServlet?method=setDefaultAddPersonInfo").forward(request, response);
	}

	/**
	 * 通过前端request来获得employee对象
	 * @param request ：请求
	 * @return 员工信息
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
	 * 根据员工编号的前部分获得所有可能的员工编号 
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
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
	 * 根据员工编号查找员工
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
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
	 * 更新员工的信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
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
	 * 添加新的部门
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
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
	 * 根据部门编号查找是否存在该部门
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
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
	 * 获得所有的部门
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void getDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Department> list = pService.getDepartment();
		request.setAttribute("list", list);
		request.getRequestDispatcher("personnel_department/Department_List.jsp")
				.forward(request, response);

	}

	/**
	 * 更新部门信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void updateDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String depid = request.getParameter("depid");
		String dname = request.getParameter("dname");
		Department dep = new Department(depid, dname);
		pService.updateDepartment(dep);
	}

	/**
	 * 新增员工的考勤记录
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
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
	 * 根据请求获得一条考勤记录
	 * @param request ：请求
	 * @return 考勤记录
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
	 * 获得全部的考勤记录
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
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
	 * 根据员工编号获得员工信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
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
	 * 新增员工信息时设置默认的员工编号
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void setDefaultAddPersonInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("empid", pService.getDefaultEmpId());
		request.setAttribute("list", pService.getDepartment());
		request.getRequestDispatcher("personnel_department/personInfo_Add.jsp")
				.forward(request, response);
	}
	
	/**
	 * 为办公用品模块提供部门信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
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
	 * 为办公用品模块提供员工信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
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
