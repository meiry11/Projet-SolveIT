package org.exemple.controller;

import org.exemple.model.Employe;
import org.exemple.model.EmployeDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCMD implements ICommand{
    @Override
    public void processRequest(ServletContext ctxt, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        EmployeDAO dao = (EmployeDAO) ctxt.getAttribute(ServletEmploye.EMPLOYE_DAO_KEY);
        dao.create(request.getParameter(Employe.NOM),request.getParameter(Employe.PRENOM),Integer.parseInt(request.getParameter(Employe.SALAIRE)));
        request.setAttribute(MESSAGE_KEY,"création ok");
    }
}
