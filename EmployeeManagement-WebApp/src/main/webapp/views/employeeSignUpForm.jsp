<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<script src="./js/app.js" defer></script>
</head>

<body>
	<h4>Employee Registration:</h4>
	
	<form:form action="employeeSignUp" 
    		   method="post" 
    		   modelAttribute="emp"
    		   onsubmit="return validatePassword()">
        <table>
            <tr>
            	<td>Name :</td>
            	<td><form:input path="empName" /></td>
            </tr>
            
            <tr>
            	<td>Email :</td>
            	<td><form:input path="empEmail" type="email" /></td>
            </tr>
            
            <tr>
            	<td>Mobile No :</td>
            	<td><form:input path="empMobile"/>
            </tr>
            
            <tr>
				<td>Designation :</td>
				<td><form:select path="salaryId">
						<form:option value="">-Select-</form:option> 
						<form:options items="${designations}"/>
					</form:select></td>
			</tr>
            
            <tr>
            	<td>Joining Date:</td>
            	<td><form:input path="joinDate" type="date" pattern="yyyy-MM-dd"/></td>
            </tr>
            
            
            <tr>
				<td>State:</td>
				<td><form:select path="stateId">
						<form:option value="">-Select-</form:option> 
						<form:options items="${statesMap}"/>
					</form:select></td>
			</tr>
			
			<tr>
				<td>District:</td>
				<td><form:select path="distId">
						<form:option value="">-Select-</form:option> 
					</form:select></td>
			</tr>
            
            <tr>
            	<td>Create Password:</td>
            	<td><form:password path="empPassword" id="passwordOne" />
            </tr>
            
            <tr>
            	<td>Confirm Password:</td>
            	<td><form:password path="" id="passwordTwo" />
            </tr>
			
			<tr>
				<td><input type="submit" value="Save"/></td>
				<td><input type="reset" value="Reset"/></td>
			</tr>
        </table>
    </form:form>
    
    <p><a href="home">Home</a></p>
    
</body>
</html>