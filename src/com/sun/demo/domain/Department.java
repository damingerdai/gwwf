package com.sun.demo.domain;
/**
 * ����
 * @author daming
 *
 */
public class Department {
	/**
	 * ���ű��
	 */
	private String depid;
	/**
	 * ��������
	 */
	private String dname;
	/**
	 * depid��get����
	 * @return
	 */
	public String getDepid() {
		return depid;
	}
	/**
	 * depid��set����
	 * @param depid
	 */
	public void setDepid(String depid) {
		this.depid = depid;
	}
	/**
	 * dname��get����
	 * @return
	 */
	public String getDname() {
		return dname;
	}
	/**
	 * dname��set����
	 * @param dname
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}
	/**
	 * Department�Ĺ��췽��
	 * ʵ��ȫ�����Եĳ�ʼ��
	 * @param depid
	 * @param dname
	 */
	public Department(String depid, String dname) {
		super();
		this.depid = depid;
		this.dname = dname;
	}
	/**
	 * Department��Ĭ�Ϲ��췽��
	 */
	public Department() {
		super();
	}
	/**
	 * Department��toString����
	 */
	@Override
	public String toString() {
		return "Department [depid=" + depid + ", dname=" + dname + "]";
	}
	
}
