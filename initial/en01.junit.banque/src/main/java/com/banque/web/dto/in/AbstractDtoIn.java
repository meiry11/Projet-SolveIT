// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.web.dto.in;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Le Data Transfert Object pout tous les beans en entrées.
 */
@JsonInclude(Include.NON_NULL)
abstract class AbstractDtoIn implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Evite d'avoir des chaines vides ou nulles
	 *
	 * @param pValue une valeur
	 * @return la chaine nétoyée si besoin
	 */
	@JsonIgnore
	protected final String checkAndClean(String pValue) {
		if (pValue == null || pValue.trim().isEmpty()) {
			return null;
		}
		return pValue.trim();
	}
}
