package org.daming.gwwf.personaladmin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.daming.gwwf.bean.AttendanceRecord;
import org.daming.gwwf.domain.Department;
import org.daming.gwwf.domain.Employee;
import org.daming.gwwf.personaladmin.dao.IPersonAdminDAO;
import org.daming.gwwf.personaladmin.dao.impl.PersonAdminDAO;
import org.daming.gwwf.personaladmin.service.IPersonAdminService;
import org.daming.gwwf.web.Page;

/**
 * 员工人事管理的实现，用于封装增加和修改员工信息等操作
 * @author daming
 * 
 */
public class PersonAdminService implements IPersonAdminService {
	private IPersonAdminDAO pDAO = new PersonAdminDAO();

	@Override
	public List<String> getEmpidByEmpidPart(String empidPart) {
		return pDAO.getEmpidByEmpidPart(empidPart);
	}

	@Override
	public Employee getEmpById(String empid) {
		
		return pDAO.getEmpByEmpid(empid);
	}

	@Override
	public Employee getEmp(String empid, String username, String password,
			String depid, String edu, String college, String birthday,
			String major, String gender) {
		Employee emp = new Employee();
		emp.setEmpId(empid);
		emp.setUsername(username);
		emp.setPassword(password);
		emp.setEdu(edu);
		emp.setCollege(college);
		emp.setBirthday(birthday);
		emp.setDepId(depid);
		emp.setMajor(major);
		emp.setGender(gender);
		return emp;
	}

	@Override
	public void addEmployee(Employee emp) {
		pDAO.addEmployee(emp);
	}


	@Override
	public String setMessage(List<String> list) {
		String str = null;
		if (list != null && list.size() > 0) {
			StringBuffer buffer = new StringBuffer();
			int num = list.size();
			if (num > 3) {
				num = 3;
			}
			for (int i = 0; i < num; i++) {
				buffer.append(list.get(i) + ":");
			}
			str = buffer.toString();
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	@Override
	public String setMessage(Employee emp) {
		String str = "";
		if (emp != null) {
			str = emp.getEmpId() + ":" + emp.getUsername() + ":"
					+ emp.getGender() + ":" + emp.getBirthday() + ":"
					+ emp.getDepId() + ":" + emp.getCollege() + ":"
					+ emp.getMajor() + ":" + emp.getEdu();
		}
		return str;
	}

	@Override
	public void updateEmployee(Employee emp) {
		 	pDAO.updateEmpoyee(emp);
	}

	@Override
	public String searchDepId(String depid) {
		
		return pDAO.searchDepId(depid);
	}

	@Override
	public void addDepartment(Department dep) {
		pDAO.addDepartment(dep);
	}

	@Override
	public List<Department> getDepartment() {
		
		return pDAO.getDepartment();
	}

	@Override
	public void updateDepartment(Department dep) {
		pDAO.updateDepartment(dep);

	}

	@Override
	public void addAttendanceRecord(AttendanceRecord ar) {
		pDAO.addAttendanceRecord(ar);
	}

	@Override
	public boolean searchAttendanceRecord(AttendanceRecord ar) {
		AttendanceRecord attr = pDAO.getAttendanceRecord(ar.getEmpid(), ar.getCdate());
		if (attr == null) {
			return false;
		}
		return true;
	}

	@Override
	public void updateAttendanceRecord(AttendanceRecord ar) {
		 
		pDAO.updateAttendanceRecor(ar);
	}

	@Override
	public List<AttendanceRecord> getAttendanceRecord() {
		List<AttendanceRecord> list = pDAO.getAttendanceRecord();
		List<AttendanceRecord> ars = new ArrayList<>();
		for(AttendanceRecord ar:list)
		{
			String ontime = ar.getOntime().substring(0,2);
			String offtime = ar.getOfftime().substring(0,2);
			String remark = getRemarkByAttendRec(ontime, offtime);
			ar.setRemark(remark);
			ars.add(ar);
		}
		return ars;
	}

	/**
	 * 根据上下班的时间判断迟到或者早退
	 * @param ontime
	 * @param offtime
	 */
	private String getRemarkByAttendRec(String ontime, String offtime) {
		int on = 9;
		int off = 17;
		try
		{
			on = Integer.parseInt(ontime);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			off = Integer.parseInt(offtime);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String remark = "";
		if(on > 9)
		{
			remark += "迟到,";
		}
		if(off < 17)
		{
			remark += "早退,";
		}
		if(remark.equals(""))
		{
			remark = "正常";
		}
		else
		{
			remark = remark.substring(0,remark.length()-1);
		}
		return remark;
	}

	@Override
	public Page<AttendanceRecord> getPage(int pageNo) {
		Page<AttendanceRecord> page = new Page<>(pageNo);
		long totalItemNumber = pDAO.getAttendRecNumber();
		if(totalItemNumber > 0)
		{
			page.setTotalItemNumber(totalItemNumber);
			//验证数据的合法性
			pageNo = page.getPageNo();
			List<AttendanceRecord> list = pDAO.getAttendanceRecord( pageNo, 5);
			List<AttendanceRecord> ars = new ArrayList<>();
			for(AttendanceRecord ar:list)
			{
				String ontime = ar.getOntime().substring(0,2);
				String offtime = ar.getOfftime().substring(0,2);
				String remark = getRemarkByAttendRec(ontime, offtime);
				ar.setRemark(remark);
				ars.add(ar);
			}
			page.setList(ars);
		}
		return page;
	}

	@Override
	public String getDefaultEmpId() {
		StringBuffer buff = new StringBuffer();
		buff.append("HR");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date(); 
        buff.append(sdf.format(date)); 
        int num = pDAO.getMaxIndex("empid");
        buff.append(getStringFormInteger(num));
		return buff.toString();
	}

	private String getStringFormInteger(int num) {
		if(num < 0)
        {
        	num = 0;
        }
        String str = null;
        if(num < 10)
        {
        	str = "000" + num;
        }
        else if(num < 100)
        {
        	str = "00" + num;
        }
        else if(num < 1000)
        {
        	str = "0" + num;
        }
        else if(num < 10000)
        {
        	str = "" + num;
        }
        else 
        {
        	str = "0000";
        }
        return str;
	}

	@Override
	public List<Employee> getEmployeeByOffice(String depid) {
		return pDAO.getEmployeeByOffice(depid);
	}

	@Override
	public String getDname(String depid) {
		String dname = pDAO.getDname(depid);
		if("".equals(dname))
		{
			return "行政部门";
		}
		return dname;
	}

 
}
