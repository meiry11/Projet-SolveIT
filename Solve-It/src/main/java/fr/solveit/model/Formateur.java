package fr.solveit.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Formateur")
@DiscriminatorValue(value = "f")
public class Formateur extends Utilisateur implements Serializable {

    @ManyToOne
    @JoinColumn (name="Matiere_id")
    private Matiere matiere;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Calendrier> calendriers = new ArrayList<Calendrier>();


    public Formateur() {
        super();
    }

    public Formateur(String numSecu, String nom, String prenom, Date dateNaissance, String adresse, String civilite, Compte compte, Ville villeHabitation, Ville naissance,  Matiere matiere) {
        super(numSecu, nom, prenom, dateNaissance, adresse, civilite, compte, villeHabitation, naissance);
        super.setNumSecu(numSecu);
        this.matiere = matiere;
    }

    public String getNumSecu() {
        return super.getNumSecu();
    }

    public void setNumSecu(String numSecu) {
        super.setNumSecu(numSecu);
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }



    @Override
    public String toString() {
        return "Formateur{" +
                "num_secu='" + super.getNumSecu() + '\'' +
                "matiere='" + matiere + '\'' +
                '}'+ super.toString();
    }

}
