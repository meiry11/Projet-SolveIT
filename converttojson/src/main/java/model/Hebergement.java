package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Hebergement implements Serializable {

    private int id;

    private String libelle;

    private String abrv;


    private List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();

    public Hebergement() {
    }

    public Hebergement(int id, String libelle, String abrv) {
        this.id = id;
        this.libelle = libelle;
        this.abrv = abrv;
    }

    public int getId() {return id; }

    public void setId(int id) {this.id = id; }

    public String getLibelle() {return libelle; }

    public void setLibelle(String libelle) {this.libelle = libelle; }

    public String getAbrv() {return abrv; }

    public void setAbrv(String abrv) {this.abrv = abrv; }


    @Override
    public String toString() {
        return "Hbergement{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", abrv='" + abrv + '\'' +
                '}';
    }
}
