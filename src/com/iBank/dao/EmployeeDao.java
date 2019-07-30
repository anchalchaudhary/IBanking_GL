package com.iBank.dao;

import java.util.List;

import com.iBank.pojo.EmployeePojo;

public interface EmployeeDao {
int saveEmployee(EmployeePojo employeePojo);
	
	List<EmployeePojo> listEmployee();
	
	EmployeePojo getEmployee(int empId);

	void updateEmployee(EmployeePojo employeePojo);

	void deleteEmployee(int empId);
}
