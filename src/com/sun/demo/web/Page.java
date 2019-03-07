package com.sun.demo.web;

import java.util.List;
/**
 * ��ҳ���ܴ���
 * @author daming
 *
 * @param <T> ҳ������Ҫչʾ��Ϣ
 */
public class Page<T> {
	/**
	 * ָ��ҳ��
	 */
	private int pageNo;
	/**
	 * ��ǰҳ����Ϣ����
	 */
	private List<T> list;
	/**
	 * ÿҳ��ʾ��Ϣ����
	 */
	private int pageSize = 5;
	/**
	 * �ܵ�ҳ����
	 */
	private long totalItemNumber;
	/**
	 * Page�Ĺ��췽��
	 * @param pageNo ָ��ҳ��
	 */
	public Page(int pageNo)
	{
		this.pageNo = pageNo;
	}
	/**
	 * pageNo��get����
	 * ��pageNo�����ܵ�ҳ����ʱ����pageNo����Ϊ��ҳ����
	 * ��pageNoС�ڵ���0ʱ����pageNo����Ϊ1
	 * @return
	 */
	public int getPageNo() {
		if(pageNo <= 0)
		{
			pageNo = 1;
		}
		if(pageNo > getTotalPageNumber())
		{
			pageNo = getTotalPageNumber();
		}
		return pageNo;
	}
	
	/**
	 * list��get����
	 * @return
	 */
	public List<T> getList() {
		return list;
	}
	/**
	 * list��set����
	 * @param list
	 */
	public void setList(List<T> list) {
		this.list = list;
	}
	/**
	 * pageSize��get����
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * totalItemNumber��set����
	 * @param totalItemNumber
	 */
	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}
	/**
	 * totalItemNumber��get����
	 * @return
	 */
	public long getTotalItemNumber()
	{
		return totalItemNumber;
	}
	
	/**
	 * �����ҳ��
	 * @return ��ҳ��
	 */
	public int getTotalPageNumber()
	{
		int totalPageNumber = (int)totalItemNumber / pageSize;
		if(totalItemNumber % pageSize != 0)
		{
			totalPageNumber ++ ;
		}
		return totalPageNumber;
	}
	
	/**
	 * �ж��Ƿ�����һҳ
	 * @return ������һҳ�򷵻�true����������һҳ�򲻷���false
	 */
	public boolean isHasNext()
	{
		if(getPageNo() < getTotalPageNumber())
		{
			return true;
		}
		return false;
	}
	/**
	 * �ж��Ƿ�����һҳ
	 * @return ������һҳ�򷵻�true����������һҳ�򷵻�false
	 */
	public boolean isHasPrev()
	{
		if(getPageNo() > 1)
		{
			return true;
		}
		return false;
	}
	/**
	 * �����һҳ
	 * @return ��һҳ
	 */
	public int getPrevPage()
	{
		if(isHasPrev())
		{
			return getPageNo() - 1;
		}
		return getPageNo();
	}
	/**
	 * �����һҳ
	 * @return ��һҳ
	 */
	public int getNextPage()
	{
		if(isHasNext())
		{
			return getPageNo() + 1;
		}
		return getPageNo();
	}
	
	/**
	 * Page��toString����
	 */
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", list=" + list + ", pageSize="
				+ pageSize + ", totalItemNumber=" + totalItemNumber + "]";
	}
	
}
