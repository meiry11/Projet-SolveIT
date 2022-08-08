// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019       -
// -# Email: admin@ferretrenaud.fr        -
// -# All Rights Reserved.                -
// -#--------------------------------------

package com.banque.entity.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Le bean qui represente un utilisateur. <br>
 */
@Entity
@Table(name = "utilisateur")
public class UtilisateurEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "email", length = 120, nullable = false)
	private String email;
	@Column(name = "password", length = 120, nullable = false)
	private String password;
	@Column(name = "nom", length = 120)
	private String nom;
	@Column(name = "prenom", length = 120)
	private String prenom;
	@Column(name = "sex")
	private Boolean sex;
	@Column(name = "derniereConnectionDate")
	private LocalDate derniereConnectionDate;
	@Column(name = "derniereConnectionHeure")
	private LocalTime derniereConnectionHeure;
	@Column(name = "dateDeNaissance")
	private LocalDate dateDeNaissance;
	@Column(name = "adresse", length = 500)
	private String adresse;
	@Column(name = "telephone", length = 20)
	private String telephone;
	@Column(name = "codePostal")
	private Integer codePostal;
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CompteEntity> comptes;

	/**
	 * Constructeur de l'objet. <br>
	 *
	 * Par defaut l'id du compte sera null
	 */
	public UtilisateurEntity() {
		super();
	}

	/**
	 * Constructeur de l'objet. <br>
	 *
	 * @param pId un id
	 */
	public UtilisateurEntity(Integer pId) {
		super(pId);
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pEmail la nouvelle valeur pour l'attribut email
	 */
	public void setEmail(String pEmail) {
		if (pEmail == null || pEmail.trim().isEmpty()) {
			this.email = null;
		} else {
			this.email = pEmail;
		}
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pPassword la nouvelle valeur pour l'attribut password
	 */
	public void setPassword(String pPassword) {
		if (pPassword == null || pPassword.trim().isEmpty()) {
			this.password = null;
		} else {
			this.password = pPassword;
		}
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pNom la nouvelle valeur pour l'attribut nom
	 */
	public void setNom(String pNom) {
		if (pNom == null || pNom.trim().isEmpty()) {
			this.nom = null;
		} else {
			this.nom = pNom;
		}
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pPrenom la nouvelle valeur pour l'attribut prenom
	 */
	public void setPrenom(String pPrenom) {
		if (pPrenom == null || pPrenom.trim().isEmpty()) {
			this.prenom = null;
		} else {
			this.prenom = pPrenom;
		}
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete sex
	 */
	public Boolean getSex() {
		return this.sex;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param sex la nouvelle valeur pour l'attribut sex
	 */
	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete derniereConnectionHeure
	 */
	public LocalTime getDerniereConnectionHeure() {
		return this.derniereConnectionHeure;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param derniereConnection la nouvelle valeur pour l'attribut
	 *                           derniereConnectionHeure
	 */
	public void setDerniereConnectionHeure(LocalTime derniereConnection) {
		this.derniereConnectionHeure = derniereConnection;
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete derniereConnectionDate
	 */
	public LocalDate getDerniereConnectionDate() {
		return this.derniereConnectionDate;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param derniereConnection la nouvelle valeur pour l'attribut
	 *                           derniereConnectionDate
	 */
	public void setDerniereConnectionDate(LocalDate derniereConnection) {
		this.derniereConnectionDate = derniereConnection;
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete dateDeNaissance
	 */
	public LocalDate getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param dateDeNaissance la nouvelle valeur pour l'attribut dateDeNaissance
	 */
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete adresse
	 */
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pAdresse la nouvelle valeur pour l'attribut adresse
	 */
	public void setAdresse(String pAdresse) {
		if (pAdresse == null || pAdresse.trim().isEmpty()) {
			this.adresse = null;
		} else {
			this.adresse = pAdresse;
		}
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete telephone
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pTelephone la nouvelle valeur pour l'attribut telephone
	 */
	public void setTelephone(String pTelephone) {
		if (pTelephone == null || pTelephone.trim().isEmpty()) {
			this.telephone = null;
		} else {
			this.telephone = pTelephone;
		}
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete codePostal
	 */
	public Integer getCodePostal() {
		return this.codePostal;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param codePostal la nouvelle valeur pour l'attribut codePostal
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Recupere la valeur de l'attribut.
	 *
	 * @return la propriete comptes
	 */
	public Set<CompteEntity> getComptes() {
		return this.comptes;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param comptes la nouvelle valeur pour l'attribut comptes
	 */
	public void setComptes(Set<CompteEntity> comptes) {
		this.comptes = comptes;
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();
		var parent = super.toString();
		parent = parent.substring(0, parent.length() - 1);
		sb.append(parent);
		sb.append(",sex=");
		sb.append(this.getSex());
		sb.append(",nom=");
		sb.append(this.getNom());
		sb.append(",prenom=");
		sb.append(this.getPrenom());
		sb.append(",email=");
		sb.append(this.getEmail());
		sb.append(",adresse=");
		sb.append(this.getAdresse());
		sb.append(",Telephone=");
		sb.append(this.getTelephone());
		sb.append(",CodePostal=");
		sb.append(this.getCodePostal());
		sb.append(",DateNaissance=");
		sb.append(this.getDateDeNaissance());
		var cpts = this.getComptes();
		if (cpts != null && !cpts.isEmpty()) {
			sb.append(",comptes=");
			for (CompteEntity cpt : cpts) {
				sb.append(cpt.getId()).append(',');
			}
			sb.delete(sb.length() - 1, sb.length());
		}
		sb.append("}");
		return sb.toString();
	}

}
