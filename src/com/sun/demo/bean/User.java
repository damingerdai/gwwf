package com.sun.demo.bean;
/**
 * �û�
 * @author daming
 *
 */
public class User {
	/**
	 * �û���Ա�����
	 */
	private String empId;
	/**
	 * �û���
	 */
	private String username;
	/**
	 * ����
	 */
	private String password;
	/**
	 * �û�Ȩ��
	 */
	private String privilege;
	/**
	 * empId��get����
	 * @return
	 */
	public String getEmpId() {
		return empId;
	}
	/**
	 * empId��set����
	 * @param empId
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	/**
	 * usrename��get����
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * username��set����
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * password��get����
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * password��set����
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * privilege��get����
	 * @return
	 */
	public String getPrivilege() {
		return privilege;
	}
	/**
	 * privilege��set����
	 * @param privilege
	 */
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	/**
	 * User�Ĺ��췽��
	 * ʵ��ȫ�����Եĳ�ʼ��
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
	 * User��Ĭ�Ϲ��췽��
	 */
	public User() {
		super();
	}
	/**
	 * User�Ĺ��췽��
	 * ʵ��empid��password�ĳ�ʼ��
	 * @param empid
	 * @param password
	 */
	public User(String empid, String password) {
		this.empId = empid;
		this.password = password;
	}
	/**
	 * User��toString����
	 */
	@Override
	public String toString() {
		return "User [empId=" + empId + ", username=" + username
				+ ", password=" + password + ", privilege=" + privilege + "]";
	}
	
}
