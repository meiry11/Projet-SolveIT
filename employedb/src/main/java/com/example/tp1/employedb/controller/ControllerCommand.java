package com.example.tp1.employedb.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.tp1.employedb.dao.EmployeDAO;


public interface ControllerCommand {
//	void processRequest(ServletContext context, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void processRequest(EmployeDAO dao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	default  void redirect(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	default EmployeDAO getEmployeDAO(ServletContext context) {
		return  (EmployeDAO) context.getAttribute(EmployeDAO.EMPLOYE_DAO_KEY);
	}
}
