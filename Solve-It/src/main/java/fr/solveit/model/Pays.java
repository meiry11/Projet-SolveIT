package fr.solveit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pays")
public class Pays implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String libelle;
    @Column
    private String abv;

    @OneToMany(mappedBy = "pays", fetch = FetchType.LAZY)
    private List<Departement> departements = new ArrayList<Departement>();

    public Pays() {
    }

    public Pays(String libelle, String abv) {
        this.libelle = libelle;
        this.abv = abv;
    }

    public Integer getId() {
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

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }
}
