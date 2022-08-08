// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.web.dto.out;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Map;

import com.banque.entity.impl.UtilisateurEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

/**
 * DTO pour l'utilisateur en sortie.
 */
public class UtilisateurDtoOut extends AbstractDtoOut {
	private static final long serialVersionUID = 1L;

	private String email;
	private String nom;
	private String prenom;
	private Boolean sex;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime derniereConnection;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dateDeNaissance;
	private String adresse;
	private String telephone;
	private Integer codePostal;

	/**
	 * Constructor of the object.
	 */
	public UtilisateurDtoOut() {
		super();
	}

	/**
	 * Constructor of the object.
	 */
	public UtilisateurDtoOut(UtilisateurEntity pEntity) {
		super(pEntity);
		this.setAdresse(pEntity.getAdresse());
		this.setCodePostal(pEntity.getCodePostal());
		this.setDateDeNaissance(pEntity.getDateDeNaissance());
		var dc = pEntity.getDerniereConnectionDate();
		if (dc != null) {
			var tc = pEntity.getDerniereConnectionHeure();
			var ldtc = LocalDateTime.of(dc, tc);
			this.setDerniereConnection(ldtc);
		}
		this.setEmail(pEntity.getEmail());
		this.setNom(pEntity.getNom());
		// Ne pas faire
		// setPassword(pEntity.getPassword());
		this.setPrenom(pEntity.getPrenom());
		this.setSex(pEntity.getSex());
		this.setTelephone(pEntity.getTelephone());
	}

	public UtilisateurDtoOut(Map<String, ?> pMap) {
		super();
		if (pMap.get("id") != null) {
			this.setId((Integer) pMap.get("id"));
		}
		this.setAdresse((String) pMap.get("adresse"));
		this.setCodePostal((Integer) pMap.get("codePostal"));
		this.setEmail((String) pMap.get("email"));
		this.setNom((String) pMap.get("nom"));
		this.setPrenom((String) pMap.get("prenom"));
		this.setTelephone((String) pMap.get("telephone"));
		this.setSex((Boolean) pMap.get("sex"));

		if (pMap.get("derniereConnection") != null) {
			@SuppressWarnings("unchecked")
			var o = (List<Integer>) pMap.get("derniereConnection");
			// [2019, 3, 2, 15, 17, 28]
			this.setDerniereConnection(
					LocalDateTime.of(o.get(0), Month.of(o.get(1)), o.get(2), o.get(3), o.get(4), o.get(5), 0));
		}

		if (pMap.get("dateDeNaissance") != null) {
			// [2019, 3, 2]
			@SuppressWarnings("unchecked")
			var o = (List<Integer>) pMap.get("dateDeNaissance");
			if (o != null) {
				this.setDateDeNaissance(LocalDate.of(o.get(0), Month.of(o.get(1)), o.get(2)));
			}
		}
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut email.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pEmail la nouvelle valeur de l'attribut.
	 */
	public void setEmail(String pEmail) {
		this.email = pEmail;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut nom.
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pNom la nouvelle valeur de l'attribut.
	 */
	public void setNom(String pNom) {
		this.nom = pNom;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut prenom.
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pPrenom la nouvelle valeur de l'attribut.
	 */
	public void setPrenom(String pPrenom) {
		this.prenom = pPrenom;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut sex.
	 */
	public Boolean getSex() {
		return this.sex;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pSex la nouvelle valeur de l'attribut.
	 */
	public void setSex(Boolean pSex) {
		this.sex = pSex;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut derniereConnection.
	 */
	public LocalDateTime getDerniereConnection() {
		return this.derniereConnection;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pDerniereConnection la nouvelle valeur de l'attribut.
	 */
	public void setDerniereConnection(LocalDateTime pDerniereConnection) {
		this.derniereConnection = pDerniereConnection;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut dateDeNaissance.
	 */
	public LocalDate getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pDateDeNaissance la nouvelle valeur de l'attribut.
	 */
	public void setDateDeNaissance(LocalDate pDateDeNaissance) {
		this.dateDeNaissance = pDateDeNaissance;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut adresse.
	 */
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pAdresse la nouvelle valeur de l'attribut.
	 */
	public void setAdresse(String pAdresse) {
		this.adresse = pAdresse;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut telephone.
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pTelephone la nouvelle valeur de l'attribut.
	 */
	public void setTelephone(String pTelephone) {
		this.telephone = pTelephone;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut codePostal.
	 */
	public Integer getCodePostal() {
		return this.codePostal;
	}

	/**
	 * Modifie la valeur de l'attribut.
	 *
	 * @param pCodePostal la nouvelle valeur de l'attribut.
	 */
	public void setCodePostal(Integer pCodePostal) {
		this.codePostal = pCodePostal;
	}

	/**
	 * Récupère la valeur de l'attribut.
	 *
	 * @return la valeur de l'attribut serialversionuid.
	 */
	public static long getSerialversionuid() {
		return UtilisateurDtoOut.serialVersionUID;
	}

}
