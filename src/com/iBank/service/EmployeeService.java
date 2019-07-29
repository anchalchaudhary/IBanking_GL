package com.iBank.service;

import java.util.List;

import com.iBank.pojo.EmployeePojo;

public interface EmployeeService {

	EmployeePojo saveEmployee(EmployeePojo employeePojo);
	
	List<EmployeePojo> listEmployee();
	
	EmployeePojo getEmployee(String empId);
}
