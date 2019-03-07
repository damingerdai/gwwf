package com.sun.demo.bean;
/**
 * 办公用品
 * @author daming
 *
 */
public class OfficeStationery {
	/**
	 * 办公用品的名称
	 */
	private String uname;
	/**
	 * 办公用品的单位
	 */
	private String unit;
	/**
	 * 办公用品的数量
	 */
	private int storeNumber;
	/**
	 * uname的get方法
	 * @return
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * uname的set方法
	 * @param uname
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * unit的get方法
	 * @return
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * unit的set方法
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * storeNumber的get方法
	 * @return
	 */
	public int getStoreNumber() {
		return storeNumber;
	}
	/**
	 * storeNumber的set方法
	 * @param storeNumber
	 */
	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}
	/**
	 * OfficeStationery的构造方法
	 * 实现全部属性的初始化
	 * @param uname
	 * @param unit
	 * @param storeNumber
	 */
	public OfficeStationery(String uname, String unit, int storeNumber) {
		super();
		this.uname = uname;
		this.unit = unit;
		this.storeNumber = storeNumber;
	}
	/**
	 * OfficeStationery的默认构造方法
	 */
	public OfficeStationery() {
		super();
	}
	/**
	 * OfficeStationery的toString方法
	 */
	@Override
	public String toString() {
		return "Office [uname=" + uname + ", unit=" + unit + ", storeNumber="
				+ storeNumber + "]";
	}
	
}
