package com.sun.demo.office.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.demo.bean.OfficeStationery;
import com.sun.demo.office.dao.IOfficeDAO;
import com.sun.demo.utils.JDBCTools;
/**
 * 办公用品相关的DAO实现类
 * @author daming
 *
 */
public class OfficeDAO implements IOfficeDAO {

	@Override
	public List<OfficeStationery> getOffice() {
		String sql = "select uname,unit,storeNumber from office_usage_form ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OfficeStationery> list = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<>();
			while(rs.next())
			{
				OfficeStationery office = new OfficeStationery();
				office.setUname(rs.getString(1));
				office.setUnit(rs.getString(2));
				office.setStoreNumber(rs.getInt(3));
				list.add(office);
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
	public void updateOfficeUsage(String empid, List<OfficeStationery> list) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCTools.getConnection();
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
	public boolean getOfficeUsageInfo(String empid,OfficeStationery off) {
		String sql = "select empid from office_usage_info where empid = ? and uname = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, empid);
			ps.setString(2, off.getUname());
			rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
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
		return false;
	}

	@Override
	public void updateOfficeUsageInfo(String empid,
			List<OfficeStationery> updateList, List<OfficeStationery> insertList) {
		Connection conn = null;
		PreparedStatement ips = null;
		PreparedStatement ups = null;
		PreparedStatement ps = null;
		String inSQL = "insert into  office_usage_info (empid,uname,number,unit) values (?,?,?,?)";
		String upSQL = "update office_usage_info set number = number + ? where empid = ? and uname = ?";
		String sql = "update office_usage_form set storenumber = storenumber - ? where uname = ?";
		try
		{
			conn = JDBCTools.getConnection();
			JDBCTools.beginTx(conn);
			ups = conn.prepareStatement(upSQL);
			ips = conn.prepareStatement(inSQL);
			ps = conn.prepareStatement(sql);
			for(OfficeStationery off :updateList)
			{
				ups.setInt(1, off.getStoreNumber());
				ups.setString(2, empid);
				ups.setString(3, off.getUname());
				ps.setInt(1, off.getStoreNumber());
				ps.setString(2, off.getUname());
				ups.addBatch();
				ps.addBatch();
			}
			for(OfficeStationery off:insertList)
			{
				ips.setString(1, empid);
				ips.setString(2, off.getUname());
				ips.setInt(3, off.getStoreNumber());
				ips.setString(4,off.getUnit());
				ps.setInt(1, off.getStoreNumber());
				ps.setString(2, off.getUname());
				ips.addBatch();
				ps.addBatch();
			}
			ups.executeBatch();
			ips.executeBatch();
			ps.executeBatch();
			JDBCTools.commit(conn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JDBCTools.rollback(conn);
		}
		finally
		{
			JDBCTools.release(ups);
			JDBCTools.release(ips);
			JDBCTools.release(ps, conn);
		}
		
	}

	@Override
	public boolean checkOfficeStationery(String uname, String unit) {
		String sql = "select uname from office_usage_form where uname = ? and unit = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean bool = false;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, unit);
			rs = ps.executeQuery();
			if(rs.next())
			{
				bool = true;
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
		return bool;
	}

	@Override
	public void updateOfficeStationery(List<OfficeStationery> updateList,
			List<OfficeStationery> insertList) {
		 String upSQL = "update office_usage_form set storenumber = storenumber + ? where uname = ? and unit = ?";
		 String inSQL = "insert into office_usage_form (uname,storenumber,unit) value(?,?,?)";
		 Connection conn = null;
		 PreparedStatement ups = null;
		 PreparedStatement ips = null;
		 try
		 {
			 conn = JDBCTools.getConnection();
			 JDBCTools.beginTx(conn);
			 ups = conn.prepareStatement(upSQL);
			 ips = conn.prepareStatement(inSQL);
			 for(OfficeStationery off:updateList)
			 {
				 ups.setInt(1, off.getStoreNumber());
				 ups.setString(2, off.getUname());
				 ups.setString(3, off.getUnit());
				 ups.addBatch();
			 }
			 for(OfficeStationery off:insertList)
			 {
				 ips.setString(1, off.getUname());
				 ips.setInt(2, off.getStoreNumber());
				 ips.setString(3, off.getUnit());
				 ips.addBatch();
			 }
			 ups.executeBatch();
			 ips.executeBatch();
			 JDBCTools.commit(conn);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 JDBCTools.rollback(conn);
		 }
		 finally
		 {
			 JDBCTools.release(ups);
			 JDBCTools.release(ips);
			 JDBCTools.release(conn);
		 }
	}

}
