package org.daming.gwwf.vehiclemanage.dao;

import java.util.List;

import org.daming.gwwf.bean.CarUserInfo;
import org.daming.gwwf.bean.User;
import org.daming.gwwf.domain.Car;
import org.daming.gwwf.domain.Employee;
import org.daming.gwwf.domain.Park;

/**
 * 车辆管理模块DAO接口
 * @author daming
 *
 */
public interface IVehicleManageDAO {

	/**
	 * 获得全部车位信息
	 * @return 车位信息
	 */
	List<Park> getParkingInfo();
	
	/**
	 * 获得全部的车辆信息 
	 * @return 车辆信息
	 */
	List<Car> getCarInfo();
	
	/**
	 * 根据车位编号信息获得与之对应车位信息
	 * @param pid 车位编号
	 * @return 车位信息
	 */
	Park getPark(String pid);
	
	/**
	 * 根据车牌号信息获得对应的车辆信息
	 * @param carid 车牌号
	 * @return 车辆信息
	 */
	Car getCar(String carid);
	
	/**
	 * 根据车牌号判断是否有该车辆的车位信息
	 * @param carid 车牌号
	 * @return 存在车位信息返回true，不存在车位信息返回false
	 */
	boolean hasPark(String carid);
	
	/**
	 * 新增一个车位信息
	 * @param park 新车位信息
	 */
	void insertPark(Park park);
	
	/**
	 * 获得全部员工的编号和姓名，将其封装成user类型的集合
	 * @return 用户
	 */
	List<User> getEmployee();
	
	/**
	 * 根据该员工判断是否已经配车
	 * @param empid 员工编号
	 * @return 已经配车返回true，没有配车返回false
	 */
	boolean hasCar(String empid);
	
	/**
	 * 新增车辆信息
	 * @param car 车辆信息
	 */
	void addCar(Car car);
	
	/**
	 * 根据员工编号查找该员工
	 * @param empId 员工编号
	 * @return 员工信息
	 */
	Employee searchEmployee(String empId);
	
	/**
	 * 插入一条车辆使用记录
	 * @param caruserinfo 新车辆使用记录
	 */
	void insertCarUserInfo(CarUserInfo caruserinfo);
	
	/**
	 * 获得全部的车辆使用信息的数量
	 * @return 全部车辆使用信息数量
	 */
	long getCarUserInfoNumber();
	
	/**
	 * 获得指定的页面上的车辆使用信息
	 * @param pageNo 指定页面
	 * @param pageSize 页面显示信息数量
	 * @return 车辆使用信息
	 */
	List<CarUserInfo> getCarUserInfo(int pageNo,int pageSize);
	
	/**
	 * 更新车辆信息
	 * @param car 新车辆信息
	 */ 
	void updateCarInfo(Car car);
	
	/**
	 * 更新车位信息
	 * @param park 需要更新的车位信息
	 */
	void updateParking(Park park);
	
	
}
