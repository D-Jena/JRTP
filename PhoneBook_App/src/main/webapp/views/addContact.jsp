<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Contact</title>

  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>

</head>
<body>

	<h2>Save contact</h2>
	<p>
		<font color='green'>${succMsg}</font>
	</p>
	<p>
		<font color='red'>${errMsg}</font>
	</p>
	<form:form  id="contactForm"
				action="saveContact"
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
				<td><form:input path="phone"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"/></td>
				<td><input type="reset" value="Reset"/></td>
			</tr>
		</table>
		
	</form:form>
	<a href="/PhoneBook_App/viewContacts">View all contacts</a>
	
	<script>
    $(document).ready(function() {
      $("#contactForm").validate({
        rules: {
          name: {
            minlength: 3,
            maxlength: 50
          },
          phone: {
            digits: true,
            minlength: 10,
            maxlength: 15
          },
          email: {
            email: true
          }
        },
        messages: {
          name: {
            required: "Please enter your name",
            minlength: "Your name must be at least 3 characters long",
            maxlength: "Your name must be no more than 50 characters long"
          },
          phone: {
            required: "Please enter your phone number",
            digits: "Your phone number must contain only digits",
            minlength: "Your phone number must be at least 10 digits long",
            maxlength: "Your phone number must be no more than 15 digits long"
          },
          email: {
            required: "Please enter your email address",
            email: "Please enter a valid email address"
          }
        }
      });
    });
  </script>

</body>
</html>