package com.sun.demo.domain;
/**
 * ��λ
 * @author daming
 *
 */
public class Park {
	/**
	 * ��λ���
	 */
	private String pid;
	/**
	 * ���ƺ�
	 */
	private String carid;
	/**
	 * ˵��
	 */
	private String instrucation;
	/**
	 * pid��get����
	 * @return
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * pid��set����
	 * @param pid
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * carid��get����
	 * @return
	 */
	public String getCarid() {
		return carid;
	}
	/**
	 * carid��set����
	 * @param carid
	 */
	public void setCarid(String carid) {
		this.carid = carid;
	}
	/**
	 * instrucation��get����
	 * @return
	 */
	public String getInstrucation() {
		return instrucation;
	}
	/**
	 * instrucation��set����
	 * @param instrucation
	 */
	public void setInstrucation(String instrucation) {
		this.instrucation = instrucation;
	}
	/**
	 * Park�Ĺ��췽��
	 * ʵ��ȫ�����Եĳ�ʼ��
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
	 * Park��Ĭ�Ϲ��췽��
	 */
	public Park() {
		super();
	}
	/**
	 * Park��toString����
	 */
	@Override
	public String toString() {
		return "Park [pid=" + pid + ", carid=" + carid + ", instrucation="
				+ instrucation + "]";
	}
	
}
