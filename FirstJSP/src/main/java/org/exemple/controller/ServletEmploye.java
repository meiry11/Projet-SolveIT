package org.exemple.controller;

import org.exemple.model.EmployeDAO;
import org.exemple.model.EmployeStorage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ServletEmploye")
public class ServletEmploye extends HttpServlet {
    public static final String COMMAND_NAME_ATTRIBUTE= "command";
    public static final String CREAT_COMMAND_KEY= "create";
    public static final String UPDATE_SALAIRE_COMMAND_KEY= "update-salaire";
    public static final String FIRE_COMMAND_KEY= "fire";

    public static final String EMPLOYE_STORAGE_KEY="storage";

    public static final String EMPLOYE_DAO_KEY="dao";


    private Map<String,ICommand> listCommand = new HashMap<>();

    /**
     * Inits the command map values
     */

    public ServletEmploye(){
        listCommand.put(CREAT_COMMAND_KEY, new CreateCMD());
        listCommand.put(UPDATE_SALAIRE_COMMAND_KEY,new UpdateCMD());
        listCommand.put(FIRE_COMMAND_KEY,new FireCMD());
    }

    public void init() throws ServletException{
        if(getServletContext().getAttribute(EMPLOYE_STORAGE_KEY) == null);
            getServletContext().setAttribute(EMPLOYE_STORAGE_KEY,new EmployeStorage());
        EmployeStorage storage = (EmployeStorage) getServletContext().getAttribute(EMPLOYE_STORAGE_KEY);
        if(getServletContext().getAttribute(EMPLOYE_DAO_KEY) == null){
            getServletContext().setAttribute(EMPLOYE_DAO_KEY, new EmployeDAO(storage));
        }
        // POUR RECUPERER LES DONNEES DANS INDEX.JSP : application.getAttribut(EMPLOYE_DAO_KEY
        // )
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commande = request.getParameter(COMMAND_NAME_ATTRIBUTE);
        if (commande == null || "".equals(commande)) {
            response.setStatus(404);
            return;
        }
        listCommand.get(commande).processRequest(getServletContext(),request,response);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
