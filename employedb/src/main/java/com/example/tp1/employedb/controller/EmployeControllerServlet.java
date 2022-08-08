package com.example.tp1.employedb.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.tp1.employedb.dao.EmployeDAO;
import com.example.tp1.employedb.storage.EmployeStorage;

@WebServlet("/employe")
public class EmployeControllerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 2230422451433006376L;
	//Attribute for management
	public static final String COMMAND_ATTRIBUTE_NAME = "COMMAND";
	public static final String CREATE_COMMAND_KEY = "CREATE_COMMAND";
	public static final String FIRE_COMMAND_KEY = "FIRE_COMMAND";
	public static final String UPDATE_SALAIRE_COMMAND_KEY = "UPDATE_SALAIRE_COMMAND";

	@Inject
	private EmployeDAO dao;
	private Map<String, ControllerCommand> commands = new HashMap<>();
	
	public EmployeControllerServlet() {
		commands.put(CREATE_COMMAND_KEY,new CreateControllerCommand());
		commands.put(FIRE_COMMAND_KEY, new FireCommand());
		commands.put(UPDATE_SALAIRE_COMMAND_KEY, new UpdateSalaireCommand());
	}
	/*
	@Override
	public void init() throws ServletException {
		//Init Database
		if(getServletContext().getAttribute(EmployeStorage.EMPLOYE_STORAGE_KEY) == null) {
			getServletContext().setAttribute(EmployeStorage.EMPLOYE_STORAGE_KEY, new EmployeStorage());
		}
		
		EmployeStorage storage = (EmployeStorage) getServletContext().getAttribute(EmployeStorage.EMPLOYE_STORAGE_KEY);
		
		if(getServletContext().getAttribute(EmployeDAO.EMPLOYE_DAO_KEY) == null) {
			getServletContext().setAttribute(EmployeDAO.EMPLOYE_DAO_KEY, new EmployeDAO(storage));
		}
	}
	*/
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String commandName = req.getParameter(COMMAND_ATTRIBUTE_NAME);
		if(commandName == null || commandName.equals("")) {
			resp.setStatus(404);
			return;
		}
		
		ControllerCommand command = commands.get(commandName);
		if(command == null) {
			resp.setStatus(404);
			return;
		}
		
		//command.processRequest(getServletContext(), req, resp);
		command.processRequest(dao, req, resp);
	}
}
