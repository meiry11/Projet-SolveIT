package com.banque.web.controller.rest;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.banque.service.ex.ErreurTechniqueException;
import com.banque.service.ex.FonctionnelleException;
import com.banque.web.dto.out.ExceptionDtoOut;

/**
 * Va gerer toutes les exceptions de nos controleurs.
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * Handles functional exceptions.
	 *
	 * @param pException the targeted exception
	 * @param request    the HttpServletRequest request
	 * @return the HttpStatus and body regarding the exception
	 */
	@ExceptionHandler(FonctionnelleException.class)
	public ResponseEntity<ExceptionDtoOut> exceptionHandler(FonctionnelleException pException,
			HttpServletRequest request) {
		final var remoteIP = request.getRemoteAddr();
		GlobalControllerExceptionHandler.LOG.error("[{}] --> exceptionHandler", remoteIP, pException);
		var dtoOut = new ExceptionDtoOut(pException);
		GlobalControllerExceptionHandler.LOG.error("[{}] <-- exceptionHandler", remoteIP);
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(dtoOut);
	}

	/**
	 * Handles technical exceptions.
	 *
	 * @param pException the targeted exception
	 * @param request    the HttpServletRequest request
	 * @return the HttpStatus and body regarding the exception
	 */
	@ExceptionHandler(ErreurTechniqueException.class)
	public ResponseEntity<ExceptionDtoOut> exceptionHandler(ErreurTechniqueException pException,
			HttpServletRequest request) {
		final var remoteIP = request.getRemoteAddr();
		GlobalControllerExceptionHandler.LOG.error("[{}] --> exceptionHandler", remoteIP, pException);
		var dtoOut = new ExceptionDtoOut(pException);
		GlobalControllerExceptionHandler.LOG.error("[{}] <-- exceptionHandler", remoteIP);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dtoOut);
	}
}
