package fr.solveit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departement")
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String libelle;
    @Column
    private Integer num_departement;
    @Column
    private Integer code_commune;

    @ManyToOne
    @JoinColumn(name="pays_id")
    private Pays pays;

    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    private List<Ville> villes= new ArrayList<>();

    public Departement() {
    }

    public Departement(String libelle, Integer num_departement, Integer code_commune, Pays pays) {
        this.libelle = libelle;
        this.num_departement = num_departement;
        this.code_commune = code_commune;
        this.pays = pays;
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

    public int getNum_departement() {
        return num_departement;
    }

    public void setNum_departement(int num_departement) {
        this.num_departement = num_departement;
    }

    public int getCode_commune() {
        return code_commune;
    }

    public void setCode_commune(int code_commune) {
        this.code_commune = code_commune;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
}
