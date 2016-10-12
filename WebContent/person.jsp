<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
	<jsp:param name="title" value="Affichage personne" />
</jsp:include>

<jsp:useBean id="person" scope="session" class="beans.person.Person"></jsp:useBean>

<div class="container">
	<h2>Personne</h2>
	
	<table class="table table-striped table-hover">
		<tr>
			<th>ID</th>
			<th>Prénom</th>
			<th>Nom</th>
			<th>Date de naissance</th>
			<th>Adresse mail</th>
		</tr>
		<tr>
			<td><c:out value="${person.getId()}"/></td>
			<td><c:out value="${person.getFirstname()}"/></td>
			<td><c:out value="${person.getLastname()}"/></td>
			<td><c:out value="${person.getBirthDate()}"/></td>
			<td><c:out value="${person.getEmailAddress()}"/></td>
		</tr>
	</table>
</div>

<jsp:include page="footer.jsp"></jsp:include>