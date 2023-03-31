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
	<h2>Log In as Admin</h2>

	<p style="font-size: 20px">
		<font color='red'>${msg}</font>
	</p>	
	<form:form method="post" action="adminLogIn" modelAttribute="admin">
		
		<p>Username: <form:input path="email" /></p>
		<p>Password: <form:input path="password" type="password" /></p>
		<p><form:button>Login</form:button></p>
	</form:form>

</body>
</html>