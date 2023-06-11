<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Employee Log In page.</h3>	<p><a href="adminLogIn">Goto Admin Log In page</a></p>
	
	<p style="font-size: 20px">
		<font color='red'>${failureMsg}</font>
	</p>	
	<form:form method="post" action="employeeLogIn" modelAttribute="emp">
		
		<p>Email: <form:input path="empEmail" /></p>
		<p>Password: <form:input path="empPassword" type="password" /></p>
		<p><form:button>Login</form:button></p>
	</form:form>
	
	<p><a href="home">Home</a></p>

</body>
</html>