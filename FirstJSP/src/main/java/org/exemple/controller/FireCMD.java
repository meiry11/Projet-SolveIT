package org.exemple.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FireCMD implements ICommand{
    @Override
    public void processRequest(ServletContext ctxt, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(MESSAGE_KEY,"je suis la commande de licenciment");

    }
}