package com.sun.demo.domain;
/**
 * ����
 * @author daming
 *
 */
public class Car {
	/**
	 * ���ƺ�
	 */
	private String carId;
	/**
	 * ����
	 */
	private String carType;
	/**
	 * ˾����Ա�����
	 */
	private String dirverId;
	/**
	 * ʹ�õ�����
	 */
	private String usageType;
	/**
	 * ����ʱ��
	 */
	private String buyTime;
	/**
	 * ����������
	 */
	private int capacity;
	/**
	 * ���������ĵ�λ
	 */
	private String capunit;
	/**
	 * carId��get����
	 * @return
	 */
	public String getCarId() {
		return carId;
	}
	/**
	 * carId��set����
	 * @param carId
	 */
	public void setCarId(String carId) {
		this.carId = carId;
	}
	/**
	 * carType��get����
	 * @return
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * carType��set����
	 * @param carType
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}
	/**
	 * dirverId��get����
	 * @return
	 */
	public String getDirverId() {
		return dirverId;
	}
	/**
	 * dirverId��set����
	 * @param dirverId
	 */
	public void setDirverId(String dirverId) {
		this.dirverId = dirverId;
	}
	/**
	 * usageType��get����
	 * @return
	 */
	public String getUsageType() {
		return usageType;
	}
	/**
	 * usageType��set����
	 * @param usageType
	 */
	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}
	/**
	 * buytime��get����
	 * @return
	 */
	public String getBuyTime() {
		return buyTime;
	}
	/**
	 * buytime��set����
	 * @param buyTime
	 */
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	/**
	 * capacity��get����
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * capacity��set����
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * capacity��set����
	 * ������ΪString����ʱ����set�������Զ���������ת��
	 * ��ת��ʧ��ʱ��capacityĬ��Ϊ5
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
	 * capunit��get����
	 * @return
	 */
	public String getCapunit() {
		return capunit;
	}
	/**
	 * setCapunit��set����
	 * @param capunit
	 */
	public void setCapunit(String capunit) {
		this.capunit = capunit;
	}
	/**
	 * Car�Ĺ��췽��
	 * ʵ��ȫ�������Եĳ�ʼ��
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
	 * Car��Ĭ�Ϲ��췽��
	 */
	public Car() {
		super();
	}
	/**
	 * car��toString����
	 */
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carType=" + carType + ", dirverId="
				+ dirverId + ", usageType=" + usageType + ", buyTime="
				+ buyTime + ", capacity=" + capacity + ", capunit=" + capunit
				+ "]";
	}
 
}
