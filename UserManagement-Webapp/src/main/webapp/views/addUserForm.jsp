<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h1>User Registration</h1>
		
    <form:form action="submitForm" 
    		   method="post" 
    		   modelAttribute="userAccount">
        <table>
            <tr>
            	<td>First Name:</td>
            	<td><form:input path="firstName" required="true"/></td>
            </tr>
            <tr>
            	<td>Last Name:</td>
            	<td><form:input path="lastName" required="true"/></td>
            </tr>
            <tr>
            	<td>Date of Birth:</td>
            	<td><form:input path="DOB" type="date" required="true"/></td>
            </tr>
            <tr>
            	<td>Gender:</td>
            	<td>
	            	<form:radiobutton path="gender" value="M" label="Male"/>
				    <form:radiobutton path="gender" value="F" label="Female"/>
				    <form:radiobutton path="gender" value="O" label="Other"/>
        		</td>   
            </tr>
            <tr>
            	<td>Email:</td>
            	<td><form:input path="userEmail" type="email" required="true"/></td>
            </tr>
            <tr>
            	<td>Mobile:</td>
            	<td><form:input path="userPhone"/>
            </tr>
            <tr>
            	<th>Country:</th>
            	<td>
            		<form:select path="countryId">
            			<form:option value="">-Select-</form:option>
            			<form:options items="${countries}"/>
            		</form:select>
            	</td>
            </tr>
			<tr>
				<td><input type="submit" value="Save"/></td>
				<td><input type="reset" value="Reset"/></td>
			</tr>
        </table>
    </form:form>


</body>
</html>