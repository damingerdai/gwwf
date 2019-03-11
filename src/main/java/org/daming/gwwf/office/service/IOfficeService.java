package org.daming.gwwf.office.service;

import java.util.List;

import org.daming.gwwf.bean.OfficeStationery;

/**
 * 办公用品所需的后台服务接口
 * @author daming
 *
 */
public interface IOfficeService {
	/**
	 * 获得全部的办公用品信息
	 * @return ：全部办公用品的信息
	 */
	List<OfficeStationery> getOffice();
	
	/**
	 * 更新指定员工使用指定办公用品的情况
	 * @param empid ：员工编号
	 * @param list ：需要更新办公用品的信息
	 */
	void updateOfficeUsage(String empid,List<OfficeStationery> list);
	
	/**
	 * 更新办公用品的库存信息
	 * @param list 需要更新的办公用品的信息
	 */
	void updateOfficeStationery(List<OfficeStationery> list);
}
