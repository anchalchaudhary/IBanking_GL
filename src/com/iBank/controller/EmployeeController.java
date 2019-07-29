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

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("\nWelcome to GlobalLogic");
		response.getWriter().append("<html>Hi</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pr = response.getWriter();
		pr.append("form submitted");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");

		List<EmployeePojo> empList = new ArrayList<EmployeePojo>();

		EmployeePojo employeePojo = new EmployeePojo();
		employeePojo.setFname(fname);
		employeePojo.setLname(lname);
		employeePojo.setAge(age);
		employeePojo.setGender(gender);
		empList.add(employeePojo);
		
		EmployeePojo employeePojo1 = new EmployeePojo();		
		employeePojo1.setFname("Anchal");
		employeePojo1.setLname("Chaudhary");
		employeePojo1.setAge(22);
		employeePojo1.setGender("Female");
		empList.add(employeePojo1);
		
		EmployeePojo employeePojo2 = new EmployeePojo();
		employeePojo2.setFname("Apoorv");
		employeePojo2.setLname("Gupta");
		employeePojo2.setAge(22);
		employeePojo2.setGender("Female");
		empList.add(employeePojo2);
		
		EmployeePojo employeePojo3 = new EmployeePojo();
		employeePojo3.setFname("Divyam");
		employeePojo3.setLname("Singh");
		employeePojo3.setAge(22);
		employeePojo3.setGender("Male");
		empList.add(employeePojo3);
		
		request.setAttribute("empListpojo", empList);
		request.setAttribute("employeePojo", employeePojo);
		RequestDispatcher rd = request.getRequestDispatcher("emp.jsp");
		rd.forward(request, response);
	}
}
