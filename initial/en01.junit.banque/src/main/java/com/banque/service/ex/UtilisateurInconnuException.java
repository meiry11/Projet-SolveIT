// -#--------------------------------------
// -# ©Copyrigth Ferret Renaud 2019       -
// -# Email: admin@ferretrenaud.fr        -
// -# All Rights Reserved.                -
// -#--------------------------------------

package com.banque.service.ex;

/**
 * Erreur d'authentification.
 */
public class UtilisateurInconnuException extends AuthentificationException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de l'objet.
	 */
	public UtilisateurInconnuException() {
		super();
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 */
	public UtilisateurInconnuException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pCause
	 */
	public UtilisateurInconnuException(Throwable pCause) {
		super(pCause);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 * @param pCause
	 */
	public UtilisateurInconnuException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}
}
