package fr.solveit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.sql.Time;
@Entity
@Table(name = "calendrier")

public class Calendrier  implements Serializable {
  /*  @ManyToOne
    @JoinColumn(name="matiere_id")
    private Matiere matiere;
    @ManyToOne
    @JoinColumn(name="session_id")
    private Session session;*/
    @EmbeddedId
    private CalendrierId calendrierId;

    @Column
    private Time heure_debut;
    @Column
    private Time heure_fin;
    @Temporal(TemporalType.DATE)
    private Date date;
   /* @ManyToOne
    @JoinColumn(name = "formateur_numSecu")
    private Formateur formateur;
    @ManyToOne
    @JoinColumn(name="FeuilleEmargement_num")
    private FeuilleEmargement feuilleEmargement;

    @ManyToOne
    @JoinColumn(name = "administration_num_secu")
    private Administration auteur;*/



    public Calendrier() {
    }

    public Calendrier(CalendrierId calendrierId, Time heure_debut, Time heure_fin, Date date) {
        this.calendrierId = calendrierId;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.date = date;
    }

    public CalendrierId getCalendrierId() {
        return calendrierId;
    }

    public void setCalendrierId(CalendrierId calendrierId) {
        this.calendrierId = calendrierId;
    }

    public Matiere getMatiere() {
        return calendrierId.getMatiere();
    }

    public void setMatiere(Matiere matiere) {
        calendrierId.setMatiere(matiere);
    }

    public Session getSession() {
        return calendrierId.getSession();
    }

    public void setSession(Session session) {
        calendrierId.setSession(session);
    }

    public Time getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(Time heure_debut) {
        this.heure_debut = heure_debut;
    }

    public Time getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(Time heure_fin) {
        this.heure_fin = heure_fin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Formateur getFormateur() {
        return calendrierId.getFormateur();
    }

    public void setFormateur(Formateur formateur) {
        calendrierId.setFormateur(formateur);
    }

    public FeuilleEmargement getFeuilleEmargement() {
        return calendrierId.getFeuilleEmargement();
    }

    public void setFeuilleEmargement(FeuilleEmargement feuilleEmargement) {
        calendrierId.setFeuilleEmargement(feuilleEmargement);
    }

    public Administration getAuteur() {
        return calendrierId.getAuteur();
    }

    public void setAuteur(Administration auteur) {
        calendrierId.setAuteur(auteur);
    }

    @Override
    public String toString() {
        return "Calendrier{" +
                "matiere=" + calendrierId.getMatiere() +
                ", session=" + calendrierId.getSession() +
                ", heure_debut=" + heure_debut +
                ", heure_fin=" + heure_fin +
                ", date=" + date +
                ", formateur=" + calendrierId.getFormateur() +
                ", feuilleEmargement=" + calendrierId.getFeuilleEmargement() +
                ", administration=" + calendrierId.getAuteur() +
                '}';
    }
}
