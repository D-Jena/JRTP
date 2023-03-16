<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Contact</title>
</head>
<body>

	<h2>Save contact</h2>
	<p>
		<font color='green'>${succMsg}</font>
	</p>
	<p>
		<font color='red'>${errMsg}</font>
	</p>
	<form:form  action="saveContact" 
			    modelAttribute="contact"  
				method="POST">
		<table>
			<tr>
				<form:hidden path="contactId"/>
				<td>Contact Name</td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>Contact Email</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><form:input path="phoneNo"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"/></td>
				<td><input type="reset" value="Reset"/></td>
			</tr>
		</table>
		
	</form:form>
	<a href="/PhoneBook_App/viewContacts">View all contacts</a>

</body>
</html>