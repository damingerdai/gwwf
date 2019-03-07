package com.sun.demo.vehiclemanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.demo.bean.CarUserInfo;
import com.sun.demo.bean.User;
import com.sun.demo.domain.Car;
import com.sun.demo.domain.Employee;
import com.sun.demo.domain.Park;
import com.sun.demo.utils.JDBCTools;
import com.sun.demo.vehiclemanage.dao.IVehicleManageDAO;
/**
 * 车辆管理模块DAO实现类
 * @author daming
 *
 */
public class VehicleManageDAO implements IVehicleManageDAO {

	@Override
	public List<Park> getParkingInfo() {
		String sql = "select pid,carid,instrucation from park";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Park> list = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<>();
			while(rs.next())
			{
				Park park = new Park();
				park.setPid(rs.getString(1));
				park.setCarid(rs.getString(2));
				park.setInstrucation(rs.getString(3));
				list.add(park);
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
	public Park getPark(String pid) {
		String sql = "select pid,carid,instrucation from park where pid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Park park = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				park = new Park();
				park.setPid(rs.getString(1));
				park.setCarid(rs.getString(2));
				park.setInstrucation(rs.getString(3));
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
		return park;
	}

	@Override
	public Car getCar(String carid) {
		String sql = "select carid,cartype,dirverid,usagetype,buytime,capacity,capunit from car where carid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Car car = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, carid);
			rs = ps.executeQuery();
			if(rs.next())
			{
				car = new Car();
				car.setCarId(rs.getString(1));
				car.setCarType(rs.getString(2));
				car.setDirverId(rs.getString(3));
				car.setUsageType(rs.getString(4));
				car.setBuyTime(rs.getString(5));
				car.setCapacity(rs.getInt(6));
				car.setCapunit(rs.getString(7));
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
		return car;
	}

	@Override
	public boolean hasPark(String carid) {
		String sql = "select pid,carid,instrucation from park where carid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean bool = false;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, carid);
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
	public void insertPark(Park park) {
		String sql = "insert into  park (pid,carid,instrucation) values(?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, park.getPid());
			ps.setString(2,park.getCarid());
			ps.setString(3, park.getInstrucation());
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
	public List<Car> getCarInfo() {
		String sql = "select carid,cartype,dirverid,usagetype,buytime,capacity,capunit from car";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Car> list = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<>();
			while(rs.next())
			{
				Car car = new Car();
				car.setCarId(rs.getString(1));
				car.setCarType(rs.getString(2));
				car.setDirverId(rs.getString(3));
				car.setUsageType(rs.getString(4));
				car.setBuyTime(rs.getString(5));
				car.setCapacity(rs.getInt(6));
				car.setCapunit(rs.getString(7));
				list.add(car);
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
	public List<User> getEmployee() {
		String sql = "select empid,username from employee";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<>();
			while(rs.next())
			{
				User user = new User();
				user.setEmpId(rs.getString(1));
				user.setUsername(rs.getString(2));
				list.add(user);
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
	public boolean hasCar(String empid) {
		String sql = "select carid from car where dirverid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean bool = false;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, empid);
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
	public void addCar(Car car) {
		String sql = "insert into car (carid,cartype,dirverid,usagetype,buytime,capacity,capunit) values(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, car.getCarId());
			ps.setString(2, car.getCarType());
			ps.setString(3, car.getDirverId());
			ps.setString(4, car.getUsageType());
			ps.setString(5, car.getBuyTime());
			ps.setInt(6, car.getCapacity());
			ps.setString(7, car.getCapunit());
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
	public Employee searchEmployee(String empId) {
		 
		 String sql = "select empid,username from employee where empid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		Employee employee = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, empId);
			rs = ps.executeQuery();
			if(rs.next())
			{
				employee = new Employee();
				employee.setEmpId(rs.getString(1));
				employee.setUsername(rs.getString(2));
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
		return employee;
		 
		 
	}

	@Override
	public void insertCarUserInfo(CarUserInfo caruserinfo) {
		String sql = "insert into car_usage_form (carid,usagetime_begin,usagetime_end,userid,remark) values (?,?,?,?,?) ";
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, caruserinfo.getCarId());
			ps.setString(2, caruserinfo.getUsageTime_begin());
			ps.setString(3, caruserinfo.getUsageTime_end());
			ps.setString(4, caruserinfo.getUserId());
			ps.setString(5, caruserinfo.getUsage());
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
	public long getCarUserInfoNumber() {
		String sql = "select count(cufid) from car_usage_form ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		long in = 0;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
			{
				in = rs.getLong(1);
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
		return in;
	}

	@Override
	public List<CarUserInfo> getCarUserInfo(int pageNo, int pageSize) {
		String sql = "select carid,usagetime_begin,usagetime_end,userid,remark from car_usage_form limit ?,?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CarUserInfo> list = null;
		try
		{
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			list = new ArrayList<CarUserInfo>();
			while(rs.next())
			{
				CarUserInfo cui = new CarUserInfo();
				cui.setCarId(rs.getString(1));
				cui.setUsageTime_begin(rs.getString(2));
				cui.setUsageTime_end(rs.getString(3));
				cui.setUserId(rs.getString(4));
				cui.setUsage(rs.getString(5));
				list.add(cui);
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
	public void updateCarInfo(Car car) {
		 String sql = "update car set dirverid = ?,usagetype = ? where carid = ?";
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try
		 {
			 conn = JDBCTools.getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, car.getDirverId());
			 ps.setString(2, car.getUsageType());
			 ps.setString(3, car.getCarId());
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
	public void updateParking(Park park) {
		 String sql = "update park set carid = ?,instrucation = ? where pid = ?";
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try
		 {
			 conn = JDBCTools.getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, park.getCarid());
			 ps.setString(2, park.getInstrucation());
			 ps.setString(3, park.getPid());
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

	
}
