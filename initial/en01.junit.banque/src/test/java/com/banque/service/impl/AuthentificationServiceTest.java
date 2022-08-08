package com.banque.service.impl;

import com.banque.service.ex.MauvaisMotdepasseException;
import com.banque.service.ex.UtilisateurInconnuException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.banque.AbstractTest;
import com.banque.service.IAuthentificationService;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 * Exemple d'un test en Spring sur le service d'authentification. <br>
 * Nous sommes en JUnit 5, faites attention à vos import.
 * <ul>
 * <li>PAS de <b>org.junit</b></li>
 * <li>MAIS DES <b>org.junit.jupiter.api</b></li>
 * </ul>
 */
class AuthentificationServiceTest extends AbstractTest {

	// L'objet que l'on veut tester
	// Il sera injecte par le Spring automatiquement, pas besoin de faire de new
	@Autowired
	private IAuthentificationService service;

	// Nous sommes en JUnit 5, faites attention à vos import.
	// L'API de test vient de org.junit.jupiter.api
	@org.junit.jupiter.api.Test
	void testAuthentifier01() throws Exception {
		final var email = AbstractTest.DEFAULT_EMAIL;
		final var pwd = AbstractTest.DEFAULT_PWD;
		var user = this.service.authentifier(email, pwd);
		Assertions.assertNotNull(user, "Le user ne doit pas être null");
		Assertions.assertEquals(email, user.getEmail(), () -> "Le user doit avoir l'email " + email);
	}
	@org.junit.jupiter.api.Test
	void testAuthentifierEmailNull() throws Exception {
		final String email = null;
		final String pwd = null;
		Assertions.assertThrows( IllegalArgumentException.class,()->this.service.authentifier(email, pwd),"on attend une exception de type IllegalArgument");
	}
	@org.junit.jupiter.api.Test
	void testAuthentifierPasswordNull() throws Exception {
		final String email = AbstractTest.DEFAULT_EMAIL;
		final String pwd = null;
		Assertions.assertThrows( IllegalArgumentException.class,()->this.service.authentifier(email, pwd),"on attend une exception de type IllegalArgument");
	}

	@org.junit.jupiter.api.Test
	void testAuthentifierWrongPWD() throws Exception {
		final var email = AbstractTest.DEFAULT_EMAIL;
		final var pwd = "test";
		Assertions.assertThrows(MauvaisMotdepasseException.class,()->this.service.authentifier(email, pwd),"on attend une exception de type MauvaisMotdepasseException");
	}

	@org.junit.jupiter.api.Test
	void testAuthentifierWrongEmail() throws Exception {
		final var email = "test";
		final var pwd = AbstractTest.DEFAULT_EMAIL;
		Assertions.assertThrows(UtilisateurInconnuException.class,()->this.service.authentifier(email, pwd),"on attend une exception de type UtilisateurInconnuException");
	}

	@org.junit.jupiter.api.Test
	void testauthenticateExceptionUserNotNull() throws Exception {
		Authentication authentication = new UsernamePasswordAuthenticationToken(AbstractTest.DEFAULT_EMAIL,AbstractTest.DEFAULT_PWD);
		var user = service.authenticate(authentication);
		Assertions.assertEquals(AbstractTest.DEFAULT_EMAIL, user.getName());
	}

	@org.junit.jupiter.api.Test
	void testauthenticateExceptionUserNotFound() throws Exception {
		Authentication authentication = new UsernamePasswordAuthenticationToken("test",AbstractTest.DEFAULT_PWD);
		Assertions.assertThrows(AuthenticationServiceException.class, ()->service.authenticate(authentication));
	}

}
