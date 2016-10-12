<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="header.jsp">
	<jsp:param name="title" value="Liste des personnes" />
</jsp:include>

<div class="container">
	<h2>Liste des personnes</h2>
	
	<table class="table table-striped table-hover">
		<tr>
			<th>ID</th>
			<th>Prénom</th>
			<th>Nom</th>
			<th>Date de naissance</th>
			<th>Adresse mail</th>
			<th>Editer</th>
			<th>Supprimer</th>
		</tr>
		<c:forEach items="${persons}" var="person">
			<tr>
				<td><c:out value="${person.value.getId()}"/></td>
				<td><c:out value="${person.value.getFirstname()}"/></td>
				<td><c:out value="${person.value.getLastname()}"/></td>
				<td><c:out value="${person.value.getBirthDate()}"/></td>
				<td><c:out value="${person.value.getEmailAddress()}"/></td>
				<td>
					<a type="button" class="btn btn-primary btn-xs" aria-label="éditer une personne" href="edition?id=${fn:escapeXml(person.value.getId())}">
  						<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
					</a>
				</td>
				<td>
					<a type="button" class="btn btn-danger btn-xs" aria-label="supprimer une personne" href="supprimer?id=${fn:escapeXml(person.value.getId())}">
  						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a type="button" class="btn btn-primary" aria-label="ajouter une personne" href="edition">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Ajouter une personne
	</a>
</div>

<jsp:include page="footer.jsp"></jsp:include>