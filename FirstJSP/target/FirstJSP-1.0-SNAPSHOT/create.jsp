<%@ page import="org.exemple.model.Employe" %>
<%@ page import="org.exemple.controller.ServletEmploye" %>
<%@ page import="org.exemple.controller.ICommand" %><%--
  Created by IntelliJ IDEA.
  User: roumaissa
  Date: 14/06/2022
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
<h1 style="text-align: center;margin-bottom: 100px;margin-top: 50px"> Create Page</h1>
<div class="container">
<form method="post" action="<%=request.getContextPath() %>/ServletEmploye" class="row g-3 needs-validation" novalidate>
    <div class="col-md-4">
        <label for="nom" class="form-label">Nom</label>
        <input name="<%=Employe.NOM %>" type="text" class="form-control" requied="required" id="nom" value="nom" required>
        <div class="valid-feedback">
            c'est ok
        </div>
    </div>
    <br>
    <div class="col-md-4">
        <label for="prenom" class="form-label">Prénom</label>
        <input type="text"  name="<%=Employe.PRENOM %>" class="form-control" requied="required" id="prenom" value="prenom" required>
        <div class="valid-feedback">
            c'est ok
        </div>
    </div>
    <br>
    <div class="col-md-4">
        <label for="salaire" class="form-label">Salaire</label>
        <input type="number"   name="<%=Employe.SALAIRE %>" class="form-control" requied="required" id="salaire" value="salaire" required>
        <div class="valid-feedback">
            c'est ok
        </div>
    </div>
    <br>
    <input type="hidden" name="<%=ServletEmploye.COMMAND_NAME_ATTRIBUTE%>" value="<%=ServletEmploye.CREAT_COMMAND_KEY%>" />



    <div class="col-12">
        <button class="btn btn-primary" type="submit">Submit form</button>
    </div>
</form>

</div>
</body>
</html>
