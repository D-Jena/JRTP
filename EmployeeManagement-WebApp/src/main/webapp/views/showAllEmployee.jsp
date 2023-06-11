<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all contacts</title>
<link
	href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.13.3/js/jquery.dataTables.min.js"></script>
<script>
	$(document).ready(function() {
		$('#employee').DataTable({
			pagingType : 'full_numbers',
		});
	});
</script>
</head>
<body>
	<h1>View all contacts here.</h1>
	<p style="font-size: 40px">
		<font color='green'>${msg}</font>
	</p>
	
	<table border="1" id="employee">
		<thead>
			<tr>
				<th>S No</th>
				<th>RegId</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone no</th>
				<th>Designation</th>
				<th>Salary</th>
				<th>State</th>
				<th>Dist</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employeeList}" 
						var="e" 
						varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${e.empRegId}</td>
					<td>${e.empName}</td>
					<td>${e.empEmail}</td>
					<td>${e.empMobile}</td>
					<td>${e.salary.designation}</td>
					<td>${emp.salary.basicSalary+emp.salary.bonusSalary}</td>
					<td>${e.address.stateName}</td>
					<td>${e.address.distName}</td>
					<td><a href="editEmployee?empId=${e.empId}">Edit</a> | <a
						href="deleteEmployee?empId=${e.empId}"
						onclick="return confirm('Are you sure, you want to delete?')">Delete</a>
					</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
<p><a href="home">Home</a></p>
</body>
</html>