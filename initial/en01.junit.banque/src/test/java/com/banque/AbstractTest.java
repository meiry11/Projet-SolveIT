// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe abstraite en charge de la preparation du chargement des classes
 * annotees Spring. <br>
 * Cette classe sera la classe parent de tous vos tests. <br>
 * Nous sommes en JUnit 5, faites attention à vos import.
 */
@SpringBootTest
@Transactional
@Rollback(true)
@AutoConfigureMockMvc
public abstract class AbstractTest {
	protected final static String DEFAULT_EMAIL = "df@aol.com";
	protected final static String DEFAULT_PWD = "df";
}
