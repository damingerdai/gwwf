package org.daming.gwwf.bean;

import com.google.common.base.MoreObjects;

/**
 * 考勤记录
 * @author daming
 *
 */
public class AttendanceRecord {
	/**
	 * 员工编号
	 */
	private String empid;
	/**
	 * 日期
	 * 格式：yyyy-MM-dd
	 */
	private String cdate;
	/**
	 * 上班时间
	 * 格式：HH：mm
	 */
	private String ontime;
	/**
	 * 下班时间
	 * 格式：HH：mm
	 */
	private String offtime;
	/**
	 * 上班类型
	 * 分为上班和加班两种
	 */
	private String ctype;
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * remark的get方法
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * remark的set方法
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * empid的get方法
	 * @return 
	 */
	public String getEmpid() {
		return empid;
	}
	/**
	 * empid的set方法
	 * @param empid
	 */
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	/**
	 * cdate的get方法
	 * @return
	 */
	public String getCdate() {
		return cdate;
	}
	/**
	 * cdate的set方法
	 * @param cdate
	 */
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	/**
	 * ontime的get方法
	 * @return
	 */
	public String getOntime() {
		return ontime;
	}
	/**
	 * ontime的set方法
	 * @param ontime
	 */
	public void setOntime(String ontime) {
		this.ontime = ontime;
	}
	/**
	 * offtime的get方法
	 * @return
	 */
	public String getOfftime() {
		return offtime;
	}
	/**
	 * offtime的set方法
	 * @param offtime
	 */
	public void setOfftime(String offtime) {
		this.offtime = offtime;
	}
	/**
	 * ctype的get方法
	 * @return
	 */
	public String getCtype() {
		return ctype;
	}
	/**
	 * ctype的set方法
	 * @param ctype
	 */
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	/**
	 * AttendanceRecord的构造方法，
	 * 实现全部的属性的初始化
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
	 * AttendanceRecord的默认构造方法
	 */
	public AttendanceRecord() {
		super();
	}

	/**
	 * AttendanceRecord的toString方法
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("empid", empid)
				.add("cdate", cdate)
				.add("ontime", ontime)
				.add("offtime", offtime)
				.add("ctype", ctype)
				.add("remark", remark)
				.toString();
	}
}
