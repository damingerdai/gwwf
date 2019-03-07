package com.sun.demo.login.service;

import com.sun.demo.bean.User;
import com.sun.demo.domain.Employee;

/**
 *  用户登录，退出时所需的后台服务
 * @author daming
 *
 */
public interface ILoginService {
	
	/**
	 * 检查该用户是否存在
	 * empid_error ：员工编号错误
	 * password_error：密码错误
	 * @param user
	 * @return 错误类型
	 */
	String checkUser(User user);
	
	/**
	 * 判断该用户是否存在
	 * @param empid
	 * @return 若员工存在则返回员工信息，若员工不存在则返回null
	 */
	Employee searchEmployee(String empId);
	
	/**
	 * 根据员工编号获得员工名;
	 * @param empId
	 * @return 员工名
	 */
	String searchUsername(String empId);
	
	/**
	 * 根据员工编号获得员工的部门编号
	 * @param empid
	 * @return 员工所在部门的部门 编号
	 */
	String searchDepId(String empid);
}
