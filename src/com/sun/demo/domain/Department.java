package com.sun.demo.domain;
/**
 * 部门
 * @author daming
 *
 */
public class Department {
	/**
	 * 部门编号
	 */
	private String depid;
	/**
	 * 部门名称
	 */
	private String dname;
	/**
	 * depid的get方法
	 * @return
	 */
	public String getDepid() {
		return depid;
	}
	/**
	 * depid的set方法
	 * @param depid
	 */
	public void setDepid(String depid) {
		this.depid = depid;
	}
	/**
	 * dname的get方法
	 * @return
	 */
	public String getDname() {
		return dname;
	}
	/**
	 * dname的set方法
	 * @param dname
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}
	/**
	 * Department的构造方法
	 * 实现全部属性的初始化
	 * @param depid
	 * @param dname
	 */
	public Department(String depid, String dname) {
		super();
		this.depid = depid;
		this.dname = dname;
	}
	/**
	 * Department的默认构造方法
	 */
	public Department() {
		super();
	}
	/**
	 * Department的toString方法
	 */
	@Override
	public String toString() {
		return "Department [depid=" + depid + ", dname=" + dname + "]";
	}
	
}
