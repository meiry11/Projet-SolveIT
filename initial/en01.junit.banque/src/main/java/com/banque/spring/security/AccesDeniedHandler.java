// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.banque.web.dto.out.ExceptionDtoOut;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handle Access Denied.
 */
@Component
public final class AccesDeniedHandler implements AccessDeniedHandler {
	private static final Logger LOG = LogManager.getLogger();

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception)
			throws IOException, ServletException {
		AccesDeniedHandler.LOG.error("{} --> 403 <--- From AccesDeniedHandler for {}", request.getRemoteAddr(),
				request.getRequestURL(), exception);

		// We want our Json Exception model instead of the one in Spring
		var out = new ExceptionDtoOut(exception);
		var objectMapper = new ObjectMapper();
		var expToJson = objectMapper.writeValueAsString(out);
		var pw = response.getWriter();
		pw.write(expToJson);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);

		// This will use the Spring Json Exception model :
		// response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
	}

}
