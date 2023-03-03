<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all contacts</title>
</head>
<body>
	
	<table>
		<thead>
			<tr>
				<th>S.no</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone no</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${contacts}" 
					   var="c" 
					   varStatus="index">
				<tr>
					<td>${index.count+1}</td>
					<td>${c.name}</td>
					<td>${c.email}</td>
					<td>${c.phoneNo}</td>
					<td>
						<a href="">Edit</a> |
						<a href="">Delete</a>
					</td>
				</tr>
			
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>