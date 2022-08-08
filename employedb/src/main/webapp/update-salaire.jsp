<%@page import="com.example.tp1.employedb.controller.EmployeControllerServlet"%>
<%@page import="com.example.tp1.employedb.model.Employe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Increase Salary</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/fontawesome.min.css">

</head>
<body>
 <div class="container">
	<form action="<%=request.getContextPath() %>/employe" method="POST">
	    <div class="form-group">
	        <label for="salaire">Nouveau Salaire</label>
	        <input type="number" class="form-control" name="<%=Employe.SALAIRE	%>" required="required" placeholder="Entrer le nouveau salaire" />
	    </div>
		<input type="hidden" name="<%=Employe.ID%>" value="<%=request.getParameter(Employe.ID) %>"/>
		<input type="hidden" name="<%=EmployeControllerServlet.COMMAND_ATTRIBUTE_NAME%>" value="<%=EmployeControllerServlet.UPDATE_SALAIRE_COMMAND_KEY%>" />
	    <div class="form-group">
	        <input class="btn btn-primary" type="submit" value="Augmenter salaire" />
	    </div>
	</form>
</div>
</body>
</html>