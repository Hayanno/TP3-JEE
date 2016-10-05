<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personnes</title>
</head>
<body>
	<jsp:useBean id="person" scope="session" class="beans.person.Person"></jsp:useBean>
	
	<table>
		<tr>
			<td>ID</td>
			<td>First name</td>
			<td>Last name</td>
			<td>Birth date</td>
			<td>Email Address</td>
		</tr>
		<tr>
			<td><%= person.getId() %></td>
			<td><%= person.getFirstname() %></td>
			<td><%= person.getLastname() %></td>
			<td><%= person.getBirthDate() %></td>
			<td><%= person.getEmailAddress() %></td>
		</tr>
	</table>
</body>
</html>