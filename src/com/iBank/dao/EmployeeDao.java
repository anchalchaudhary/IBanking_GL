package com.iBank.dao;

import java.util.List;

import com.iBank.pojo.EmployeePojo;

public interface EmployeeDao {
EmployeePojo saveEmployee(EmployeePojo employeePojo);
	
	List<EmployeePojo> listEmployee();
	
	EmployeePojo getEmployee(String empId);
}
