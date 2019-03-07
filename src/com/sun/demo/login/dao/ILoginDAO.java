package com.sun.demo.login.dao;

import com.sun.demo.bean.User;
import com.sun.demo.domain.Employee;

/**
 * �йص�¼ģ���DAO�����Ľӿ�
 * @author daming
 */
public interface ILoginDAO {
	/**
	 * �ж����ݿ����Ƿ�����û����������Ƿ���ȷ
	 * @param user:�û��ڵ�¼ҳ����������û����������װ�ɵĶ���
	 * @return :���û����ڶ����û�������ȷ������true�����򷵻�false
	 */
	Employee findUser(User user);
	
	/**
	 * ����Ա����Ų���Ա��
	 * @param empid
	 * @return Ա����Ϣ
	 */
	Employee searcheEmployee(String empId);
	
	/**
	 * ����Ա����Ż��Ա����;
	 * @param empId
	 * @return Ա����
	 */
	String searchUsername(String empId);
	
	/**
	 * ����Ա����Ż��Ա���Ĳ��ű��
	 * @param empid
	 * @return Ա�����ڲ��ŵ�Ա�����
	 */
	String searchDepId(String empid);

}
