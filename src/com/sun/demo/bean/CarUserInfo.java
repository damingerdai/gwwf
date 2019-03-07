package com.sun.demo.bean;
/**
 * ������ʹ����Ϣ
 * @author daming
 *
 */
public class CarUserInfo {
	/**
	 * ���ƺ�
	 */
	private String carId;
	/**
	 * ����ʹ�õĳ���ʱ��
	 */
	private String usageTime_begin;
	/**
	 * ����ʹ�õĽ���ʱ��
	 */
	private String usageTime_end;
	/**
	 * ����ʹ�õ�Ŀ��
	 */
	private String usage;
	/**
	 * ����ʹ���ߵ�Ա�����
	 */
	private String userId;
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
	 * usageTime_begin��get����
	 * @return
	 */
	public String getUsageTime_begin() {
		return usageTime_begin;
	}
	/**
	 * usageTime_begin��set����
	 * @param usageTime_begin
	 */
	public void setUsageTime_begin(String usageTime_begin) {
		this.usageTime_begin = usageTime_begin;
	}
	/**
	 * usageTime_end��get����
	 * @return
	 */
	public String getUsageTime_end() {
		return usageTime_end;
	}
	/**
	 * usageTime_end��set����
	 * @param usageTime_end
	 */
	public void setUsageTime_end(String usageTime_end) {
		this.usageTime_end = usageTime_end;
	}
	/**
	 * usage��get����
	 * @return
	 */
	public String getUsage() {
		return usage;
	}
	/**
	 * usage��set����
	 * @param usage
	 */
	public void setUsage(String usage) {
		this.usage = usage;
	}
	/**
	 * userId��get����
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * userId��set����
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * CarUserInfo�Ĺ��췽����
	 * ʵ��ȫ�������Եĳ�ʼ��
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
	 * CarUserInfo��Ĭ�Ϲ��췽��
	 */
	public CarUserInfo() {
		super();
	}
	/**
	 * CarUserInfo��toString����
	 */
	@Override
	public String toString() {
		return "CarUseInfo [carId=" + carId + ", usageTime_begin="
				+ usageTime_begin + ", usageTime_end=" + usageTime_end
				+ ", usage=" + usage + ", userId=" + userId + "]";
	}
	
}	
