package com.sun.demo.bean;
/**
 * �칫��Ʒ
 * @author daming
 *
 */
public class OfficeStationery {
	/**
	 * �칫��Ʒ������
	 */
	private String uname;
	/**
	 * �칫��Ʒ�ĵ�λ
	 */
	private String unit;
	/**
	 * �칫��Ʒ������
	 */
	private int storeNumber;
	/**
	 * uname��get����
	 * @return
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * uname��set����
	 * @param uname
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * unit��get����
	 * @return
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * unit��set����
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * storeNumber��get����
	 * @return
	 */
	public int getStoreNumber() {
		return storeNumber;
	}
	/**
	 * storeNumber��set����
	 * @param storeNumber
	 */
	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}
	/**
	 * OfficeStationery�Ĺ��췽��
	 * ʵ��ȫ�����Եĳ�ʼ��
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
	 * OfficeStationery��Ĭ�Ϲ��췽��
	 */
	public OfficeStationery() {
		super();
	}
	/**
	 * OfficeStationery��toString����
	 */
	@Override
	public String toString() {
		return "Office [uname=" + uname + ", unit=" + unit + ", storeNumber="
				+ storeNumber + "]";
	}
	
}
