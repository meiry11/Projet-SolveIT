package fr.solveit.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class EmploiTempsId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "administration_num_secu")
    private Administration auteur;
    @ManyToOne
    @JoinColumn(name = "session_id")
    @JsonManagedReference
    private Session session;

    @Temporal(TemporalType.DATE)
    private Date date_debut_semaine;

    public EmploiTempsId() {
    }

    public EmploiTempsId(Date date_debut_semaine, Administration auteur, Session session) {
        this.date_debut_semaine = date_debut_semaine;
        this.auteur = auteur;
        this.session = session;
    }

    public Date getDateDebutSemaine() {
        return date_debut_semaine;
    }

    public void setDateDebutSemaine(Date date_debut_semaine) {
        this.date_debut_semaine = date_debut_semaine;
    }

    public Administration getAuteur() {
        return auteur;
    }

    public void setAuteur(Administration auteur) {
        this.auteur = auteur;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "EmploiTempsId{" +
                "DateDebutSemaine=" + getDateDebutSemaine() +
                ", auteur=" + auteur +
                ", session=" + session +
                '}';
    }
}
