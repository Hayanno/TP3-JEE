<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edition</title>
</head>
<body>
	<form action="edition" method="post">
		<label>ID : </label>
		<input type="number" name="id">
		
		<label>First name : </label>
		<input type="text" name="firstname">
		
		<label>Last name : </label>
		<input type="text" name="lastname">
		
		<label>Birth Date : </label>
		<input type="date" name="birthdate">
		
		<label>Email Address : </label>
		<input type="email" name="emailaddress">
		
		<button type="submit">Submit</button>
	</form>
</body>
</html>