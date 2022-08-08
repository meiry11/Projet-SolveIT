package com.banque.dao;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.banque.AbstractTest;

/**
 * Exemple d'un test en Spring sur le repository des comptes. <br>
 * Nous sommes en JUnit 5, faites attention à vos import.
 * <ul>
 * <li>PAS de <b>org.junit</b></li>
 * <li>MAIS DES <b>org.junit.jupiter.api</b></li>
 * </ul>
 */
class ICompteDAOTest extends AbstractTest {

	// L'objet que l'on veut tester
	// Il sera injecte par le Spring automatiquement, pas besoin de faire de new
	@Autowired
	private ICompteDAO dao;

	// Nous sommes en JUnit 5, faites attention à vos import.
	// L'API de test vient de org.junit.jupiter.api
	@org.junit.jupiter.api.Test
	void testFindById01() throws Exception {
		final var cptId = Integer.valueOf(12); // le compte 12 existe bien
		var compte = this.dao.findById(cptId);

		Assertions.assertTrue(compte.isPresent(), "Le compte doit avoir ete trouve");
		Assertions.assertEquals(cptId, compte.get().getId(), () -> "Le compte doit avoir l'id " + cptId);
	}
}
