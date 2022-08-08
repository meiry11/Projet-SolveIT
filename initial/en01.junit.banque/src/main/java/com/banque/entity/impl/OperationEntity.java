// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019       -
// -# Email: admin@ferretrenaud.fr        -
// -# All Rights Reserved.                -
// -#--------------------------------------

package com.banque.entity.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Le bean qui represente une operation. <br>
 */
@Entity
@Table(name = "operation")
public class OperationEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "dateOp")
	private LocalDate dateOp;
	@Column(name = "heureOp")
	private LocalTime heureOp;

	@Column(name = "libelle", length = 250)
	private String libelle;
	@Column(name = "montant", precision = 10)
	private BigDecimal montant;

	@ManyToOne
	@JoinColumn(name = "compteId")
	private CompteEntity compte;

	/**
	 * Constructeur de l'objet. <br>
	 */
	public OperationEntity() {
		this(null, null, null, null, null);
	}

	/**
	 * Constructeur de l'objet. <br>
	 *
	 * @param pId un id
	 */
	public OperationEntity(Integer pId) {
		this(pId, null, null, null, null);
	}

	/**
	 * Constructeur de l'objet. <br>
	 *
	 * @param unId      unid
	 * @param uneDate   la date de l'operation
	 * @param uneHeure  l'heure de l'operation
	 * @param unLibelle le libelle de l'operation
	 * @param unMontant un montant
	 */
	public OperationEntity(Integer unId, LocalDate uneDate, LocalTime uneHeure, String unLibelle,
			BigDecimal unMontant) {
		super(unId);
		this.setDateOp(uneDate);
		this.setHeureOp(uneHeure);
		this.setLibelle(unLibelle);
		this.setMontant(unMontant);
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete heureOp
	 */
	public LocalTime getHeureOp() {
		return this.heureOp;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param uneHeure la nouvelle valeur pour l'attribut heureOp
	 */
	public void setHeureOp(LocalTime uneHeure) {
		if (uneHeure == null) {
			this.heureOp = LocalTime.now();
		} else {
			this.heureOp = uneHeure;
		}
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete dateOp
	 */
	public LocalDate getDateOp() {
		return this.dateOp;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param uneDate la nouvelle valeur pour l'attribut dateOp
	 */
	public void setDateOp(LocalDate uneDate) {
		if (uneDate == null) {
			this.dateOp = LocalDate.now();
		} else {
			this.dateOp = uneDate;
		}
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete libelle
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param unLibelle la nouvelle valeur pour l'attribut libelle
	 */
	public void setLibelle(String unLibelle) {
		if (unLibelle == null || unLibelle.trim().isEmpty()) {
			this.libelle = null;
		} else {
			this.libelle = unLibelle;
		}
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete montant
	 */
	public BigDecimal getMontant() {
		return this.montant;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param montant la nouvelle valeur pour l'attribut montant
	 */
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete compte
	 */
	public CompteEntity getCompte() {
		return this.compte;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param compte la nouvelle valeur pour l'attribut compte
	 */
	public void setCompte(CompteEntity compte) {
		this.compte = compte;
	}

	/**
	 * Donne une representation chainee de l'objet
	 *
	 * @return une representation chainee de l'objet
	 */
	@Override
	public String toString() {
		var sb = new StringBuilder();
		var parent = super.toString();
		parent = parent.substring(0, parent.length() - 1);
		sb.append(parent);
		sb.append(",compte=");
		sb.append(this.getCompte());
		sb.append(",libelle=");
		sb.append(this.getLibelle());
		sb.append(",montant=");
		sb.append(this.getMontant());
		sb.append(",date=");
		sb.append(this.getDate());
		sb.append("}");
		return sb.toString();
	}

	public String getDate() {
		// FIXME Maladroit : car cette méthode sert dans un cadre d'affichage
		return this.getDateOp().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) + " "
				+ this.getHeureOp().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
}
