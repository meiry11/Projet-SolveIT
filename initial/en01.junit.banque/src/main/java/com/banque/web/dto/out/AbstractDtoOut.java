// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.web.dto.out;

import java.io.Serializable;

import com.banque.entity.impl.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Le Data Transfert Object pout tous les beans en sortie.
 */
@JsonInclude(Include.NON_NULL)
abstract class AbstractDtoOut implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	/**
	 * Constructor of the object.
	 */
	public AbstractDtoOut() {
		super();
	}

	/**
	 * Constructor of the object.
	 *
	 * @param pEntity l'entite
	 */
	public AbstractDtoOut(AbstractEntity pEntity) {
		this.setId(pEntity.getId());
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut id.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pId la nouvelle valeur de l'attribut.
	 */
	public void setId(Integer pId) {
		this.id = pId;
	}

}
