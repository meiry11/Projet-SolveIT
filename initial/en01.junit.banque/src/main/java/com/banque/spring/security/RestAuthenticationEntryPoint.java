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
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.banque.web.dto.out.ExceptionDtoOut;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handle login REST return value if error. <br>
 * Take back the code in
 * org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint
 * but remove the header WWW-Authenticate as specified in normalization.
 */
@Component
public final class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	private static final Logger LOG = LogManager.getLogger();

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		RestAuthenticationEntryPoint.LOG.error("{} --> 401 <--- From AuthenticationEntryPoint for {}",
				request.getRemoteAddr(), request.getRequestURL(), authException);

		// We want our Json Exception model instead of the one in Spring
		var out = new ExceptionDtoOut(authException);
		var objectMapper = new ObjectMapper();
		var expToJson = objectMapper.writeValueAsString(out);
		var pw = response.getWriter();
		pw.write(expToJson);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		// org.springframework.http.HttpStatus.UNAUTHORIZED in Spring
		// This will use the Spring Json Exception model :
		// response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}
