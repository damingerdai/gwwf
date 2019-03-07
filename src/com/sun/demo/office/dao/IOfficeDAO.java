package com.sun.demo.office.dao;

import java.util.List;

import com.sun.demo.bean.OfficeStationery;
/**
 * �칫��Ʒ��ص�DAO�ӿ�
 * @author daming
 *
 */
public interface IOfficeDAO {
	/**
	 * ��ð칫��Ʒ��ȫ����Ϣ
	 * @return ������ΪOfficeStationery�ļ��ϣ�����Ű칫��Ʒ����Ϣ
	 */
	List<OfficeStationery> getOffice();
	
	/**
	 * ����ָ��Ա��ʹ�ð칫��Ʒ�����
	 * @param empid ��Ա�����
	 * @param list ���칫��Ʒ�ļ���
	 */
	void updateOfficeUsage(String empid, List<OfficeStationery> list);
	
	/**
	 *  ��ø�Ա���İ칫��Ʒʹ����Ϣ
	 * @param empid ��Ա�����
	 * @param off ���칫��Ʒ
	 * @return ture��ʾָ��Ա������ָ���칫��Ʒ�������false��ʾָ��Ա��������ָ���칫��Ʒ�����
	 */
	boolean getOfficeUsageInfo(String empid,OfficeStationery off);
	
	/**
	 * ���°칫��Ʒ�����
	 * @param empid ��Ա�����
	 * @param updateList ��ִ�и��²��ֵİ칫��Ʒ�ļ���
	 * @param insertList ��ִ�в��벿�ֵİ칫��Ʒ�ļ���
	 */
	void updateOfficeUsageInfo(String empid,List<OfficeStationery> updateList,List<OfficeStationery> insertList);
	
	/**
	 * �жϸð칫��Ʒ�Ƿ��Ѿ�����
	 * @param uname ���칫��Ʒ������
	 * @param unit ���칫��Ʒ�ĵ�λ
	 * @return true:��ʾ���ڣ�false����ʾ������
	 */
	boolean checkOfficeStationery(String uname,String unit);
	
	/**
	 * ���°칫��Ʒ�Ŀ�����Ϣ
	 * @param updateList ��ִ�и��²��ֵİ칫��Ʒ�ļ���
	 * @param insertList ��ִ�в��벿�ֵİ칫��Ʒ�ļ���
	 */
	void updateOfficeStationery(List<OfficeStationery> updateList,List<OfficeStationery> insertList);
}
