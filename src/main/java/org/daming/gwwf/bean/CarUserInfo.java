package org.daming.gwwf.bean;

import com.google.common.base.MoreObjects;

/**
 * 车辆的使用信息
 * @author daming
 *
 */
public class CarUserInfo {
	/**
	 * 车牌号
	 */
	private String carId;
	/**
	 * 车辆使用的出发时间
	 */
	private String usageTime_begin;
	/**
	 * 车辆使用的结束时间
	 */
	private String usageTime_end;
	/**
	 * 车辆使用的目的
	 */
	private String usage;
	/**
	 * 车辆使用者的员工编号
	 */
	private String userId;
	/**
	 * carId的get方法
	 * @return
	 */
	public String getCarId() {
		return carId;
	}
	/**
	 * carId的set方法
	 * @param carId
	 */
	public void setCarId(String carId) {
		this.carId = carId;
	}
	/**
	 * usageTime_begin的get方法
	 * @return
	 */
	public String getUsageTime_begin() {
		return usageTime_begin;
	}
	/**
	 * usageTime_begin的set方法
	 * @param usageTime_begin
	 */
	public void setUsageTime_begin(String usageTime_begin) {
		this.usageTime_begin = usageTime_begin;
	}
	/**
	 * usageTime_end的get方法
	 * @return
	 */
	public String getUsageTime_end() {
		return usageTime_end;
	}
	/**
	 * usageTime_end的set方法
	 * @param usageTime_end
	 */
	public void setUsageTime_end(String usageTime_end) {
		this.usageTime_end = usageTime_end;
	}
	/**
	 * usage的get方法
	 * @return
	 */
	public String getUsage() {
		return usage;
	}
	/**
	 * usage的set方法
	 * @param usage
	 */
	public void setUsage(String usage) {
		this.usage = usage;
	}
	/**
	 * userId的get方法
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * userId的set方法
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * CarUserInfo的构造方法；
	 * 实现全部的属性的初始化
	 * @param carId
	 * @param usageTime_begin
	 * @param usageTime_end
	 * @param usage
	 * @param userId
	 */
	public CarUserInfo(String carId, String usageTime_begin,
			String usageTime_end, String usage, String userId) {
		super();
		this.carId = carId;
		this.usageTime_begin = usageTime_begin;
		this.usageTime_end = usageTime_end;
		this.usage = usage;
		this.userId = userId;
	}
	/**
	 * CarUserInfo的默认构造方法
	 */
	public CarUserInfo() {
		super();
	}
	/**
	 * CarUserInfo的toString方法
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("carId", carId)
				.add("usageTime_begin", usageTime_begin)
				.add("usageTime_end", usageTime_end)
				.add("usage", usage)
				.add("userId", userId)
				.toString();
	}
}
