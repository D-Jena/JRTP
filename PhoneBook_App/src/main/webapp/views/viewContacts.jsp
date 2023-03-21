<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all contacts</title>
<link 
	href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.13.3/js/jquery.dataTables.min.js"></script>
<script>
	$(document).ready(function () {
	    $('#contactTable').DataTable({
	        pagingType: 'full_numbers',
	    });
	});
</script>
</head>
<body>
	<h1>View all contacts here.</h1>
	<p style="font-size: 40px">
		<font color='green'>${msg}</font>
	</p>
	<a href="addContact">+Add new contact</a>
	<table border="1" id="contactTable">
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
					<td>${index.count}</td>
					<td>${c.name}</td>
					<td>${c.email}</td>
					<td>${c.phone}</td>
					<td>
						<a href="editContact?cid=${c.contactId}">Edit</a> |
						<a href="deleteContact?cid=${c.contactId}" 
						onclick="return confirm('Are you sure, you want to delete?')">Delete</a>
					</td>
				</tr>
			
			</c:forEach>
		</tbody>
	</table>
		
</body>
</html>