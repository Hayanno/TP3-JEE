<jsp:include page="header.jsp">
	<jsp:param name="title" value="Edition personne"/>
</jsp:include>

<jsp:useBean id="p" scope="session" class="beans.person.Person"></jsp:useBean>
<jsp:useBean id="v" scope="session" class="beans.validation.Validation"></jsp:useBean>

<div class="container">
	<h2>Edition personne</h2>

	<form action="edition" method="post">
		<div class="form-group">
   			<label for="id">ID</label>
   			<input class="form-control" type="number" name="id" id="id" value="<%= p.getId() %>">
 		</div>
 		<div class="form-group">
   			<label for="firstname">Prénom</label>
   			<input type="text" class="form-control" name="firstname" id="firstname" value="<%= p.getFirstname() %>" placeholder="Prénom">
 		</div>
 		<div class="form-group">
   			<label for="lastname">Nom</label>
   			<input type="text" class="form-control" name="lastname" id="lastname" value="<%= p.getLastname() %>" placeholder="Nom" required>
			<span class="error"><%= v.getValidationMessage("lastname") %></span>
 		</div>
 		<div class="form-group">
   			<label for="birthdate">Date de naissance</label>
   			<input type="date" class="form-control" name="birthdate" id="birthdate"  value="<%= p.getBirthDate() %>">
 		</div>
 		<div class="form-group">
   			<label for="emailaddress">Adresse mail</label>
   			<input type="email" class="form-control" name="emailaddress" id="emailaddress" value="<%= p.getEmailAddress() %>" placeholder="mail@adresse.fr" required>
			<span class="error"><%= v.getValidationMessage("emailaddress") %></span>
 		</div>
		<button type="submit" class="btn btn-primary btn-lg btn-block">Envoyer</button>
	</form>
</div>

<%@ include file="footer.jsp" %>