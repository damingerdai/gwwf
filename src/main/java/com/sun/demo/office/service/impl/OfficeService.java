package com.sun.demo.office.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sun.demo.bean.OfficeStationery;
import com.sun.demo.office.dao.IOfficeDAO;
import com.sun.demo.office.dao.impl.OfficeDAO;
import com.sun.demo.office.service.IOfficeService;
/**
 * 办公用品所需的后台服务实现类
 * @author daming
 *
 */
public class OfficeService implements IOfficeService {
	private IOfficeDAO offDAO = new OfficeDAO();
	@Override
	public List<OfficeStationery> getOffice() {
		return offDAO.getOffice();
	}
	@Override
	public void updateOfficeUsage(String empid, List<OfficeStationery> list) {
		List<OfficeStationery> updateList = new ArrayList<>();
		List<OfficeStationery> insertList = new ArrayList<>();
		for(OfficeStationery off:list)
		{
			if(offDAO.getOfficeUsageInfo(empid, off))
			{
				updateList.add(off);
			}
			else
			{
				insertList.add(off);
			}
		}
		offDAO.updateOfficeUsageInfo(empid, updateList, insertList);
	}
	@Override
	public void updateOfficeStationery(List<OfficeStationery> list) {
		List<OfficeStationery> updateList = new ArrayList<>();
		List<OfficeStationery> insertList = new ArrayList<>();
		for(OfficeStationery off:list)
		{
			if(offDAO.checkOfficeStationery(off.getUname(), off.getUnit()))
			{
				updateList.add(off);
			}
			else
			{
				insertList.add(off);
			}
		}
		offDAO.updateOfficeStationery(updateList, insertList);
	}
	 
	 

}
