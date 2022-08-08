// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.web.dto.in;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Le Data Transfert Object pout tous les beans en sortie.
 */
@JsonInclude(Include.NON_NULL)
public class LoginDtoIn extends AbstractDtoIn {
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;

	/**
	 * Constructor of the object.
	 */
	public LoginDtoIn() {
		super();
	}

	/**
	 * Gets the attribute email.
	 *
	 * @return the value of email.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets a new value for the attribute email.
	 *
	 * @param pEmail the new value for the attribute.
	 */
	public void setEmail(String pEmail) {
		this.email = super.checkAndClean(pEmail);
	}

	/**
	 * Gets the attribute password.
	 *
	 * @return the value of password.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets a new value for the attribute password.
	 *
	 * @param pPassword the new value for the attribute.
	 */
	public void setPassword(String pPassword) {
		this.password = super.checkAndClean(pPassword);
	}

}
