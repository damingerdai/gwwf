package org.daming.gwwf.web;

import java.util.List;
/**
 * 分页功能处理
 * @author daming
 *
 * @param <T> 页面上所要展示信息
 */
public class Page<T> {
	/**
	 * 指定页面
	 */
	private int pageNo;
	/**
	 * 当前页的信息集合
	 */
	private List<T> list;
	/**
	 * 每页显示信息数量
	 */
	private int pageSize = 5;
	/**
	 * 总的页面数
	 */
	private long totalItemNumber;
	/**
	 * Page的构造方法
	 * @param pageNo 指定页面
	 */
	public Page(int pageNo)
	{
		this.pageNo = pageNo;
	}
	/**
	 * pageNo的get方法
	 * 当pageNo大于总的页面数时，将pageNo设置为总页面数
	 * 当pageNo小于等于0时，将pageNo设置为1
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
	 * list的get方法
	 * @return
	 */
	public List<T> getList() {
		return list;
	}
	/**
	 * list的set方法
	 * @param list
	 */
	public void setList(List<T> list) {
		this.list = list;
	}
	/**
	 * pageSize的get方法
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * totalItemNumber的set方法
	 * @param totalItemNumber
	 */
	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}
	/**
	 * totalItemNumber的get方法
	 * @return
	 */
	public long getTotalItemNumber()
	{
		return totalItemNumber;
	}
	
	/**
	 * 获得总页数
	 * @return 总页数
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
	 * 判断是否有下一页
	 * @return 存在下一页则返回true，不存在下一页则不返回false
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
	 * 判断是否有上一页
	 * @return 存在上一页则返回true，不存在上一页则返回false
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
	 * 获得下一页
	 * @return 下一页
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
	 * 获得上一页
	 * @return 上一页
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
	 * Page的toString方法
	 */
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", list=" + list + ", pageSize="
				+ pageSize + ", totalItemNumber=" + totalItemNumber + "]";
	}
	
}
