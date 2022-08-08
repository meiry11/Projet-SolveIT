// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.web.dto.out;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The dto class for the exception
 */
@JsonInclude(Include.NON_NULL)
public class ExceptionDtoOut implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger();

	private String exceptionName;
	private String exceptionMessage;
	private String exceptionCause;

	/**
	 * Constructor of the object.
	 */
	public ExceptionDtoOut() {
		super();
	}

	/**
	 * Constructor of the object.
	 *
	 * @param pException where to find information for building the DTO
	 */
	public ExceptionDtoOut(Throwable pException) {
		super();
		this.setExceptionName(pException.getClass().getName());
		this.setExceptionMessage(pException.getMessage());
		if (pException.getCause() != null) {
			try (var sw = new StringWriter(); var pw = new PrintWriter(sw);) {
				pException.getCause().printStackTrace(pw);
				this.setExceptionCause(sw.toString());
			} catch (Exception e) {
				ExceptionDtoOut.LOG.fatal("Erreur lors de la recuperation de la cause", e);
			}
		}
	}

	/**
	 * Gets the attribute value.
	 *
	 * @return the exceptionCause value.
	 */
	public String getExceptionCause() {
		return this.exceptionCause;
	}

	/**
	 * Sets the attribute value.
	 *
	 * @param pExceptionCause the new value for exceptionCause attribute
	 */
	public void setExceptionCause(String pExceptionCause) {
		this.exceptionCause = pExceptionCause;
	}

	/**
	 * Gets the attribute value.
	 *
	 * @return the exceptionName value.
	 */
	public String getExceptionName() {
		return this.exceptionName;
	}

	/**
	 * Sets the attribute value.
	 *
	 * @param pExceptionName the new value for exceptionName attribute
	 */
	public void setExceptionName(String pExceptionName) {
		this.exceptionName = pExceptionName;
	}

	/**
	 * Gets the attribute value.
	 *
	 * @return the exceptionMessage value.
	 */
	public String getExceptionMessage() {
		return this.exceptionMessage;
	}

	/**
	 * Sets the attribute value.
	 *
	 * @param pExceptionMessage the new value for exceptionMessage attribute
	 */
	public void setExceptionMessage(String pExceptionMessage) {
		this.exceptionMessage = pExceptionMessage;
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append(" {exceptionName=");
		sb.append(this.exceptionName);
		sb.append(",exceptionMessage=");
		sb.append(this.exceptionMessage);
		sb.append(",exceptionCause=");
		sb.append(this.exceptionCause);
		sb.append("}");
		return sb.toString();
	}

}
