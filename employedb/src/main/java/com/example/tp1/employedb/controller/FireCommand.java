package com.example.tp1.employedb.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.tp1.employedb.dao.EmployeDAO;
import com.example.tp1.employedb.model.Employe;

public class FireCommand implements ControllerCommand {

	@Override
	//public void processRequest(ServletContext context, HttpServletRequest request, HttpServletResponse response)
	public void processRequest(EmployeDAO dao, HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter(Employe.ID));
		
		dao.fire(id);
		
		this.redirect("index.jsp", request, response);
	}

}
