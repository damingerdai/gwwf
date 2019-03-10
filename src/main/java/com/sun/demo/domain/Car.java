package com.sun.demo.domain;
/**
 * 车辆
 * @author daming
 *
 */
public class Car {
	/**
	 * 车牌号
	 */
	private String carId;
	/**
	 * 车型
	 */
	private String carType;
	/**
	 * 司机的员工编号
	 */
	private String dirverId;
	/**
	 * 使用的类型
	 */
	private String usageType;
	/**
	 * 购买时间
	 */
	private String buyTime;
	/**
	 * 车辆的容量
	 */
	private int capacity;
	/**
	 * 车辆容量的单位
	 */
	private String capunit;
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
	 * carType的get方法
	 * @return
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * carType的set方法
	 * @param carType
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}
	/**
	 * dirverId的get方法
	 * @return
	 */
	public String getDirverId() {
		return dirverId;
	}
	/**
	 * dirverId的set方法
	 * @param dirverId
	 */
	public void setDirverId(String dirverId) {
		this.dirverId = dirverId;
	}
	/**
	 * usageType的get方法
	 * @return
	 */
	public String getUsageType() {
		return usageType;
	}
	/**
	 * usageType的set方法
	 * @param usageType
	 */
	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}
	/**
	 * buytime的get方法
	 * @return
	 */
	public String getBuyTime() {
		return buyTime;
	}
	/**
	 * buytime的set方法
	 * @param buyTime
	 */
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	/**
	 * capacity的get方法
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * capacity的set方法
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * capacity的set方法
	 * 当参数为String类型时，该set方法将自动进行类型转换
	 * 当转换失败时，capacity默认为5
	 * @param capacityStr
	 */
	public void setCapacity(String capacityStr)
	{
		int capacity = 5;
		try
		{
			capacity = Integer.parseInt(capacityStr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		this.capacity = capacity;
	}
	/**
	 * capunit的get方法
	 * @return
	 */
	public String getCapunit() {
		return capunit;
	}
	/**
	 * setCapunit的set方法
	 * @param capunit
	 */
	public void setCapunit(String capunit) {
		this.capunit = capunit;
	}
	/**
	 * Car的构造方法
	 * 实现全部的属性的初始化
	 * @param carId
	 * @param carType
	 * @param dirverId
	 * @param usageType
	 * @param buyTime
	 * @param capacity
	 * @param capunit
	 */
	public Car(String carId, String carType, String dirverId, String usageType,
			String buyTime, int capacity, String capunit) {
		super();
		this.carId = carId;
		this.carType = carType;
		this.dirverId = dirverId;
		this.usageType = usageType;
		this.buyTime = buyTime;
		this.capacity = capacity;
		this.capunit = capunit;
	}
	/**
	 * Car的默认构造方法
	 */
	public Car() {
		super();
	}
	/**
	 * car的toString方法
	 */
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carType=" + carType + ", dirverId="
				+ dirverId + ", usageType=" + usageType + ", buyTime="
				+ buyTime + ", capacity=" + capacity + ", capunit=" + capunit
				+ "]";
	}
 
}
