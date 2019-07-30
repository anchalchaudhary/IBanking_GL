package com.iBank.service;

import java.util.List;

import com.iBank.dao.EmployeeDao;
import com.iBank.dao.EmployeeDaoImpl;
import com.iBank.pojo.EmployeePojo;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDao employeeDao = new EmployeeDaoImpl();
	@Override
	public EmployeePojo saveEmployee(EmployeePojo employeePojo) {

		//send otp
		int empID = employeeDao.saveEmployee(employeePojo);

		employeePojo.setEmpId(empID);
		//send sms
		//send email
		//generate employee ID
		return employeePojo;
	}

	@Override
	public List<EmployeePojo> listEmployee() {

		List<EmployeePojo> empList = employeeDao.listEmployee();
		return empList;
	}

	@Override
	public EmployeePojo getEmployee(int empId) {
		
		EmployeePojo employeePojo = employeeDao.getEmployee(empId);
		return employeePojo;
	}

	@Override
	public void updateEmployee(EmployeePojo employeePojo) {

		employeeDao.updateEmployee(employeePojo);
	}

	@Override
	public void deleteEmployee(int empId) {
		
		employeeDao.deleteEmployee(empId);
	}

}
