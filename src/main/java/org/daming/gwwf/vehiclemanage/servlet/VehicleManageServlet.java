package org.daming.gwwf.vehiclemanage.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Guice;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.daming.gwwf.bean.CarUserInfo;
import org.daming.gwwf.bean.User;
import org.daming.gwwf.domain.Car;
import org.daming.gwwf.domain.Employee;
import org.daming.gwwf.domain.Park;
import org.daming.gwwf.vehiclemanage.VehicleManageModule;
import org.daming.gwwf.vehiclemanage.service.IVehicleManageService;
import org.daming.gwwf.vehiclemanage.service.impl.VehicleManageService;
import org.daming.gwwf.web.AbstractHttpServlet;
import org.daming.gwwf.web.Page;

/**
 * 车辆管理模块的Servlet
 * @author daming
 *
 */
@WebServlet("/VehicleManageServlet")
public class VehicleManageServlet extends AbstractHttpServlet {

	/**
	 * 车辆管理模块的后台服务
	 */
	private IVehicleManageService vmService = Guice.createInjector(new VehicleManageModule()).getInstance(IVehicleManageService.class);

	/**
	 * 获得全部车位信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void getParkingInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Park> list = vmService.getParkingInfo();
		request.setAttribute("parks", list);
		request.getRequestDispatcher("car/ReviseParking_List.jsp").forward(
				request, response);
	}

	/**
	 * 查找指定的车位信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void searchPark(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid").trim();
		Park park = vmService.getPark(pid);
		String str = "";
		if (park == null) {
			str = "success";
		} else {
			str = "error";
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(str);
	}
	
	/**
	 * 查找指定车辆信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void searchCar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String carid = request.getParameter("carid").trim();
		Car car = vmService.getCar(carid);
		String str = "";
		if (car == null) {
			str = "Car_is_null";
		} else {
			if (vmService.hasPark(car)) {
				str = "Car_has_park";
			}
			else
			{
				str = "success";
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(str);
	}
	
	/**
	 * 新增车位信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void addPark(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid").trim();
		String carid = request.getParameter("carid").trim();
		String instrucation = request.getParameter("instrucation").trim();
		Park park = new Park(pid,carid,instrucation);
		vmService.addPark(park);
		request.getRequestDispatcher("VehicleManageServlet?method=getParkingInfo").forward(request, response);
	}
	
	/**
	 * 获得全部的车辆信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void getCarInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Car> list = vmService.getCarInfo();
		request.setAttribute("cars", list);
		request.getRequestDispatcher("car/CarInfo_List.jsp").forward(request, response);
	}
	
	/**
	 * 获得全部的司机
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void searchDriver(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<User> list = vmService.getDriver();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"password","privilege"});
		JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
		String jsonString = jsonArray.toString();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(jsonString);
	}
	
	/**
	 * 新增一个车辆信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void addCar(HttpServletRequest request,
			HttpServletResponse response ) throws ServletException,IOException
	{
		String carId = request.getParameter("carid").trim();
		String carType = request.getParameter("cartype").trim();
		String buyTime = request.getParameter("buytime").trim();
		String dirverId = request.getParameter("dirverid").trim();
		String capacity = request.getParameter("capacity").trim();
		String capunit = request.getParameter("capunit").trim();
		String usageType = request.getParameter("usageType").trim();
		Car car = new Car();
		car.setCarId(carId);
		car.setCarType(carType);
		car.setBuyTime(buyTime);
		car.setDirverId(dirverId);
		car.setCapacity(capacity);
		car.setCapunit(capunit);
		car.setUsageType(usageType);
		vmService.addCar(car);
		request.getRequestDispatcher("VehicleManageServlet?method=getCarInfo").forward(request, response);
	}
	
	/**
	 * 根据员工编号查找该员工
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void searchEmployee(HttpServletRequest request,
			HttpServletResponse response ) throws ServletException,IOException
	{
		String empId = request.getParameter("userid").trim();
		Employee emp = vmService.searchEmployee(empId);
		String message = "sucess";
		if(emp == null)
		{
			message = "error";
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(message);
	}
	
	/**
	 * 新增一条车辆使用信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void addCarUseInfo(HttpServletRequest request,
			HttpServletResponse response ) throws ServletException,IOException
	{
		String carId = request.getParameter("carid").trim();
		String usage = request.getParameter("usage").trim();
		String userId = request.getParameter("userid").trim();
		String usageTime_begin = request.getParameter("usagetime_begin").trim();
		String usageTime_end = request.getParameter("usagetime_end").trim();
		CarUserInfo cui = new CarUserInfo();
		cui.setCarId(carId);
		cui.setUsage(usage);
		cui.setUserId(userId);
		cui.setUsageTime_begin(usageTime_begin);
		cui.setUsageTime_end(usageTime_end);
		vmService.addCarUserInfo(cui);
		request.getRequestDispatcher("VehicleManageServlet?method=getParkingInfo").forward(request, response);
	}
	
	/**
	 * 获得指定页面上的车辆使用记录
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void getCarUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException
	{
		String pageNoStr = request.getParameter("pageNo").trim();
		int pageNo = 1;
		try
		{
			pageNo = Integer.parseInt(pageNoStr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Page<CarUserInfo> page = vmService.getPage(pageNo);
		request.setAttribute("page", page);
		request.getRequestDispatcher("car/CarUserInfo_Query.jsp").forward(request, response);
	}
	
	/**
	 * 更新车辆使用信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void uppdateCarInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException
	{
		String carId = request.getParameter("carid").trim();
		String carType = request.getParameter("carType").trim();
		String buyTime = request.getParameter("buytime").trim();
		String dirverId = request.getParameter("dirverId").trim();
		String capacity = request.getParameter("capacity").trim();
		String capunit = request.getParameter("capunit").trim();
		String usageType = request.getParameter("usageType").trim();
		Car car = new Car();
		car.setCarId(carId);
		car.setCarType(carType);
		car.setBuyTime(buyTime);
		car.setDirverId(dirverId);
		car.setCapacity(capacity);
		car.setCapunit(capunit);
		car.setUsageType(usageType);
		vmService.updateCarInfo(car);
	}
	
	/**
	 * 更新车位信息
	 * @param request ：请求
	 * @param response ：响应
	 * @throws ServletException ：Servlet异常
	 * @throws IOException ： IO异常
	 */
	public void updateParking(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException
	{
		String pid = request.getParameter("pid").trim();
		String carId = request.getParameter("carid").trim();
		String instrucation = request.getParameter("instrucation").trim();
		Park park = new Park(pid,carId,instrucation);
		vmService.updateParking(park);
	}

}
