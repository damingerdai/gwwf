package org.daming.gwwf.bean;

import com.google.common.base.MoreObjects;

/**
 * 用户
 * @author daming
 *
 */
public class User {
	/**
	 * 用户的员工编号
	 */
	private String empId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户权限
	 */
	private String privilege;
	/**
	 * empId的get方法
	 * @return
	 */
	public String getEmpId() {
		return empId;
	}
	/**
	 * empId的set方法
	 * @param empId
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	/**
	 * usrename的get方法
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * username的set方法
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * password的get方法
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * password的set方法
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * privilege的get方法
	 * @return
	 */
	public String getPrivilege() {
		return privilege;
	}
	/**
	 * privilege的set方法
	 * @param privilege
	 */
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	/**
	 * User的构造方法
	 * 实现全部属性的初始化
	 * @param empId
	 * @param username
	 * @param password
	 * @param privilege
	 */
	public User(String empId, String username, String password, String privilege) {
		super();
		this.empId = empId;
		this.username = username;
		this.password = password;
		this.privilege = privilege;
	}
	/**
	 * User的默认构造方法
	 */
	public User() {
		super();
	}
	/**
	 * User的构造方法
	 * 实现empid和password的初始化
	 * @param empid
	 * @param password
	 */
	public User(String empid, String password) {
		this.empId = empid;
		this.password = password;
	}
	/**
	 * User的toString方法
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("empId", empId)
				.add("username", username)
				.add("password", password)
				.add("privilege", privilege)
				.toString();
	}
}
