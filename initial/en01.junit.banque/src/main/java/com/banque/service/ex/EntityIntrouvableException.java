// -#--------------------------------------
// -# ©Copyrigth Ferret Renaud 2019       -
// -# Email: admin@ferretrenaud.fr        -
// -# All Rights Reserved.                -
// -#--------------------------------------

package com.banque.service.ex;

/**
 * Erreur sur une entite introuvable.
 */
public class EntityIntrouvableException extends FonctionnelleException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de l'objet.
	 */
	public EntityIntrouvableException() {
		super();
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 */
	public EntityIntrouvableException(String pMessage) {
		super(pMessage);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pCause
	 */
	public EntityIntrouvableException(Throwable pCause) {
		super(pCause);
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param pMessage
	 * @param pCause
	 */
	public EntityIntrouvableException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}
}
