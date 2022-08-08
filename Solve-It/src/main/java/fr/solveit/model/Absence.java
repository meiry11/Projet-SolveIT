package fr.solveit.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "absence")
public class Absence  implements Serializable {
    @EmbeddedId
    AbsenceId absenceId;
/*    @ManyToOne
    @JoinColumn(name="FeuilleEmargement_num")
    private FeuilleEmargement feuilleEmargement;
    @ManyToOne
    @JoinColumn(name = "stagiaire_num_secu")
    private Stagiaire stagiaire;*/

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
    @Column
    private boolean absent;
    @Column
    private boolean absence_justifie;

    public Absence() {
    }

    public Absence(FeuilleEmargement feuilleEmargement, Stagiaire stagiaire, Session session, boolean absent, boolean absenceJustifie) {
        this.absenceId.setFeuilleEmargement(feuilleEmargement);
        this.absenceId.setStagiaire(stagiaire);
        this.session = session;
        this.absent = absent;
        this.absence_justifie = absenceJustifie;
    }

    public AbsenceId getAbsenceId() {
        return absenceId;
    }

    public void setAbsenceId(AbsenceId absenceId) {
        this.absenceId = absenceId;
    }

    public boolean isAbsence_justifie() {
        return absence_justifie;
    }

    public void setAbsence_justifie(boolean absence_justifie) {
        this.absence_justifie = absence_justifie;
    }

    public FeuilleEmargement getFeuilleEmergement() {
        return absenceId.getFeuilleEmargement();
    }

    public void setFeuilleEmergement(FeuilleEmargement feuilleEmargement) {
        this.absenceId.setFeuilleEmargement(feuilleEmargement);
    }

    public Stagiaire getStagiaire() {
        return absenceId.getStagiaire();
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.absenceId.setStagiaire(stagiaire);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public boolean isAbsent() {
        return absent;
    }

    public void setAbsent(boolean absent) {
        this.absent = absent;
    }

    public boolean isAbsenceJustifie() {
        return absence_justifie;
    }

    public void setAbsenceJustifie(boolean absenceJustifie) {
        this.absence_justifie = absenceJustifie;
    }

    @Override
    public String toString() {
        return "Absence{" +
                "feuilleEmergement=" + getFeuilleEmergement() +
                ", stagiaire=" + getStagiaire() +
                ", session=" + session +
                ", absent=" + absent +
                ", absenceJustifie=" + absence_justifie +
                '}';
    }
}
