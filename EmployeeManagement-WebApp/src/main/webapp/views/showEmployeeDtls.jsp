<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee details</title>
</head>
<body>

	<h4>Employee details :</h4>
	
	<p>Name: ${emp.empName}</p>
	<p>Email: ${emp.empEmail}</p>
	<p>Password: ${emp.empPassword}</p>
	<p>Mobile No: ${emp.empMobile}</p>
	<p>Designation: ${emp.salary.designation}</p>
	<p>Salary: ${emp.salary.basicSalary+emp.salary.bonusSalary}</p>	
	<p>Joining Date: ${emp.joinDate}</p>
	<p>Registration ID: ${emp.empRegId}</p>
	<p>State: ${emp.address.stateName}</p>
	<p>District: ${emp.address.distName}</p>
	
	<p><a href="home">Home</a></p>

</body>
</html>