<%@ page import="org.exemple.controller.ICommand" %><%--
  Created by IntelliJ IDEA.
  User: roumaissa
  Date: 13/06/2022
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FirstJSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

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




<h1 style="text-align: center;"> Page Accueil</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Nom</th>
        <th scope="col">Prenom</th>
        <th scope="col">Salaire</th>
        <th scope="col">Date d'embauche</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <% for (int i =0 ;i <10;i++){ %>
      <tr>
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
        <td>2022-01-30</td>
        <td style="color: cornflowerblue;"> <a href="<%=request.getContextPath() %>/modify-salary.jsp">Augmenter le salaire</a> </td>
        <td style="color: cornflowerblue;">Licencier</td>
      </tr>
    <% } %>

    </tbody>
</table>
    <% if(!"".equals(request.getAttribute(ICommand.MESSAGE_KEY)) && request.getAttribute(ICommand.MESSAGE_KEY) != null) { %>
    <div class="alert alert-success"><%=request.getAttribute(ICommand.MESSAGE_KEY) %></div>
    <%
    }%>
</div>
</body>
</html>
