package aston.correction.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue(value = "S")
public class Stagiaire extends Personne {
	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate")
	private Date dtNaissance;
	@ManyToOne
	@JoinColumn(name="formateur_id")
	private Formateur formateur;

	public Stagiaire() {
		super();
	}

	public Stagiaire(Civilite civilite, String nom, String prenom, String email, Date dtNaissance) {
		super(civilite, nom, prenom, email);
		this.dtNaissance = dtNaissance;
	}

	public Stagiaire(Long id, Civilite civilite, String nom, String prenom, String email, Date dtNaissance) {
		super(id, civilite, nom, prenom, email);
		this.dtNaissance = dtNaissance;
	}

	public Date getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(Date dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

}
