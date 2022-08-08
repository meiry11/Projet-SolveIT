// -#--------------------------------------
// -# ©Copyrigth Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banque.dao.IUtilisateurDAO;
import com.banque.entity.impl.UtilisateurEntity;
import com.banque.service.IAuthentificationService;
import com.banque.service.ex.MauvaisMotdepasseException;
import com.banque.service.ex.UtilisateurInconnuException;
import com.banque.web.dto.out.UtilisateurDtoOut;

/**
 * Gestion de l'authentification.
 */
@Service
public class AuthentificationService extends AbstractService implements IAuthentificationService {
	private static final Logger LOG = LogManager.getLogger();
	@Autowired
	private IUtilisateurDAO utilisateurDAO;

	/**
	 * Recupere la propriete <i>utilisateurDAO</i>.
	 *
	 * @return the utilisateurDAO la valeur de la propriete.
	 */
	protected IUtilisateurDAO getUtilisateurDAO() {
		return this.utilisateurDAO;
	}

	@Override
	public UtilisateurEntity authentifier(String pEmail, String pPassword) throws Exception {
		AuthentificationService.LOG.debug("authentifier {} Xxxx", pEmail);
		if (pEmail == null || pEmail.trim().length() == 0) {
			throw new IllegalArgumentException("email");
		}
		if (pPassword == null || pPassword.trim().length() == 0) {
			throw new IllegalArgumentException("password");
		}
		var resultat = this.getUtilisateurDAO().findByEmail(pEmail);
		if (!resultat.isPresent()) {
			throw new UtilisateurInconnuException();
		}
		if (!pPassword.equals(resultat.get().getPassword())) {
			throw new MauvaisMotdepasseException();
		}
		AuthentificationService.LOG.debug("authentifier Resultat = {} ", resultat.get());
		return resultat.get();
	}

	/**
	 * Methode d'authentification du Spring.
	 *
	 * Elle fait appel à la methode 'personnelle'.
	 *
	 */
	@Override
	@Transactional(readOnly = true)
	public Authentication authenticate(Authentication pAuthentication) throws AuthenticationException {
		var email = pAuthentication.getName();
		var password = pAuthentication.getCredentials() != null ? pAuthentication.getCredentials().toString() : null;
		AuthentificationService.LOG.debug("Spring Security Authenticate email={}", email);
		UtilisateurEntity user = null;
		try {
			user = this.authentifier(email, password);
		} catch (Exception lExp) {
			throw new AuthenticationServiceException("Erreur d'authentification", lExp);
		}
		if (user != null) {
			AuthentificationService.LOG.debug("Spring Security Authenticate found {}", user);
			Collection<GrantedAuthority> springSecurityRoles = new ArrayList<>(1);
			GrantedAuthority ga = new SimpleGrantedAuthority("ROLE_USER");
			springSecurityRoles.add(ga);
			var upat = new UsernamePasswordAuthenticationToken(email, password, springSecurityRoles);
			upat.setDetails(new UtilisateurDtoOut(user));
			return upat;
		}
		return null;
	}

}
