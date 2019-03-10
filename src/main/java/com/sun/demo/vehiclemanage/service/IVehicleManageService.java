package com.sun.demo.vehiclemanage.service;

import java.util.List;

import com.sun.demo.bean.CarUserInfo;
import com.sun.demo.bean.User;
import com.sun.demo.domain.Car;
import com.sun.demo.domain.Employee;
import com.sun.demo.domain.Park;
import com.sun.demo.web.Page;

/**
 * 车辆管理模块的service接口
 * @author daming
 *
 */
public interface IVehicleManageService {
	/**
	 * 获得全部的车位信息，封装成List集合
	 * @return 全部的车位信息
	 */
	List<Park> getParkingInfo();
	
	/**
	 * 获得全部的车辆信息，封装成List集合
	 * @return 全部的车辆信息
	 */
	List<Car> getCarInfo();
	
	/**
	 * 根据车位编号获得对应的车位信息
	 * @param pid 车位编号
	 * @return 车位信息
	 */
	Park getPark(String pid);
	
	/**
	 * 根据车牌号来获得对应的车辆信息
	 * @param 车牌号
	 * @return 车辆信息
	 */
	Car getCar(String carid);
	
	/**
	 * 判断该车辆是否有车位
	 * @param car 车辆信息
	 * @return 存在车位返回true，不存在车位返回false
	 */
	boolean hasPark(Car car);
	
	/**
	 * 增加一个新的车位
	 * @param park 新增车位
	 */
	void addPark(Park park);
	
	/**
	 * 获得所有的司机，实际上就是所有有驾驶证的员工。
	 * @return 全部司机
	 */
	List<User> getDriver();
	
	/**
	 * 新增车辆信息
	 * @param car 新车辆信息
	 */
	void addCar(Car car);
	
	/**
	 * 根据员工编号查找该员工
	 * @param empId 员工编号
	 * @return 员工信息
	 */
	Employee searchEmployee(String empId);
	
	/**
	 * 新增一条车辆使用记录
	 * @param cui 新车辆使用记录
	 */
	void addCarUserInfo(CarUserInfo cui);
	
	/**
	 * 获得指定页面的车辆使用记录
	 * @param pageNo 指定页面
	 * @return 车辆使用记录
	 */
	Page<CarUserInfo> getPage(int pageNo);
	
	/**
	 * 更新车辆信息
	 * @param car 需要更新的车辆信息
	 */
	void updateCarInfo(Car car);
	
	/**
	 * 更新车位信息 
	 * @param park 需要更新的车位信息
 	 */
	void updateParking(Park park);
}
