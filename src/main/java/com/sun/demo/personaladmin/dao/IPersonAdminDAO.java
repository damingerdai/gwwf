package com.sun.demo.personaladmin.dao;

import java.util.List;

import com.sun.demo.bean.AttendanceRecord;
import com.sun.demo.domain.Department;
import com.sun.demo.domain.Employee;

/**
 * 封装人事管理的DAO类接口
 * @author daming
 *
 */
public interface IPersonAdminDAO {
	/**
	 * 根据部分的empid来查找合适的员工编号
	 * @param empidPart
	 * @return ：存放所有可能是用户想要的员工编号的集合
	 */
	List<String> getEmpidByEmpidPart(String empidPart);
	
	/**
	 * 根据员工编号来查找员工
	 * @param empid ：员工编号
	 * @return ：若存在员工信息，否则返回null
	 */
	Employee getEmpByEmpid(String empid);
	

	/**
	 * 根据depid来查找该部门是否存在
	 * @param depid
	 * @return 若存在返回部门名，否则返回null
	 */
	String searchDepId(String depid);
	
	/**
	 * 获得全部的部门
	 * @return 封装部门信息的集合
	 */
	List<Department> getDepartment();
 
	/**
	 * 获得指定员工在指定日期的考勤记录
	 * @param empid ：员工编号
	 * @param cdate ：指定日期
	 * @return ：考勤记录
	 */
	AttendanceRecord getAttendanceRecord(String empid,String cdate);
	
	/**
	 * 获得全部的考勤记录
	 * @return 考勤记录的集合
	 */
	List<AttendanceRecord> getAttendanceRecord(); 
	
	/**
	 * 获得指定页面上的考勤记录， 
	 * @param pageNo 指定页面数
	 * @param pageSize 每页上存放的考勤记录的数
	 * @return 获得指定员工在指定日期的考勤记录
	 */
	List<AttendanceRecord> getAttendanceRecord(int pageNo,int pageSize);
	 
	/**
	 * 获得考勤记录的数量
	 * @return 考勤记录的数量
	 */
	long getAttendRecNumber();
	
	/**
	 * 新增员工信息
	 * @param 新员工的信息
	 */
	void addEmployee(Employee emp);
	
	 
	
	/**
	 * 更新员工信息
	 * @param emp ：员工信息
	 */
	void updateEmpoyee(Employee emp);
	
	/**
	 * 新增部门
	 * @param dep 新部门的信息
	 */
	void addDepartment(Department dep);
	
	/**
	 * 更新部门信息
	 * @param dep 需要更新的部门的信息
	 */
	void updateDepartment(Department dep);
	
	/**
	 * 新增考勤记录
	 * @param ar 新考勤记录
	 */
	void addAttendanceRecord(AttendanceRecord ar);
	
	/**
	 * 更新考勤记录 
	 * @param ar 需要更新的考勤记录
	 */
	void updateAttendanceRecor(AttendanceRecord ar);

	/**
	 * 获得sequence中指定字段的的最大值
	 * @param name 指定字段
	 * @return 最大值
	 */
	int getMaxIndex(String name);
	
	/**
	 * 获得该部门的全部员工的信息
	 * @param depid ：部门编号
	 * @return 该部门的全部员工信息
	 */
	List<Employee> getEmployeeByOffice(String depid);
	
	/**
	 * 根据部门编号获得部门名
	 * @param depid ：部门编号
	 * @return 部门名
	 */
	String getDname(String depid);
}
