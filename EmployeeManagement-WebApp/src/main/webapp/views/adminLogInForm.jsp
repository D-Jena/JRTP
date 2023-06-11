<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin LogIn page</title>
</head>
<body>
	<h2>Log In as Admin</h2>	<p><a href="employeeLogIn">Goto Employee Log In page</a></p>

	<p style="font-size: 20px">
		<font color='red'>${msg}</font>
	</p>	
	<form:form method="post" action="adminLogIn" modelAttribute="admin">
		
		<p>User Name: <form:input path="userName" /></p>
		<p>Password: <form:input path="password" type="password" /></p>
		<p><form:button>Login</form:button></p>
	</form:form>

	<p><a href="home">Home</a></p>
</body>
</html>