package org.exemple.model;

import java.io.Serializable;
import java.sql.Date;

public class Employe implements Serializable {
    public static final String ID="ID";
    public static final String NOM="nom";
    public static final String PRENOM="prenom";
    public static final String SALAIRE="salaire";

    private int id;
    private String nom;
    private String prénom;
    private Date dateEmbauche;
    private Date date_licenciement;
    private int salaire;

    public Employe() {
    }

    public Employe(int id,String nom, String prénom, Date dateEmbauche, Date date_licenciement, int salaire) {
        this.id=id;
        this.nom = nom;
        this.prénom = prénom;
        this.dateEmbauche = dateEmbauche;
        this.date_licenciement = date_licenciement;
        this.salaire = salaire;
    }

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

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Date getDate_licenciement() {
        return date_licenciement;
    }

    public void setDate_licenciement(Date date_licenciement) {
        this.date_licenciement = date_licenciement;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
}
