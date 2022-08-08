// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.web.dto.out;

import java.math.BigDecimal;

import com.banque.entity.impl.CompteEntity;

/**
 * Le DTO pour les comptes.
 */
public class CompteDtoOut extends AbstractDtoOut {

	private static final long serialVersionUID = 1L;

	private String libelle;
	private BigDecimal solde;
	private BigDecimal decouvert;
	private BigDecimal taux;

	/**
	 * Constructor of the object.
	 */
	public CompteDtoOut() {
		super();
	}

	/**
	 * Constructor of the object.
	 *
	 * @param pEntity l'entite
	 */
	public CompteDtoOut(CompteEntity pEntity) {
		super(pEntity);
		this.setDecouvert(pEntity.getDecouvert());
		this.setLibelle(pEntity.getLibelle());
		this.setSolde(pEntity.getSolde());
		this.setTaux(pEntity.getTaux());
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
	 * @return la valeur de l'attribut solde.
	 */
	public BigDecimal getSolde() {
		return this.solde;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pSolde la nouvelle valeur de l'attribut.
	 */
	public void setSolde(BigDecimal pSolde) {
		this.solde = pSolde;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut decouvert.
	 */
	public BigDecimal getDecouvert() {
		return this.decouvert;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pDecouvert la nouvelle valeur de l'attribut.
	 */
	public void setDecouvert(BigDecimal pDecouvert) {
		this.decouvert = pDecouvert;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut taux.
	 */
	public BigDecimal getTaux() {
		return this.taux;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pTaux la nouvelle valeur de l'attribut.
	 */
	public void setTaux(BigDecimal pTaux) {
		this.taux = pTaux;
	}

}
