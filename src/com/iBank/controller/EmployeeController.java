package com.iBank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iBank.pojo.EmployeePojo;
import com.iBank.service.EmployeeService;
import com.iBank.service.EmployeeServiceImpl;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	EmployeeService employeeService = new EmployeeServiceImpl();
	List<EmployeePojo> empList = new ArrayList<EmployeePojo>();

    public EmployeeController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionClicked = request.getParameter("act");
		String eId = request.getParameter("empId");
		int empId = -1;
		
		if(eId!=null) {
			empId = Integer.parseInt(eId);
		}
		EmployeeService employeeService = new EmployeeServiceImpl();

		if (actionClicked != null) {
			if (actionClicked.equals("createEmployee")) {
				RequestDispatcher rd = request.getRequestDispatcher("employeeRegistration.html");
				rd.forward(request, response);

			} else if (actionClicked.equals("editEmployee")) {
				EmployeePojo employeepojo = employeeService.getEmployee(empId);
				request.setAttribute("empPojo", employeepojo);
				RequestDispatcher rd = request.getRequestDispatcher("editEmployee.jsp");
				rd.forward(request, response);

			} else if (actionClicked.equals("deleteEmployee")) {
				employeeService.deleteEmployee(empId);
				getEmployeeList(request, response);
			} else {
				System.out.println("Action not found");
			}			
		}
	}

	private void getEmployeeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		empList = employeeService.listEmployee();
		request.setAttribute("totalEmpCount", empList.size());

		request.setAttribute("empListPojo", empList);
		RequestDispatcher rd = request.getRequestDispatcher("emp.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pr = response.getWriter();
		pr.append("form submitted");
		String fname = request.getParameter("fname").trim();
		String lname = request.getParameter("lname").trim();
		int age = Integer.parseInt(request.getParameter("age").trim());
		String gender = request.getParameter("gender");
		String eId = request.getParameter("empId");
		int empId = -1;
		if(eId!=null)
			empId = Integer.parseInt(eId);

		EmployeePojo employeePojo = new EmployeePojo();
		
		String actionclicked = request.getParameter("act");
		if (actionclicked.equals("updateEmployee")) {
			employeePojo.setFname(fname);
			employeePojo.setLname(lname);
			employeePojo.setAge(age);
			employeePojo.setGender(gender);
			employeePojo.setEmpId(empId);

			employeeService.updateEmployee(employeePojo);
			getEmployeeList(request, response);
		} else if (actionclicked.equals("saveEmployee")) {
			employeePojo.setFname(fname);
			employeePojo.setLname(lname);
			employeePojo.setAge(age);
			employeePojo.setGender(gender);

			employeePojo = employeeService.saveEmployee(employeePojo);
			getEmployeeList(request, response);
		}
	}
}
