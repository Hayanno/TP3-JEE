<%@ include file="header.jsp" %>

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

<%@ include file="footer.jsp" %>