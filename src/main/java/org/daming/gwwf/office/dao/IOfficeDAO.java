package org.daming.gwwf.office.dao;

import java.util.List;

import org.daming.gwwf.bean.OfficeStationery;

/**
 * 办公用品相关的DAO接口
 * @author daming
 *
 */
public interface IOfficeDAO {
	/**
	 * 获得办公用品的全部信息
	 * @return ：类型为OfficeStationery的集合，存放着办公用品的信息
	 */
	List<OfficeStationery> getOffice();
	
	/**
	 * 更新指定员工使用办公用品的情况
	 * @param empid ：员工编号
	 * @param list ：办公用品的集合
	 */
	void updateOfficeUsage(String empid, List<OfficeStationery> list);
	
	/**
	 *  获得该员工的办公用品使用信息
	 * @param empid ：员工编号
	 * @param off ：办公用品
	 * @return ture表示指定员工存在指定办公用品的情况，false表示指定员工不存在指定办公用品的情况
	 */
	boolean getOfficeUsageInfo(String empid,OfficeStationery off);
	
	/**
	 * 更新办公用品的情况
	 * @param empid ：员工编号
	 * @param updateList ：执行更新部分的办公用品的集合
	 * @param insertList ：执行插入部分的办公用品的集合
	 */
	void updateOfficeUsageInfo(String empid,List<OfficeStationery> updateList,List<OfficeStationery> insertList);
	
	/**
	 * 判断该办公用品是否已经存在
	 * @param uname ：办公用品的名称
	 * @param unit ：办公用品的单位
	 * @return true:表示存在，false：表示不存在
	 */
	boolean checkOfficeStationery(String uname,String unit);
	
	/**
	 * 更新办公用品的库存的信息
	 * @param updateList ：执行更新部分的办公用品的集合
	 * @param insertList ：执行插入部分的办公用品的集合
	 */
	void updateOfficeStationery(List<OfficeStationery> updateList,List<OfficeStationery> insertList);
}
