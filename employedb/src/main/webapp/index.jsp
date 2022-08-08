<%@page import="com.example.tp1.employedb.dao.EmployeDAO"%>
<%@page import="com.example.tp1.employedb.storage.EmployeStorage"%>
<%@page import="java.util.List"%>
<%@page import="com.example.tp1.employedb.model.Employe"%>
<%@page import="com.example.tp1.employedb.controller.EmployeControllerServlet"%>
<%@ taglib  prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Employee</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 </head>

<body>

	 <div class="container">
       <div style="margin-top:20px" class="row">
		    <div class="col-6">
		        <p class="float-start">
		        	<h1>Base d'employés</h1>
		        </p>
		    </div>
		    <div class="col-6 valign-middle" >
		        <p class="btn btn-outline-primary float-right"><a  href="<%=request.getContextPath() %>/create.jsp">Créer employé</a></p>

		    </div>
		</div>
	
		
		<table class="table">
			    <thead>
			        <tr>
			            <th scope="col">id</th>
			            <th scope="col">Nom</th>
			            <th scope="col">Prénom</th>
			            <th scope="col">Salaire</th>
			            <th scope="col">Date d'embauche</th>
			            <th scope="col"></th>
			            <th scope="col"></th>
			        </tr>
			    </thead>
			    <tbody>
			    
<%--				<% EmployeDAO dao = (EmployeDAO) application.getAttribute(EmployeDAO.EMPLOYE_DAO_KEY);--%>
<%--				   if(dao !=null) {--%>
<%--						for(Employe e: dao.getHiredEmployes()){--%>
<%--				%>--%>
<%--					CODE JSTL--%>
					<c:forEach items="${employedao.getHiredEmployes()}" var="employe" >

			       <tr>
				    	<td>${employe.id}</td>
				    	<td>${employe.nom}</td>
				    	<td>${employe.prenom}</td>
				    	<td>${employe.salaire }</td>
				    	<td>${employe.dateEmbauche}</td>
				    	<td><a href="<%=request.getContextPath()+"/update-salaire.jsp?"+Employe.ID+"="%>${employe.id}" >Augmenter le salaire</a></td>
				    	<td>
				    		<form action="<%=request.getContextPath() %>/employe" method="POST">
				    			<input type="hidden" name="<%=EmployeControllerServlet.COMMAND_ATTRIBUTE_NAME%>" value="<%=EmployeControllerServlet.FIRE_COMMAND_KEY%>" />
				    			<input type="hidden" name="<%=Employe.ID%>" value="${employe.id}" />
				    			<input type="submit" value="Licencier" />
				    		</form>
				    	</td>
			    	</tr>
					</c:forEach>
<%--			    <%--%>
<%--						}--%>
<%--					}--%>
<%--			    %>--%>
			    </tbody>
			</table>
			<%
				if(request.getAttribute("message") != null){
					out.println("<div class=\"alert alert-success\"> "+request.getAttribute("message")+"</div>");
				}
			%>
			
	</div>

</body>
</html>