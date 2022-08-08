// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.web.dto.out;

import java.time.LocalDate;
import java.time.LocalTime;

import com.banque.entity.impl.OperationEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

/**
 * le DTO pour les operations.
 */
public class OperationDtoOut extends AbstractDtoOut {

	private static final long serialVersionUID = 1L;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dateOp;
	@JsonDeserialize(using = LocalTimeDeserializer.class)
	@JsonSerialize(using = LocalTimeSerializer.class)
	private LocalTime heureOp;
	private String libelle;
	private Double montant;

	/**
	 * Constructor of the object.
	 *
	 */
	public OperationDtoOut() {
		super();
	}

	/**
	 * Constructor of the object.
	 *
	 * @param pEntity l'entite
	 */
	public OperationDtoOut(OperationEntity pEntity) {
		super(pEntity);
		this.setDateOp(pEntity.getDateOp());
		this.setHeureOp(pEntity.getHeureOp());
		this.setLibelle(pEntity.getLibelle());
		this.setMontant(pEntity.getMontant().doubleValue());
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut heure.
	 */
	public LocalTime getHeureOp() {
		return this.heureOp;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param heureOp la nouvelle valeur de l'attribut.
	 */
	public void setHeureOp(LocalTime heureOp) {
		this.heureOp = heureOp;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut date.
	 */
	public LocalDate getDateOp() {
		return this.dateOp;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pDate la nouvelle valeur de l'attribut.
	 */
	public void setDateOp(LocalDate pDate) {
		this.dateOp = pDate;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut libelle.
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pLibelle la nouvelle valeur de l'attribut.
	 */
	public void setLibelle(String pLibelle) {
		this.libelle = pLibelle;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut montant.
	 */
	public Double getMontant() {
		return this.montant;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pMontant la nouvelle valeur de l'attribut.
	 */
	public void setMontant(Double pMontant) {
		this.montant = pMontant;
	}

}
