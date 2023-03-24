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

    <!-- Assuming there is a model attribute named "userAccount" of type UserAccount -->
    <form:form action="register" 
    		   method="post" 
    		   modelAttribute="userAccount">
        <table>
            <tr>
            	<td>First Name:</td>
            	<td><form:input path="firstName" required/></td>
            </tr>
            <tr>
            	<td>Last Name:</td>
            	<td><form:input path="lastName" required/></td>
            </tr>
            <tr>
            	<td>Date of Birth:</td>
            	<td><form:input path="DOB" type="date" required/></td>
            </tr>
            <tr>
            	<td>Gender:</td>
            	<td><form:radiobuttons path="gender" items="${'M','F','O'}" /></td>
            </tr>
            <tr>
            	<td>Email:</td>
            	<td><form:input path="userEmail" type="email" required/></td>
            </tr>
            <tr>
            	<td>Mobile:</td>
            	<td><form:input path="userPhone"/>
            </tr>
            <tr>
            	<th>Country:</th>
            	<td><form:select path="countryId">
            			<form:option value="">-Select-</form:option>
            			<form:options items="${countries}"/>
            		</form:select>
            	</td>
            </tr>

        </table>
    </form:form>


</body>
</html>