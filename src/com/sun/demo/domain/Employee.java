package com.sun.demo.domain;
/**
 * 员工
 * @author daming
 *
 */
public class Employee {
	/**
	 * 员工号
	 */
	private String empId;
	/**
	 * 员工名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * 专业
	 */
	private String major;
	/**
	 * 学历
	 */
	private String edu;
	/**
	 * 毕业学校
	 */
	private String college;
	/**
	 * 部门编号
	 */
	private String depId;
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
	 * username的get方法
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
	 * gender的get方法
	 * @return
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * gender的set方法
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * birthday的get方法
	 * @return
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * birthday的set方法
	 * @param birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * major的get方法
	 * @return
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * major的set方法
	 * @param major
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * edu的get方法
	 * @return
	 */
	public String getEdu() {
		return edu;
	}
	/**
	 * edu的set方法
	 * @param edu
	 */
	public void setEdu(String edu) {
		this.edu = edu;
	}
	/**
	 * college的get方法
	 * @return
	 */
	public String getCollege() {
		return college;
	}
	/**
	 * college的set方法
	 * @param college
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	/**
	 * depId的get方法
	 * @return
	 */
	public String getDepId() {
		return depId;
	}
	/**
	 * depId的set方法
	 * @param depId
	 */
	public void setDepId(String depId) {
		this.depId = depId;
	}
	/**
	 * Employee的构造方法
	 * 实现全部属性的初始化
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
	 * Employee的默认构造方法
	 */
	public Employee() {
		super();
	}
	/**
	 * Employee的toString方法
	 */
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", username=" + username
				+ ", password=" + password + ", gender=" + gender
				+ ", birthday=" + birthday + ", major=" + major + ", edu="
				+ edu + ", college=" + college + ", depId=" + depId + "]";
	}
	 
}
