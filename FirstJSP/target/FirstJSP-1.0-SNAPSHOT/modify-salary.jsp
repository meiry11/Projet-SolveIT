<%@ page import="org.exemple.model.Employe" %>
<%@ page import="org.exemple.controller.ServletEmploye" %><%--
  Created by IntelliJ IDEA.
  User: roumaissa
  Date: 14/06/2022
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
<div class="container">
<form method="post" action="<%=request.getContextPath() %>/ServletEmploye" class="row g-3 needs-validation" novalidate>
    <div class="col-md-4">
        <label for="salaire" class="form-label">Salaire</label>
        <input type="number" name="<%=Employe.SALAIRE %>" required="required" class="form-control" id="salaire" value="salaire" required>
        <div class="valid-feedback">
            c'est ok
        </div>
    </div>
    <input type="hidden" name="<%=ServletEmploye.COMMAND_NAME_ATTRIBUTE%>" value="<%=ServletEmploye.UPDATE_SALAIRE_COMMAND_KEY%>" />

    <div class="col-12">
        <button class="btn btn-primary" type="submit">Submit form</button>
    </div>
</form>
</div>
</body>
</html>
