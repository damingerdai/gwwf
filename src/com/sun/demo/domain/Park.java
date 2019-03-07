package com.sun.demo.domain;
/**
 * 车位
 * @author daming
 *
 */
public class Park {
	/**
	 * 车位编号
	 */
	private String pid;
	/**
	 * 车牌号
	 */
	private String carid;
	/**
	 * 说明
	 */
	private String instrucation;
	/**
	 * pid的get方法
	 * @return
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * pid的set方法
	 * @param pid
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * carid的get方法
	 * @return
	 */
	public String getCarid() {
		return carid;
	}
	/**
	 * carid的set方法
	 * @param carid
	 */
	public void setCarid(String carid) {
		this.carid = carid;
	}
	/**
	 * instrucation的get方法
	 * @return
	 */
	public String getInstrucation() {
		return instrucation;
	}
	/**
	 * instrucation的set方法
	 * @param instrucation
	 */
	public void setInstrucation(String instrucation) {
		this.instrucation = instrucation;
	}
	/**
	 * Park的构造方法
	 * 实现全部属性的初始化
	 * @param pid
	 * @param carid
	 * @param instrucation
	 */
	public Park(String pid, String carid, String instrucation) {
		super();
		this.pid = pid;
		this.carid = carid;
		this.instrucation = instrucation;
	}
	/**
	 * Park的默认构造方法
	 */
	public Park() {
		super();
	}
	/**
	 * Park的toString方法
	 */
	@Override
	public String toString() {
		return "Park [pid=" + pid + ", carid=" + carid + ", instrucation="
				+ instrucation + "]";
	}
	
}
