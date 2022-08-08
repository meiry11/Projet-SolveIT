package fr.solveit.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "administration")
@DiscriminatorValue(value = "a")
public class Administration extends Utilisateur{

    @Column
    private String  status;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Calendrier> calendriers=new ArrayList<Calendrier>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<EmploiTemps> emploiTemps=new ArrayList<EmploiTemps>();


    public Administration() {
        super();
    }

    public Administration(String nom, String prenom, Date dateNaissance, String adresse, String civilite, Compte compte, Ville villeHabitation, Ville villeNaissance, String num_secu, String status) {
        super(num_secu, nom, prenom, dateNaissance, adresse, civilite, compte, villeHabitation, villeNaissance);
        super.setNumSecu(num_secu);
        this.status = status;
    }

    public String getNum_secu() {
        return super.getNumSecu();
    }

    public void setNum_secu(String num_secu) {
        super.setNumSecu(num_secu);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
