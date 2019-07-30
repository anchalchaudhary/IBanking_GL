<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="empReg.js"></script>
</head>
<body>

	<h2>Employee Edit Form</h2>
	<form name="empregistration"
		action="EmployeeController?act=updateEmployee"
		onsubmit="return validateEmpRegForm()" method="post">

		<table>

			<tr>
				<td>Employee Id</td>
				<td><input type="text" readonly name="empId"
					value="<c:out value="${empPojo.getEmpId()}" />"></td>
			</tr>


			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname"
					value="<c:out value="${empPojo.getFname()}" />"></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname"
					value="<c:out value="${empPojo.getLname()}" />"></td>
			</tr>

			<tr>
				<td>Age</td>
				<td><input type="number" name="age"
					value="<c:out value="${empPojo.getAge()}" />"></td>
			</tr>

			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="Male"
					<c:if test="${empPojo.getGender().trim()=='Male'}">checked</c:if>>
					Male <br> <input type="radio" name="gender" value="Female"
					<c:if test="${empPojo.getGender().trim()=='Female'}">checked</c:if>>
					Female <br> <input type="radio" name="gender" value="Other"
					<c:if test="${empPojo.getGender().trim()=='Other'}">checked</c:if>>Other
				</td>
			</tr>
		</table>

		<input type="submit" value="Update Employee">

	</form>

</body>
</html>