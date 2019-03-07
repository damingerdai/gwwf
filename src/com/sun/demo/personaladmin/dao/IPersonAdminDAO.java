package com.sun.demo.personaladmin.dao;

import java.util.List;

import com.sun.demo.bean.AttendanceRecord;
import com.sun.demo.domain.Department;
import com.sun.demo.domain.Employee;

/**
 * ��װ���¹����DAO��ӿ�
 * @author daming
 *
 */
public interface IPersonAdminDAO {
	/**
	 * ���ݲ��ֵ�empid�����Һ��ʵ�Ա�����
	 * @param empidPart
	 * @return ��������п������û���Ҫ��Ա����ŵļ���
	 */
	List<String> getEmpidByEmpidPart(String empidPart);
	
	/**
	 * ����Ա�����������Ա��
	 * @param empid ��Ա�����
	 * @return ��������Ա����Ϣ�����򷵻�null
	 */
	Employee getEmpByEmpid(String empid);
	

	/**
	 * ����depid�����Ҹò����Ƿ����
	 * @param depid
	 * @return �����ڷ��ز����������򷵻�null
	 */
	String searchDepId(String depid);
	
	/**
	 * ���ȫ���Ĳ���
	 * @return ��װ������Ϣ�ļ���
	 */
	List<Department> getDepartment();
 
	/**
	 * ���ָ��Ա����ָ�����ڵĿ��ڼ�¼
	 * @param empid ��Ա�����
	 * @param cdate ��ָ������
	 * @return �����ڼ�¼
	 */
	AttendanceRecord getAttendanceRecord(String empid,String cdate);
	
	/**
	 * ���ȫ���Ŀ��ڼ�¼
	 * @return ���ڼ�¼�ļ���
	 */
	List<AttendanceRecord> getAttendanceRecord(); 
	
	/**
	 * ���ָ��ҳ���ϵĿ��ڼ�¼�� 
	 * @param pageNo ָ��ҳ����
	 * @param pageSize ÿҳ�ϴ�ŵĿ��ڼ�¼����
	 * @return ���ָ��Ա����ָ�����ڵĿ��ڼ�¼
	 */
	List<AttendanceRecord> getAttendanceRecord(int pageNo,int pageSize);
	 
	/**
	 * ��ÿ��ڼ�¼������
	 * @return ���ڼ�¼������
	 */
	long getAttendRecNumber();
	
	/**
	 * ����Ա����Ϣ
	 * @param ��Ա������Ϣ
	 */
	void addEmployee(Employee emp);
	
	 
	
	/**
	 * ����Ա����Ϣ
	 * @param emp ��Ա����Ϣ
	 */
	void updateEmpoyee(Employee emp);
	
	/**
	 * ��������
	 * @param dep �²��ŵ���Ϣ
	 */
	void addDepartment(Department dep);
	
	/**
	 * ���²�����Ϣ
	 * @param dep ��Ҫ���µĲ��ŵ���Ϣ
	 */
	void updateDepartment(Department dep);
	
	/**
	 * �������ڼ�¼
	 * @param ar �¿��ڼ�¼
	 */
	void addAttendanceRecord(AttendanceRecord ar);
	
	/**
	 * ���¿��ڼ�¼ 
	 * @param ar ��Ҫ���µĿ��ڼ�¼
	 */
	void updateAttendanceRecor(AttendanceRecord ar);

	/**
	 * ���sequence��ָ���ֶεĵ����ֵ
	 * @param name ָ���ֶ�
	 * @return ���ֵ
	 */
	int getMaxIndex(String name);
	
	/**
	 * ��øò��ŵ�ȫ��Ա������Ϣ
	 * @param depid �����ű��
	 * @return �ò��ŵ�ȫ��Ա����Ϣ
	 */
	List<Employee> getEmployeeByOffice(String depid);
	
	/**
	 * ���ݲ��ű�Ż�ò�����
	 * @param depid �����ű��
	 * @return ������
	 */
	String getDname(String depid);
}
