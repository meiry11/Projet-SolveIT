package fr.solveit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Matiere")
public class Matiere implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "libelle")
    private String libelle;

    @OneToMany(mappedBy = "matiere", fetch = FetchType.LAZY)
    List<Formateur> formateurs=new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    List<Calendrier> calendriers=new ArrayList<>();

    public Matiere() {
    }

    public Matiere(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
