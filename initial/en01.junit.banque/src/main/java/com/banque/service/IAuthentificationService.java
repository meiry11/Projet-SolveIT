// -#--------------------------------------
// -# ©Copyrigth Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;

import com.banque.entity.impl.UtilisateurEntity;

/**
 * Service d'authentification.
 */
public interface IAuthentificationService extends AuthenticationProvider {
	@Override
	public default boolean supports(Class<?> pAuthentication) {
		return Authentication.class.isAssignableFrom(pAuthentication);
	}

	/**
	 * Methode d'authentification personnelle.
	 *
	 * @param pEmail    l'email
	 * @param pPassword le mot de passe
	 * @return l'utilisateur qui a l'email et mot de passe indique
	 * @throws Exception                si un probleme survient
	 * @throws IllegalArgumentException si un des parametres n'est pas valide
	 */
	public UtilisateurEntity authentifier(String pEmail, String pPassword) throws Exception;

}
