package org.daming.gwwf.office.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.daming.gwwf.bean.OfficeStationery;
import org.daming.gwwf.office.dao.IOfficeDAO;
import org.daming.gwwf.office.dao.impl.OfficeDAO;
import org.daming.gwwf.office.service.IOfficeService;

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
