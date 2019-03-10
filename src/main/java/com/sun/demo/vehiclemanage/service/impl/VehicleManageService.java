package com.sun.demo.vehiclemanage.service.impl;

import java.util.List;

import com.sun.demo.bean.CarUserInfo;
import com.sun.demo.bean.User;
import com.sun.demo.domain.Car;
import com.sun.demo.domain.Employee;
import com.sun.demo.domain.Park;
import com.sun.demo.vehiclemanage.dao.IVehicleManageDAO;
import com.sun.demo.vehiclemanage.dao.impl.VehicleManageDAO;
import com.sun.demo.vehiclemanage.service.IVehicleManageService;
import com.sun.demo.web.Page;

/**
 * 车辆管理模块的service实现类
 * @author daming
 *
 */
public class VehicleManageService implements IVehicleManageService {

	/**
	 * 车辆管理DAO操作
	 */
	private IVehicleManageDAO vmDAO = new VehicleManageDAO();
	@Override
	public List<Park> getParkingInfo() {
		
		return vmDAO.getParkingInfo();
	}
	@Override
	public Park getPark(String pid) {
		
		return vmDAO.getPark(pid);
	}
	@Override
	public Car getCar(String carid) {
		
		return vmDAO.getCar(carid);
	}
	@Override
	public boolean hasPark(Car car) {
		 
		return vmDAO.hasPark(car.getCarId());
		 
		
	}
	@Override
	public void addPark(Park park) {
		vmDAO.insertPark(park);
	}
	@Override
	public List<Car> getCarInfo() {
		 
		return vmDAO.getCarInfo();
	}
	@Override
	public List<User> getDriver() {
		List<User> list = vmDAO.getEmployee();
		for(int i = 0;i < list.size();i++)
		{
			if(vmDAO.hasCar(list.get(i).getEmpId()))
			{
				list.remove(i);
			}
		}
		return list;
	}
	@Override
	public void addCar(Car car) {
		vmDAO.addCar(car);	
	}
	@Override
	public Employee searchEmployee(String empId) {
		
		return vmDAO.searchEmployee(empId);
	}
	@Override
	public void addCarUserInfo(CarUserInfo cui) {
		 vmDAO.insertCarUserInfo(cui);
	}
	@Override
	public Page<CarUserInfo> getPage(int pageNo) {
		long totalItemNumber = vmDAO.getCarUserInfoNumber();
		Page<CarUserInfo> page = new Page<>(pageNo);
		if(totalItemNumber != 0)
		{
			page.setTotalItemNumber(totalItemNumber);
			pageNo = page.getPageNo();
			page.setList(vmDAO.getCarUserInfo(pageNo, 5));
		}
		
		return page;
	}
	@Override
	public void updateCarInfo(Car car) {
		vmDAO.updateCarInfo(car);
		
	}
	@Override
	public void updateParking(Park park) {
		 vmDAO.updateParking(park);
		
	}
	
}
