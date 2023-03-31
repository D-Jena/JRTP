<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<script src="./js/app.js"></script>


<meta charset="ISO-8859-1">
<title>Employee Registration</title>
</head>

<body>

	<h4>Employee Registration:</h4>
	
	<form:form action="employeeSignUp" 
    		   method="post" 
    		   modelAttribute="emp"
    		   onsubmit="return validateForm()">
        <table>
            <tr>
            	<td>Name :</td>
            	<td><form:input path="empName" required="true"/></td>
            </tr>
            
            <tr>
            	<td>Email :</td>
            	<td><form:input path="empEmail" type="email" required="true"/></td>
            </tr>
            
            <tr>
            	<td>Mobile No :</td>
            	<td><form:input path="empMobile"/>
            </tr>
            
            <tr>
				<td>Designation :</td>
				<td><form:select path="stateId">
						<form:option value="">-Select-</form:option> 
						<form:options items="${statesMap}"/>
					</form:select></td>
			</tr>
            
            <tr>
            	<td>Joining Date:</td>
            	<td><form:input path="joinDate" type="date" required="true"/></td>
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
            	<td><form:password path="empPassword" id="password1" />
            </tr>
            
            <tr>
            	<td>Confirm Password:</td>
            	<td><form:password path="empPassword" id="password2" />
            </tr>
			
			<tr>
				<td><input type="submit" value="Save"/></td>
				<td><input type="reset" value="Reset"/></td>
			</tr>
        </table>
    </form:form>

</body>
</html>