package com.example.tp1.employedb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
@Entity
public class Employe {
	
	public static final String ID = "ID";
	public static final String NOM = "nom";
	public static final String PRENOM = "prenom";
	public static final String SALAIRE = "salaire";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private Date dateEmbauche;
	private Date dateLicenciement;
	private int salaire;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public Date getDateLicenciement() {
		return dateLicenciement;
	}
	public void setDateLicenciement(Date dateLicenciement) {
		this.dateLicenciement = dateLicenciement;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
}
