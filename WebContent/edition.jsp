<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
	<jsp:param name="title" value="Edition personne" />
</jsp:include>

<jsp:useBean id="person" scope="session" class="beans.person.Person"></jsp:useBean>
<jsp:useBean id="validation" scope="session" class="beans.validation.Validation"></jsp:useBean>

<div class="container">
	<h2>Edition personne</h2>

	<form action="edition" method="post">
		<div class="form-group">
   			<label for="id">ID</label>
   			<input class="form-control" type="number" name="id" id="id" value="<%= person.getId() %>">
 		</div>
 		<div class="form-group">
   			<label for="firstname">Prenom</label>
   			<input type="text" class="form-control" name="firstname" id="firstname" value="<%= person.getFirstname() %>" placeholder="Prenom">
 		</div>
 		<div class="form-group">
   			<label for="lastname">Nom</label>
   			<input type="text" class="form-control" name="lastname" id="lastname" value="<%= person.getLastname() %>" placeholder="Nom" required>
			<span class="error"><%= validation.getValidationMessage("lastname") %></span>
 		</div>
 		<div class="form-group">
   			<label for="birthdate">Date de naissance</label>
   			<input type="date" class="form-control" name="birthdate" id="birthdate"  value="<%= person.getBirthDate() %>">
 		</div>
 		<div class="form-group">
   			<label for="emailaddress">Adresse mail</label>
   			<input type="email" class="form-control" name="emailaddress" id="emailaddress" value="<%= person.getEmailAddress() %>" placeholder="mail@adresse.fr" required>
			<span class="error"><%= validation.getValidationMessage("emailaddress") %></span>
 		</div>
		<button type="submit" class="btn btn-primary btn-lg btn-block">Envoyer</button>
	</form>
</div>

<%@ include file="footer.jsp" %>