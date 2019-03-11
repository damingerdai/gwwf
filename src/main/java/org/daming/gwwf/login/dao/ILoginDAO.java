package org.daming.gwwf.login.dao;

import org.daming.gwwf.bean.User;
import org.daming.gwwf.domain.Employee;

/**
 * 有关登录模块的DAO操作的接口
 * @author daming
 */
public interface ILoginDAO {
	/**
	 * 判断数据库中是否存在用户或者密码是否正确
	 * @param user:用户在登录页面中输入的用户名和密码封装成的对象
	 * @return :若用户存在而且用户密码正确，返回true；否则返回false
	 */
	Employee findUser(User user);
	
	/**
	 * 根据员工编号查找员工
	 * @param empid
	 * @return 员工信息
	 */
	Employee searcheEmployee(String empId);
	
	/**
	 * 根据员工编号获得员工名;
	 * @param empId
	 * @return 员工名
	 */
	String searchUsername(String empId);
	
	/**
	 * 根据员工编号获得员工的部门编号
	 * @param empid
	 * @return 员工所在部门的员工编号
	 */
	String searchDepId(String empid);

}
