package org.daming.gwwf.login.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.daming.gwwf.bean.User;
import org.daming.gwwf.domain.Employee;
import org.daming.gwwf.login.dao.ILoginDAO;
import org.daming.gwwf.utils.JDBCTools;

/**
 * IEmployeeDAO的实现类
 * @author daming
 *
 */
public class LoginDAO implements ILoginDAO {

	@Override
	public Employee findUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		try {
			String sql = "select empid,username,password from employee where empid = ? and password = MD5(?)";
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmpId());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getString(1));
				emp.setUsername(rs.getString(2));
				emp.setPassword(rs.getString(3));

			}

		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.release(rs, ps, conn);
		}
		return emp;
	}

	@Override
	public Employee searcheEmployee(String empId) {
		String sql = "select empid,username,password,gender,birthday,major,edu,college,depid from employee where empid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, empId);
			rs = ps.executeQuery();
			if(rs.next())
			{
				emp = new Employee();
				emp.setEmpId(rs.getString(1));
				emp.setUsername(rs.getString(2));
				emp.setPassword(rs.getString(3));
				emp.setGender(rs.getString(4));
				emp.setBirthday(rs.getString(5));
				emp.setMajor(rs.getString(6));
				emp.setEdu(rs.getString(7));
				emp.setCollege(rs.getString(8));
				emp.setDepId(rs.getString(9));
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
		return emp;
	}

	@Override
	public String searchUsername(String empId) {
		String sql = "select username from employee where empid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String username = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,empId);
			rs = ps.executeQuery();
			if(rs.next())
			{
				username = rs.getString(1);
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
		return username;
	}

	@Override
	public String searchDepId(String empid) {
		String sql = "select depid from employee where empid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String depid = "HR";
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, empid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				depid = rs.getString(1);
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
		return depid;
	}

}
