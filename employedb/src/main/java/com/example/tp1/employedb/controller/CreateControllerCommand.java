package com.example.tp1.employedb.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.tp1.employedb.dao.EmployeDAO;
import com.example.tp1.employedb.model.Employe;


public class CreateControllerCommand implements ControllerCommand {

	@Override
	//public synchronized void processRequest(ServletContext context, HttpServletRequest request, HttpServletResponse response)
	public synchronized void processRequest(EmployeDAO context, HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String nom = request.getParameter(Employe.NOM);
		String prenom = request.getParameter(Employe.PRENOM);
		int salaire = Integer.parseInt(request.getParameter(Employe.SALAIRE));
		
		context.create(nom,prenom, salaire);
		
		request.setAttribute("message", "Employé bien créé !");
		this.redirect("index.jsp", request, response);
	}
	
}
