<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#">RBS Bank</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="#">Employees<span
						class="sr-only">(current)</span></a></li>

				<li class="nav-item"><a class="nav-link"
					href="EmployeeController?act=createEmployee">Create Employee</a></li>
			</ul>
			<ul class="navbar-nav my-2 my-lg-0">
				<li class="nav-item"><a class="nav-link" href="loginController">
						Register New User</a></li>
				<li class="nav-item mr-sm-2"><a class="nav-link"
					href="/loginController"> Login </a></li>
				<li class="nav-item mr-sm-2"><a class="nav-link"
					href="/logoutController">LogOut</a></li>
			</ul>
		</div>
	</nav>
	<h3>
		<c:out value="${'Employee Details' }" />
	</h3>
	<table>
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Gender</th>
		</tr>
		<c:forEach items="${empListPojo}" var="employeePojo">
			<tr>
				<td><c:out value="${employeePojo.getEmpId()}" /></td>
				<td><c:out value="${employeePojo.getFname()}" /></td>
				<td><c:out value="${employeePojo.getLname()}" /></td>
				<td><c:out value="${employeePojo.getAge()}" /></td>
				<td><c:out value="${employeePojo.getGender()}" /></td>
				<td><a
					href="EmployeeController?empId=<c:out value = '${employeePojo.getEmpId()}'/>&act=editEmployee">Edit</a></td>
				<td><a
					href="EmployeeController?empId=<c:out value = '${employeePojo.getEmpId()}'/>&act=deleteEmployee">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>