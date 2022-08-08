package fr.solveit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ville")
public class Ville implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @Column
    private String libelle;
    @ManyToOne
    @JoinColumn(name="departement_id")
    private Departement departement;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Utilisateur> utilisateursNaissance = new ArrayList<Utilisateur>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Utilisateur> utilisateursResidance= new ArrayList<Utilisateur>();

    public Ville() {
    }

    public Ville(Integer id, String libelle, Departement departement) {
        this.id = id;
        this.libelle = libelle;
        this.departement = departement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
