<%@page import="com.example.tp1.employedb.controller.EmployeControllerServlet"%>
<%@page import="com.example.tp1.employedb.model.Employe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create Employee</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/fontawesome.min.css">

</head>
<body>
	 <div class="container">
		<form action="<%=request.getContextPath() %>/employe" method="POST">
		 	<div class="form-group">
		        <label for="nom">Nom</label>
		        <input type="text" class="form-control" name="<%=Employe.NOM%>" required="required" placeholder="Entrer le nom" />
		    </div>
		     <div class="form-group">
		        <label for="prenom">Prénom</label>
		        <input type="text" class="form-control" name="<%=Employe.PRENOM%>" required="required" placeholder="Entrer le prénom" />
		    </div>
		     <div class="form-group">
		        <label for="salaire">Salaire</label>
		        <input type="number" class="form-control" name="<%=Employe.SALAIRE%>" required="required" placeholder="Entrer le salaire" />
		    </div>
		   	<input type="hidden" name="<%=EmployeControllerServlet.COMMAND_ATTRIBUTE_NAME%>" 
		   	value="<%=EmployeControllerServlet.CREATE_COMMAND_KEY%>" />
		    <div class="form-group">
		        <input class="btn btn-primary" type="submit" value="Enregistrer" />
		    </div>
		</form>
	</div>
</body>
</html>