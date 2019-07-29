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
</head>
<body>
	<h3>
		<c:out value="${'Employee Details' }" />
	</h3>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Gender</th>
		</tr>
		<c:forEach items="${empListpojo }" var="employeePojo">
			<tr>
				<td><c:out value="${employeePojo.getFname()}" /></td>
				<td><c:out value="${employeePojo.getLname()}" /></td>
				<td><c:out value="${employeePojo.getAge()}" /></td>
				<td><c:out value="${employeePojo.getGender()}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>