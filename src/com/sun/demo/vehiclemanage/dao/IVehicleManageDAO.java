package com.sun.demo.vehiclemanage.dao;

import java.util.List;

import com.sun.demo.bean.CarUserInfo;
import com.sun.demo.bean.User;
import com.sun.demo.domain.Car;
import com.sun.demo.domain.Employee;
import com.sun.demo.domain.Park;
/**
 * ��������ģ��DAO�ӿ�
 * @author daming
 *
 */
public interface IVehicleManageDAO {

	/**
	 * ���ȫ����λ��Ϣ
	 * @return ��λ��Ϣ
	 */
	List<Park> getParkingInfo();
	
	/**
	 * ���ȫ���ĳ�����Ϣ 
	 * @return ������Ϣ
	 */
	List<Car> getCarInfo();
	
	/**
	 * ���ݳ�λ�����Ϣ�����֮��Ӧ��λ��Ϣ
	 * @param pid ��λ���
	 * @return ��λ��Ϣ
	 */
	Park getPark(String pid);
	
	/**
	 * ���ݳ��ƺ���Ϣ��ö�Ӧ�ĳ�����Ϣ
	 * @param carid ���ƺ�
	 * @return ������Ϣ
	 */
	Car getCar(String carid);
	
	/**
	 * ���ݳ��ƺ��ж��Ƿ��иó����ĳ�λ��Ϣ
	 * @param carid ���ƺ�
	 * @return ���ڳ�λ��Ϣ����true�������ڳ�λ��Ϣ����false
	 */
	boolean hasPark(String carid);
	
	/**
	 * ����һ����λ��Ϣ
	 * @param park �³�λ��Ϣ
	 */
	void insertPark(Park park);
	
	/**
	 * ���ȫ��Ա���ı�ź������������װ��user���͵ļ���
	 * @return �û�
	 */
	List<User> getEmployee();
	
	/**
	 * ���ݸ�Ա���ж��Ƿ��Ѿ��䳵
	 * @param empid Ա�����
	 * @return �Ѿ��䳵����true��û���䳵����false
	 */
	boolean hasCar(String empid);
	
	/**
	 * ����������Ϣ
	 * @param car ������Ϣ
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
	 * @param caruserinfo �³���ʹ�ü�¼
	 */
	void insertCarUserInfo(CarUserInfo  caruserinfo);
	
	/**
	 * ���ȫ���ĳ���ʹ����Ϣ������
	 * @return ȫ������ʹ����Ϣ����
	 */
	long getCarUserInfoNumber();
	
	/**
	 * ���ָ����ҳ���ϵĳ���ʹ����Ϣ
	 * @param pageNo ָ��ҳ��
	 * @param pageSize ҳ����ʾ��Ϣ����
	 * @return ����ʹ����Ϣ
	 */
	List<CarUserInfo> getCarUserInfo(int pageNo,int pageSize);
	
	/**
	 * ���³�����Ϣ
	 * @param car �³�����Ϣ
	 */ 
	void updateCarInfo(Car car);
	
	/**
	 * ���³�λ��Ϣ
	 * @param park ��Ҫ���µĳ�λ��Ϣ
	 */
	void updateParking(Park park);
	
	
}
