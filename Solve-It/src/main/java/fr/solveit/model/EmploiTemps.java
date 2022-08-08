package fr.solveit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name="emploiTemps")
public class EmploiTemps  implements Serializable {
 /*   @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "administration_num_secu")
    private Administration auteur;
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;*/
    @EmbeddedId
    EmploiTempsId emploiTempsId;

    @Column
    private String libelle;

    @Temporal(TemporalType.DATE)
    private Date date_fin_semaine;
    @Temporal(TemporalType.DATE)
    private Date date_edition;

    public EmploiTemps() {
    }

    public EmploiTemps(EmploiTempsId emploiTempsId, String libelle, Date date_fin_semaine, Date date_edition) {
        this.emploiTempsId = emploiTempsId;
        this.libelle = libelle;
        this.date_fin_semaine = date_fin_semaine;
        this.date_edition = date_edition;
    }

    public EmploiTempsId getEmploiTempsId() {
        return emploiTempsId;
    }

    public void setEmploiTempsId(EmploiTempsId emploiTempsId) {
        this.emploiTempsId = emploiTempsId;
    }

    public Administration getAuteur() {
        return emploiTempsId.getAuteur();
    }

    public void setAuteur(Administration auteur) {
        emploiTempsId.setAuteur(auteur);
    }

    public Session getSession() {
        return emploiTempsId.getSession();
    }

    public void setSession(Session session) {
        emploiTempsId.setSession(session);
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDate_debut_semaine() {
        return emploiTempsId.getDateDebutSemaine();
    }

    public void setDate_debut_semaine(Date date_debut_semaine) {
        emploiTempsId.setDateDebutSemaine( date_debut_semaine);
    }

    public Date getDate_fin_semaine() {
        return date_fin_semaine;
    }

    public void setDate_fin_semaine(Date date_fin_semaine) {
        this.date_fin_semaine = date_fin_semaine;
    }

    public Date getDate_edition() {
        return date_edition;
    }

    public void setDate_edition(Date date_edition) {
        this.date_edition = date_edition;
    }

    @Override
    public String toString() {
        return "EmploiTemps{" +
                ", administration=" + emploiTempsId.getAuteur() +
                ", session=" + emploiTempsId.getSession() +
                ", libelle='" + libelle + '\'' +
                ", date_debut_semaine=" + emploiTempsId.getDateDebutSemaine() +
                ", date_fin_semaine=" + date_fin_semaine +
                ", date_edition=" + date_edition +
                '}';
    }
}
