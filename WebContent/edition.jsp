<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edition</title>
</head>
<body>
	<jsp:useBean id="p" scope="session" class="beans.person.Person"></jsp:useBean>
	<jsp:useBean id="v" scope="session" class="beans.validation.Validation"></jsp:useBean>

	<form action="edition" method="post">
		<label>ID : </label>
		<input type="number" name="id" value="<%= p.getId() %>">
		
		<label>First name : </label>
		<input type="text" name="firstname" value="<%= p.getFirstname() %>">
		
		<label>Last name : </label>
		<input type="text" name="lastname" value="<%= p.getLastname() %>" required>
		<span class="error"><%= v.getValidationMessage("lastname") %></span>
		
		<label>Birth Date : </label>
		<input type="date" name="birthdate" value="<%= p.getBirthDate() %>">
		
		<label>Email Address : </label>
		<input type="text" name="emailaddress" value="<%= p.getEmailAddress() %>" required>
		<span class="error"><%= v.getValidationMessage("emailaddress") %></span>
		
		<button type="submit">Submit</button>
	</form>
</body>
</html>