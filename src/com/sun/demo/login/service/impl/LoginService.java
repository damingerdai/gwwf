package com.sun.demo.login.service.impl;

import com.sun.demo.bean.User;
import com.sun.demo.domain.Employee;
import com.sun.demo.login.dao.ILoginDAO;
import com.sun.demo.login.dao.impl.LoginDAO;
import com.sun.demo.login.service.ILoginService;

public class LoginService implements ILoginService {
	/**
	 * µÇÂ¼Ä£¿éµÄDAO²Ù×÷
	 */
	private ILoginDAO eDAO = new LoginDAO();

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

}
