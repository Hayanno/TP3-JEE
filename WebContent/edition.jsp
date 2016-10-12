<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="header.jsp">
	<jsp:param name="title" value="Edition personne" />
</jsp:include>

<jsp:useBean id="person" scope="session" class="beans.person.Person"></jsp:useBean>
<jsp:useBean id="validation" scope="session" class="beans.validation.Validation"></jsp:useBean>
<jsp:useBean id="status" scope="session" class="java.util.HashMap">
	<c:set target="${status}" property="1" value="Etudiant"/>
	<c:set target="${status}" property="2" value="Enseignant"/>
	<c:set target="${status}" property="3" value="Extérieur"/>
</jsp:useBean>

<div class="container">
	<h2>Edition personne</h2>

	<form action="edition" method="post">
		<div class="form-group">
   			<label for="id">ID</label>
   			<input class="form-control" type="number" name="id" id="id" value="${fn:escapeXml(person.getId())}">
 		</div>
 		<div class="form-group">
   			<label for="firstname">Prénom</label>
   			<input type="text" class="form-control" name="firstname" id="firstname" value="${fn:escapeXml(person.getFirstname())}" placeholder="Prénom">
 		</div>
 		<div class="form-group">
   			<label for="lastname">Nom</label>
   			<input type="text" class="form-control" name="lastname" id="lastname" value="${fn:escapeXml(person.getLastname())}" placeholder="Nom" required>
			<span class="error">${fn:escapeXml(validation.getValidationMessage("lastname"))}</span>
 		</div>
 		<div class="form-group">
   			<label for="birthdate">Date de naissance</label>
   			<input type="date" class="form-control" name="birthdate" id="birthdate"  value="${fn:escapeXml(person.getBirthDate())}">
 		</div>
 		<div class="form-group">
   			<label for="emailaddress">Adresse mail</label>
   			<input type="email" class="form-control" name="emailaddress" id="emailaddress" value="${fn:escapeXml(person.getEmailAddress())}" placeholder="mail@adresse.fr" required>
			<span class="error">${fn:escapeXml(validation.getValidationMessage("emailaddress"))}</span>
 		</div>
 		<div class="form-group">
 			<label for="status">Status</label>
 			<select class="form-control" id="status" name="status">
 				<c:forEach items="${status}" var="item">
					<option value="${fn:escapeXml(item.key)}" ${item.key == person.getStatusID() ? 'selected' : ''}/><c:out value="${item.value}" /></option>
				</c:forEach>
 			</select>
 		</div>
		<button type="submit" class="btn btn-primary btn-lg btn-block">Envoyer</button>
	</form>
</div>

<jsp:include page="footer.jsp"></jsp:include>