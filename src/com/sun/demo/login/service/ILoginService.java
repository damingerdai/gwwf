package com.sun.demo.login.service;

import com.sun.demo.bean.User;
import com.sun.demo.domain.Employee;

/**
 *  �û���¼���˳�ʱ����ĺ�̨����
 * @author daming
 *
 */
public interface ILoginService {
	
	/**
	 * �����û��Ƿ����
	 * empid_error ��Ա����Ŵ���
	 * password_error���������
	 * @param user
	 * @return ��������
	 */
	String checkUser(User user);
	
	/**
	 * �жϸ��û��Ƿ����
	 * @param empid
	 * @return ��Ա�������򷵻�Ա����Ϣ����Ա���������򷵻�null
	 */
	Employee searchEmployee(String empId);
	
	/**
	 * ����Ա����Ż��Ա����;
	 * @param empId
	 * @return Ա����
	 */
	String searchUsername(String empId);
	
	/**
	 * ����Ա����Ż��Ա���Ĳ��ű��
	 * @param empid
	 * @return Ա�����ڲ��ŵĲ��� ���
	 */
	String searchDepId(String empid);
}
