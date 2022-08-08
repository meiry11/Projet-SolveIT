package fr.solveit.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AbsenceId implements Serializable {

    @ManyToOne
    @JoinColumn(name="FeuilleEmargement_num")
    private FeuilleEmargement feuilleEmargement;
    @ManyToOne
    @JoinColumn(name = "stagiaire_num_secu")
    private Stagiaire stagiaire;

    public AbsenceId() {
    }

    public AbsenceId(FeuilleEmargement feuilleEmargement, Stagiaire stagiaire) {
        this.feuilleEmargement = feuilleEmargement;
        this.stagiaire = stagiaire;
    }

    public FeuilleEmargement getFeuilleEmargement() {
        return feuilleEmargement;
    }

    public void setFeuilleEmargement(FeuilleEmargement feuilleEmargement) {
        this.feuilleEmargement = feuilleEmargement;
    }

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbsenceId absenceId = (AbsenceId) o;
        return feuilleEmargement.equals(absenceId.feuilleEmargement) && stagiaire.equals(absenceId.stagiaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feuilleEmargement, stagiaire);
    }
}
