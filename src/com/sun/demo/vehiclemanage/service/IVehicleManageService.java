package com.sun.demo.vehiclemanage.service;

import java.util.List;

import com.sun.demo.bean.CarUserInfo;
import com.sun.demo.bean.User;
import com.sun.demo.domain.Car;
import com.sun.demo.domain.Employee;
import com.sun.demo.domain.Park;
import com.sun.demo.web.Page;

/**
 * ��������ģ���service�ӿ�
 * @author daming
 *
 */
public interface IVehicleManageService {
	/**
	 * ���ȫ���ĳ�λ��Ϣ����װ��List����
	 * @return ȫ���ĳ�λ��Ϣ
	 */
	List<Park> getParkingInfo();
	
	/**
	 * ���ȫ���ĳ�����Ϣ����װ��List����
	 * @return ȫ���ĳ�����Ϣ
	 */
	List<Car> getCarInfo();
	
	/**
	 * ���ݳ�λ��Ż�ö�Ӧ�ĳ�λ��Ϣ
	 * @param pid ��λ���
	 * @return ��λ��Ϣ
	 */
	Park getPark(String pid);
	
	/**
	 * ���ݳ��ƺ�����ö�Ӧ�ĳ�����Ϣ
	 * @param ���ƺ�
	 * @return ������Ϣ
	 */
	Car getCar(String carid);
	
	/**
	 * �жϸó����Ƿ��г�λ
	 * @param car ������Ϣ
	 * @return ���ڳ�λ����true�������ڳ�λ����false
	 */
	boolean hasPark(Car car);
	
	/**
	 * ����һ���µĳ�λ
	 * @param park ������λ
	 */
	void addPark(Park park);
	
	/**
	 * ������е�˾����ʵ���Ͼ��������м�ʻ֤��Ա����
	 * @return ȫ��˾��
	 */
	List<User> getDriver();
	
	/**
	 * ����������Ϣ
	 * @param car �³�����Ϣ
	 */
	void addCar(Car car);
	
	/**
	 * ����Ա����Ų��Ҹ�Ա��
	 * @param empId Ա�����
	 * @return Ա����Ϣ
	 */
	Employee searchEmployee(String empId);
	
	/**
	 * ����һ������ʹ�ü�¼
	 * @param cui �³���ʹ�ü�¼
	 */
	void addCarUserInfo(CarUserInfo cui);
	
	/**
	 * ���ָ��ҳ��ĳ���ʹ�ü�¼
	 * @param pageNo ָ��ҳ��
	 * @return ����ʹ�ü�¼
	 */
	Page<CarUserInfo> getPage(int pageNo);
	
	/**
	 * ���³�����Ϣ
	 * @param car ��Ҫ���µĳ�����Ϣ
	 */
	void updateCarInfo(Car car);
	
	/**
	 * ���³�λ��Ϣ 
	 * @param park ��Ҫ���µĳ�λ��Ϣ
 	 */
	void updateParking(Park park);
}
