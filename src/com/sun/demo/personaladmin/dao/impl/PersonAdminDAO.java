package com.sun.demo.personaladmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.demo.bean.AttendanceRecord;
import com.sun.demo.domain.Department;
import com.sun.demo.domain.Employee;
import com.sun.demo.personaladmin.dao.IPersonAdminDAO;
import com.sun.demo.utils.JDBCTools;
/**
 * 封装人事管理的DAO实现类
 * @author daming
 *
 */
public class PersonAdminDAO implements IPersonAdminDAO {

	@Override
	public List<String> getEmpidByEmpidPart(String empidPart) {
		String sql = "select empid from employee where empid like ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> list = null;
		try {
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, empidPart + "%");
			rs = ps.executeQuery();
			list = new ArrayList<String>();
			while (rs.next()) {
				String empid = rs.getString(1);
				list.add(empid);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(rs, ps, conn);
		}

		return list;
	}

	@Override
	public Employee getEmpByEmpid(String empid) {
		String sql = "select empid, password,username,gender,birthday,major,edu,"
				+ "college,depId from employee where empid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		try {
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, empid);
			rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getString(1));
				emp.setPassword(rs.getString(2));
				emp.setUsername(rs.getString(3));
				emp.setGender(rs.getString(4));
				emp.setBirthday(rs.getString(5));
				emp.setMajor(rs.getString(6));
				emp.setEdu(rs.getString(7));
				emp.setCollege(rs.getString(8));
				emp.setDepId(rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(rs, ps, conn);
		}
		return emp;
	}

	 

	@Override
	public String searchDepId(String depid) {
		String sql = "select dname from department where depid = ? ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String dname = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, depid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				dname = rs.getString(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JDBCTools.release(ps, conn);
		}
		return dname;
	}

	@Override
	public List<Department> getDepartment() {
		String sql = "select depid,dname from department";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Department> list = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<>();
			while(rs.next())
			{
				Department dep = new Department();
				dep.setDepid(rs.getString(1));
				dep.setDname(rs.getString(2));
				list.add(dep);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.getConnection();
		}
		return list;
	}

	@Override
	public void updateDepartment(Department dep) {
		String sql = "update department set dname = ? where depid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dep.getDname());
			ps.setString(2,dep.getDepid());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.release(ps, conn);
		}
		
	}

	@Override
	public AttendanceRecord getAttendanceRecord( String empid,String cdate) {
		String sql = "select empid,cdate,ontime,offtime,ctype from "
				+ "checking_in_form where empid = ? and cdate = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AttendanceRecord ar = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,empid);
			ps.setString(2, cdate);
			rs = ps.executeQuery();
			if(rs.next())
			{
				ar = new AttendanceRecord();
				ar.setEmpid(rs.getString(1));
				ar.setCdate(rs.getString(2));
				ar.setOntime(rs.getString(3));
				ar.setOfftime(rs.getString(4));
				ar.setCtype(rs.getString(5));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.release(rs, ps, conn);
		}
		return ar;
	}

	@Override
	public List<AttendanceRecord> getAttendanceRecord() {
		String sql = "select empid,cdate,ontime,offtime,ctype from checking_in_form order by empid DESC";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AttendanceRecord> list = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<>();
			while(rs.next())
			{
				AttendanceRecord al = new AttendanceRecord();
				al.setEmpid(rs.getString(1));
				al.setCdate(rs.getString(2));
				al.setOntime(rs.getString(3));
				al.setOfftime(rs.getString(4));
				al.setCtype(rs.getString(5));
				list.add(al);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.release(rs, ps, conn);
		}
		return list;
	}

	@Override
	public List<AttendanceRecord> getAttendanceRecord(int pageNo,int pageSize) {
		String sql ="select empid,cdate,ontime,offtime,ctype from checking_in_form order by empid DESC limit ?,?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AttendanceRecord> list = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			list = new ArrayList<>();
			while(rs.next())
			{
				AttendanceRecord al = new AttendanceRecord();
				al.setEmpid(rs.getString(1));
				al.setCdate(rs.getString(2));
				al.setOntime(rs.getString(3));
				al.setOfftime(rs.getString(4));
				al.setCtype(rs.getString(5));
				list.add(al);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.release(rs, ps, conn);
		}
		return list;
	}

	@Override
	public long getAttendRecNumber() {
		String sql = "select count(cid) from checking_in_form";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		long in = 0 ;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
			{
				in = (long) rs.getObject(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return in;
	}

	@Override
	public void addEmployee(Employee emp) {
		String sql = "insert into employee (empid,username,edu,college,birthday,depid,major,gender,password) values (?,?,?,?,?,?,?,?,setMD5(?))";
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getEmpId());
			ps.setString(2, emp.getUsername());
			ps.setString(3, emp.getEdu());
			ps.setString(4, emp.getCollege());
			ps.setString(5, emp.getBirthday());
			ps.setString(6, emp.getDepId());
			ps.setString(7, emp.getMajor());
			ps.setString(8, emp.getGender());
			ps.setString(9, emp.getPassword());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.release(ps, conn);
		}
		
	}

	 
	@Override
	public void updateEmpoyee(Employee emp) {
		String sql = "update employee set username = ?,edu = ?,"
				+ "college = ? ,birthday = ?,depid = ?,major = ? ,"
				+ "gender = ?  where empid = ?";
		Connection  conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getUsername());
			ps.setString(2, emp.getEdu());
			ps.setString(3, emp.getCollege());
			ps.setString(4, emp.getBirthday());
			ps.setString(5, emp.getDepId());
			ps.setString(6, emp.getMajor());
			ps.setString(7, emp.getGender());
			ps.setString(8, emp.getEmpId());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.release(ps, conn);
		}
	}

	@Override
	public void addDepartment(Department dep) {
		String sql = "insert into department (depid,dname) values (?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dep.getDepid());
			ps.setString(2, dep.getDname());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.release(ps, null);
		}
	}

	@Override
	public void addAttendanceRecord(AttendanceRecord ar) {
		String sql = "insert into checking_in_form (empid,cdate,ontime,"
				+ "offtime,ctype) values (?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ar.getEmpid());
			ps.setString(2, ar.getCdate());
			ps.setString(3, ar.getOfftime());
			ps.setString(4, ar.getOfftime());
			ps.setString(5, ar.getCtype());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void updateAttendanceRecor(AttendanceRecord ar) {
		String sql = "update checking_in_form set ontime = ? ,offtime = ? ,"
				+ "ctype = ? where empid = ? and cdate = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ar.getOntime());
			ps.setString(2, ar.getOfftime());
			ps.setString(3, ar.getCtype());
			ps.setString(4, ar.getEmpid());
			ps.setString(5, ar.getEmpid());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.release(ps, conn);
		}
	}
	
	@Override
	public int getMaxIndex(String name) {
		String sql = "select nextval(?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i = 1;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next())
			{
				i = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.release(rs, ps, conn);
		}
		return i;
	}

	@Override
	public List<Employee> getEmployeeByOffice(String depid) {
		String sql = "select empid,username,gender,birthday,major,edu,college,depid from employee where depid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> list = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, depid);
			rs = ps.executeQuery();
			list = new ArrayList<>();
			while(rs.next())
			{
				Employee employee = new Employee();
				employee.setEmpId(rs.getString(1));
				employee.setUsername(rs.getString(2));
				employee.setGender(rs.getString(3));
				employee.setBirthday(rs.getString(4));
				employee.setMajor(rs.getString(5));
				employee.setEdu(rs.getString(6));
				employee.setCollege(rs.getString(7));
				employee.setDepId(rs.getString(8));
				list.add(employee);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.release(rs, ps, conn);
		}
		return list;
	}

	@Override
	public String getDname(String depid) {
		String sql = "select dname from department where depid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String dname = null;
		try
		{
			conn =JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, depid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				dname = rs.getString(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.release(rs, ps, conn);
		}
		return dname;
	}
	

}
