package fr.solveit.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "session")
public class Session implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String libelle ;
    @Temporal(TemporalType.DATE)
    private Date date_debut;
    @Temporal(TemporalType.DATE)
    private Date date_fin;

    @OneToMany(mappedBy = "session",fetch = FetchType.EAGER )
    @JsonBackReference(value = "Session")
    private List<Stagiaire> utilisateursNaissance = new ArrayList<Stagiaire>();

    @OneToMany(mappedBy = "emploiTempsId.session",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<EmploiTemps> emploiTemps = new ArrayList<EmploiTemps>();

    @OneToMany(mappedBy = "calendrierId.session",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Calendrier> calendriers = new ArrayList<Calendrier>();

    public Session() {
    }

    public Session(Integer id, String libelle, Date date_debut, Date date_fin) {
        this.id = id;
        this.libelle = libelle;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
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

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Stagiaire> getUtilisateursNaissance() {
        return utilisateursNaissance;
    }

    public void setUtilisateursNaissance(List<Stagiaire> utilisateursNaissance) {
        this.utilisateursNaissance = utilisateursNaissance;
    }

    public List<EmploiTemps> getEmploiTemps() {
        return emploiTemps;
    }

    public void setEmploiTemps(List<EmploiTemps> emploiTemps) {
        this.emploiTemps = emploiTemps;
    }

    public List<Calendrier> getCalendriers() {
        return calendriers;
    }

    public void setCalendriers(List<Calendrier> calendriers) {
        this.calendriers = calendriers;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
               /* ", utilisateursNaissance=" + utilisateursNaissance +
                ", emploiTemps=" + emploiTemps +
                ", calendriers=" + calendriers +*/
                '}';
    }
}
