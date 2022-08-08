package fr.solveit.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CalendrierId implements Serializable {
    private static final long serialVersionUID = -7657830460147523710L;
    @ManyToOne
    @JoinColumn(name="matiere_id")
    private Matiere matiere;
    @ManyToOne
    @JoinColumn(name="session_id")
    @JsonManagedReference
    private Session session;
    @ManyToOne
    @JoinColumn(name = "formateur_num_secu")
    private Formateur formateur;
    @ManyToOne
    @JoinColumn(name="FeuilleEmargement_num")
    private FeuilleEmargement feuilleEmargement;

    @ManyToOne
    @JoinColumn(name = "administration_num_secu")
    private Administration auteur;

    public CalendrierId() {
    }

    public CalendrierId(Matiere matiere, Session session, Formateur formateur, FeuilleEmargement feuilleEmargement, Administration auteur) {
        this.matiere = matiere;
        this.session = session;
        this.formateur = formateur;
        this.feuilleEmargement = feuilleEmargement;
        this.auteur = auteur;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public FeuilleEmargement getFeuilleEmargement() {
        return feuilleEmargement;
    }

    public void setFeuilleEmargement(FeuilleEmargement feuilleEmargement) {
        this.feuilleEmargement = feuilleEmargement;
    }

    public Administration getAuteur() {
        return auteur;
    }

    public void setAuteur(Administration auteur) {
        this.auteur = auteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendrierId that = (CalendrierId) o;
        return matiere.equals(that.matiere) && session.equals(that.session) && formateur.equals(that.formateur) && feuilleEmargement.equals(that.feuilleEmargement) && auteur.equals(that.auteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matiere, session, formateur, feuilleEmargement, auteur);
    }

    @Override
    public String toString() {
        return "CalendrierId{" +
                "matiere=" + matiere +
                ", session=" + session +
                ", formateur=" + formateur +
                ", feuilleEmargement=" + feuilleEmargement +
                ", auteur=" + auteur +
                '}';
    }
}
