// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.web.controller.rest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import com.banque.service.ex.FonctionnelleException;
import com.banque.web.dto.out.UtilisateurDtoOut;

/**
 * Parent des autres controller.
 */
@RestController
public abstract class AbstractRestController {

	/**
	 * Recupere l'id de l'utilisateur connecte.
	 *
	 * @return l'id de l'utilisateur connecte
	 * @throws Exception si pas connecte
	 */
	protected final Integer getConnectedUserId() throws Exception {
		var principal = SecurityContextHolder.getContext().getAuthentication();
		if (principal instanceof UsernamePasswordAuthenticationToken) {
			var pc = (UsernamePasswordAuthenticationToken) principal;
			var userDto = (UtilisateurDtoOut) pc.getDetails();
			return userDto.getId();
		}
		throw new FonctionnelleException("Pas connecte");
	}
}
