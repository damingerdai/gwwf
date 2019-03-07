package com.sun.demo.domain;
/**
 * Ա��
 * @author daming
 *
 */
public class Employee {
	/**
	 * Ա����
	 */
	private String empId;
	/**
	 * Ա����
	 */
	private String username;
	/**
	 * ����
	 */
	private String password;
	/**
	 * �Ա�
	 */
	private String gender;
	/**
	 * ����
	 */
	private String birthday;
	/**
	 * רҵ
	 */
	private String major;
	/**
	 * ѧ��
	 */
	private String edu;
	/**
	 * ��ҵѧУ
	 */
	private String college;
	/**
	 * ���ű��
	 */
	private String depId;
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
	 * username��get����
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
	 * gender��get����
	 * @return
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * gender��set����
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * birthday��get����
	 * @return
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * birthday��set����
	 * @param birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * major��get����
	 * @return
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * major��set����
	 * @param major
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * edu��get����
	 * @return
	 */
	public String getEdu() {
		return edu;
	}
	/**
	 * edu��set����
	 * @param edu
	 */
	public void setEdu(String edu) {
		this.edu = edu;
	}
	/**
	 * college��get����
	 * @return
	 */
	public String getCollege() {
		return college;
	}
	/**
	 * college��set����
	 * @param college
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	/**
	 * depId��get����
	 * @return
	 */
	public String getDepId() {
		return depId;
	}
	/**
	 * depId��set����
	 * @param depId
	 */
	public void setDepId(String depId) {
		this.depId = depId;
	}
	/**
	 * Employee�Ĺ��췽��
	 * ʵ��ȫ�����Եĳ�ʼ��
	 * @param empId
	 * @param username
	 * @param password
	 * @param gender
	 * @param birthday
	 * @param major
	 * @param edu
	 * @param college
	 * @param depId
	 */
	public Employee(String empId, String username, String password,
			String gender, String birthday, String major, String edu,
			String college, String depId) {
		super();
		this.empId = empId;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.edu = edu;
		this.college = college;
		this.depId = depId;
	}
	/**
	 * Employee��Ĭ�Ϲ��췽��
	 */
	public Employee() {
		super();
	}
	/**
	 * Employee��toString����
	 */
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", username=" + username
				+ ", password=" + password + ", gender=" + gender
				+ ", birthday=" + birthday + ", major=" + major + ", edu="
				+ edu + ", college=" + college + ", depId=" + depId + "]";
	}
	 
}
