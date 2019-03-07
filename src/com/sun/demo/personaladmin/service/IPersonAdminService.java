package com.sun.demo.personaladmin.service;

import java.util.List;

import com.sun.demo.bean.AttendanceRecord;
import com.sun.demo.domain.Department;
import com.sun.demo.domain.Employee;
import com.sun.demo.web.Page;

/**
 * 员工人事管理的接口，用于封装增加和修改员工信息等操作
 * @author daming
 * 
 */
public interface IPersonAdminService {
	/**
	 * 根据empidPart的值来获得所有以empidPart为开头的员工编号
	 * @param empidPart   ：用户已经输入的empid的一部分
	 * @return 所有满足条件的empid的集合
	 */
	List<String> getEmpidByEmpidPart(String empidPart);

	/**
	 * 根据员工编号获得员工信息
	 * @param empid ：员工编号
	 * @return ：员工信息
	 */
	Employee getEmpById(String empid);
	
	/**
	 * 封装员工
	 * @param empid 员工编号
	 * @param username 员工姓名
	 * @param password 密码
	 * @param depid 部门编号
	 * @param edu 学历
	 * @param college 学校
	 * @param birthday 生日
	 * @param major 专业
	 * @param gender 性别
	 * @return 员工信息
	 */
	Employee getEmp(String empid,String username,String password,String depid,String edu,String college,String birthday,String major,String gender);
	
	/**
	 * 添加新员工
	 * @param emp 新员工信息
	 */
	void addEmployee(Employee emp);
	
	/**
	 * 将集合封装成字符串
	 * @param list  集合
	 * @return 字符串
	 */
	String setMessage(List<String> list);
	
	/**
	 * 将一个已知的员工信息封装成字符串
	 * @param emp 员工信息
	 * @return 字符串
	 */
	String setMessage(Employee emp);
	
	/**
	 * 更新员工的信息
	 * @param emp 需要更新的员工信息
	 */
	void updateEmployee(Employee emp);
	
	/**
	 * 根据部门编号来判断该部门是否存在
	 * @param depid 部门编号
	 * @return 如果存在则返回部门名 ,否则返回null
	 */
	String searchDepId(String depid);
	
	/**
	 * 添加新的部门
	 * @param dep 新部门
	 */
	void addDepartment(Department dep);
	
	/**
	 * 获得全部的部门
	 * @return 全部部门信息
	 */
	List<Department> getDepartment();
	
	/**
	 * 更新部门信息
	 * @param dep 需要更新的部门信息
	 */
	void updateDepartment(Department dep);
	
	/**
	 * 新增一条考勤记录
	 * @param ar 新考勤记录 
	 */
	void addAttendanceRecord(AttendanceRecord ar);
	
	/**
	 * 根据传入的一条考勤记录判断该天该员工的考勤记录是否存在
	 * @param ar 考勤记录
	 * @return 返回true表示该考勤记录存在，false表示不存在
	 */
	boolean searchAttendanceRecord(AttendanceRecord ar);
	
	/**
	 * 修改员工的考勤记录
	 * @param ar 需要更新的员工的考勤记录
	 */
	void updateAttendanceRecord(AttendanceRecord ar);
	
	/**
	 * 获得全部的考勤记录 
	 * @return 全部的考勤记录
	 */
	List<AttendanceRecord> getAttendanceRecord();
	
	/**
	 * 获得指定页面的考勤记录
	 * @param pageNo 指定页面
	 * @return 考勤记录
	 */
	Page<AttendanceRecord> getPage(int pageNo);
	
	/**
	 * 获得默认的新员工编号
	 * @return 新员工编号
	 */
	String getDefaultEmpId();
	 
	/**
	 * 根据部门编号获得该部门的全部员工信息
	 * @param depid 部门编号
	 * @return 指定部门的全部员工信息
	 */
	List<Employee> getEmployeeByOffice(String depid);
	
	/**
	 * 根据部门编号获得部门名
	 * @param depid 部门编号
	 * @return 存在就返回该部门名称，不存在默认返回"行政部门"
	 */
	String getDname(String depid);
 
}
