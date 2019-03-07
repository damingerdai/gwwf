package com.sun.demo.bean;

/**
 * ���ڼ�¼
 * @author daming
 *
 */
public class AttendanceRecord {
	/**
	 * Ա�����
	 */
	private String empid;
	/**
	 * ����
	 * ��ʽ��yyyy-MM-dd
	 */
	private String cdate;
	/**
	 * �ϰ�ʱ��
	 * ��ʽ��HH��mm
	 */
	private String ontime;
	/**
	 * �°�ʱ��
	 * ��ʽ��HH��mm
	 */
	private String offtime;
	/**
	 * �ϰ�����
	 * ��Ϊ�ϰ�ͼӰ�����
	 */
	private String ctype;
	/**
	 * ��ע
	 */
	private String remark;
	
	/**
	 * remark��get����
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * remark��set����
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * empid��get����
	 * @return 
	 */
	public String getEmpid() {
		return empid;
	}
	/**
	 * empid��set����
	 * @param empid
	 */
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	/**
	 * cdate��get����
	 * @return
	 */
	public String getCdate() {
		return cdate;
	}
	/**
	 * cdate��set����
	 * @param cdate
	 */
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	/**
	 * ontime��get����
	 * @return
	 */
	public String getOntime() {
		return ontime;
	}
	/**
	 * ontime��set����
	 * @param ontime
	 */
	public void setOntime(String ontime) {
		this.ontime = ontime;
	}
	/**
	 * offtime��get����
	 * @return
	 */
	public String getOfftime() {
		return offtime;
	}
	/**
	 * offtime��set����
	 * @param offtime
	 */
	public void setOfftime(String offtime) {
		this.offtime = offtime;
	}
	/**
	 * ctype��get����
	 * @return
	 */
	public String getCtype() {
		return ctype;
	}
	/**
	 * ctype��set����
	 * @param ctype
	 */
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	/**
	 * AttendanceRecord�Ĺ��췽����
	 * ʵ��ȫ�������Եĳ�ʼ��
	 * @param empid
	 * @param cdate
	 * @param ontime
	 * @param offtime
	 * @param ctype
	 */
	public AttendanceRecord(String empid, String cdate, String ontime,
			String offtime, String ctype) {
		super();
		this.empid = empid;
		this.cdate = cdate;
		this.ontime = ontime;
		this.offtime = offtime;
		this.ctype = ctype;
	}
	/**
	 * AttendanceRecord��Ĭ�Ϲ��췽��
	 */
	public AttendanceRecord() {
		super();
	}
	/**
	 * AttendanceRecord��toString����
	 */
	@Override
	public String toString() {
		return "AttendanceRecord [empid=" + empid + ", cdate=" + cdate
				+ ", ontime=" + ontime + ", offtime=" + offtime + ", ctype="
				+ ctype + ", remark=" + remark + "]";
	}
	
}
