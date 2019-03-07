package com.sun.demo.office.service;

import java.util.List;

import com.sun.demo.bean.OfficeStationery;
/**
 * �칫��Ʒ����ĺ�̨����ӿ�
 * @author daming
 *
 */
public interface IOfficeService {
	/**
	 * ���ȫ���İ칫��Ʒ��Ϣ
	 * @return ��ȫ���칫��Ʒ����Ϣ
	 */
	List<OfficeStationery> getOffice();
	
	/**
	 * ����ָ��Ա��ʹ��ָ���칫��Ʒ�����
	 * @param empid ��Ա�����
	 * @param list ����Ҫ���°칫��Ʒ����Ϣ
	 */
	void updateOfficeUsage(String empid,List<OfficeStationery> list);
	
	/**
	 * ���°칫��Ʒ�Ŀ����Ϣ
	 * @param list ��Ҫ���µİ칫��Ʒ����Ϣ
	 */
	void updateOfficeStationery(List<OfficeStationery> list);
}
