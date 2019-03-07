package com.sun.demo.personaladmin.service;

import java.util.List;

import com.sun.demo.bean.AttendanceRecord;
import com.sun.demo.domain.Department;
import com.sun.demo.domain.Employee;
import com.sun.demo.web.Page;

/**
 * Ա�����¹���Ľӿڣ����ڷ�װ���Ӻ��޸�Ա����Ϣ�Ȳ���
 * @author daming
 * 
 */
public interface IPersonAdminService {
	/**
	 * ����empidPart��ֵ�����������empidPartΪ��ͷ��Ա�����
	 * @param empidPart   ���û��Ѿ������empid��һ����
	 * @return ��������������empid�ļ���
	 */
	List<String> getEmpidByEmpidPart(String empidPart);

	/**
	 * ����Ա����Ż��Ա����Ϣ
	 * @param empid ��Ա�����
	 * @return ��Ա����Ϣ
	 */
	Employee getEmpById(String empid);
	
	/**
	 * ��װԱ��
	 * @param empid Ա�����
	 * @param username Ա������
	 * @param password ����
	 * @param depid ���ű��
	 * @param edu ѧ��
	 * @param college ѧУ
	 * @param birthday ����
	 * @param major רҵ
	 * @param gender �Ա�
	 * @return Ա����Ϣ
	 */
	Employee getEmp(String empid,String username,String password,String depid,String edu,String college,String birthday,String major,String gender);
	
	/**
	 * �����Ա��
	 * @param emp ��Ա����Ϣ
	 */
	void addEmployee(Employee emp);
	
	/**
	 * �����Ϸ�װ���ַ���
	 * @param list  ����
	 * @return �ַ���
	 */
	String setMessage(List<String> list);
	
	/**
	 * ��һ����֪��Ա����Ϣ��װ���ַ���
	 * @param emp Ա����Ϣ
	 * @return �ַ���
	 */
	String setMessage(Employee emp);
	
	/**
	 * ����Ա������Ϣ
	 * @param emp ��Ҫ���µ�Ա����Ϣ
	 */
	void updateEmployee(Employee emp);
	
	/**
	 * ���ݲ��ű�����жϸò����Ƿ����
	 * @param depid ���ű��
	 * @return ��������򷵻ز����� ,���򷵻�null
	 */
	String searchDepId(String depid);
	
	/**
	 * ����µĲ���
	 * @param dep �²���
	 */
	void addDepartment(Department dep);
	
	/**
	 * ���ȫ���Ĳ���
	 * @return ȫ��������Ϣ
	 */
	List<Department> getDepartment();
	
	/**
	 * ���²�����Ϣ
	 * @param dep ��Ҫ���µĲ�����Ϣ
	 */
	void updateDepartment(Department dep);
	
	/**
	 * ����һ�����ڼ�¼
	 * @param ar �¿��ڼ�¼ 
	 */
	void addAttendanceRecord(AttendanceRecord ar);
	
	/**
	 * ���ݴ����һ�����ڼ�¼�жϸ����Ա���Ŀ��ڼ�¼�Ƿ����
	 * @param ar ���ڼ�¼
	 * @return ����true��ʾ�ÿ��ڼ�¼���ڣ�false��ʾ������
	 */
	boolean searchAttendanceRecord(AttendanceRecord ar);
	
	/**
	 * �޸�Ա���Ŀ��ڼ�¼
	 * @param ar ��Ҫ���µ�Ա���Ŀ��ڼ�¼
	 */
	void updateAttendanceRecord(AttendanceRecord ar);
	
	/**
	 * ���ȫ���Ŀ��ڼ�¼ 
	 * @return ȫ���Ŀ��ڼ�¼
	 */
	List<AttendanceRecord> getAttendanceRecord();
	
	/**
	 * ���ָ��ҳ��Ŀ��ڼ�¼
	 * @param pageNo ָ��ҳ��
	 * @return ���ڼ�¼
	 */
	Page<AttendanceRecord> getPage(int pageNo);
	
	/**
	 * ���Ĭ�ϵ���Ա�����
	 * @return ��Ա�����
	 */
	String getDefaultEmpId();
	 
	/**
	 * ���ݲ��ű�Ż�øò��ŵ�ȫ��Ա����Ϣ
	 * @param depid ���ű��
	 * @return ָ�����ŵ�ȫ��Ա����Ϣ
	 */
	List<Employee> getEmployeeByOffice(String depid);
	
	/**
	 * ���ݲ��ű�Ż�ò�����
	 * @param depid ���ű��
	 * @return ���ھͷ��ظò������ƣ�������Ĭ�Ϸ���"��������"
	 */
	String getDname(String depid);
 
}
