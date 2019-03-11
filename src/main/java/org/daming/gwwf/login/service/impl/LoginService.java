package org.daming.gwwf.login.service.impl;

import com.google.inject.Inject;
import org.daming.gwwf.bean.User;
import org.daming.gwwf.domain.Employee;
import org.daming.gwwf.login.dao.ILoginDAO;
import org.daming.gwwf.login.dao.impl.LoginDAO;
import org.daming.gwwf.login.service.ILoginService;

public class LoginService implements ILoginService {
	/**
	 * 登录模块的DAO操作
	 */
	private ILoginDAO eDAO;

	@Override
	public String checkUser(User user) {
		  
		if(searchEmployee(user.getEmpId())== null)
		{
			return "empid_error";
		}
		else
		{
			if(eDAO.findUser(user) == null)
			{
				return "password_error";
			}
		}
		return "success";
	}

	@Override
	public Employee searchEmployee(String empId) {
		 
		return eDAO.searcheEmployee(empId);
	}

	@Override
	public String searchUsername(String empId) {
		 
		return eDAO.searchUsername(empId);
	}

	@Override
	public String searchDepId(String empid) {
		 
		return eDAO.searchDepId(empid);
	}

	@Inject
	public LoginService(ILoginDAO eDAO) {
		super();
		this.eDAO = eDAO;
	}

}
