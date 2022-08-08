package fr.solveit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="feuille_emargement")
public class FeuilleEmargement  implements Serializable {
    @Id
    private String num;
    @Column
    private String intitule;
    @Column
    private String lieu;
    @Temporal(TemporalType.DATE)
    private Date date_emargement;
    @Temporal(TemporalType.DATE)
    private Date date_debut_formation;
    @Temporal(TemporalType.DATE)
    private Date date_fin_formation;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Absence> absences = new ArrayList<Absence>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Calendrier> calendriers = new ArrayList<Calendrier>();

    public FeuilleEmargement() {
    }

    public FeuilleEmargement(String num, String intitule, String lieu, Date date_emargement, Date date_debut_formation, Date date_fin_formation) {
        this.num = num;
        this.intitule = intitule;
        this.lieu = lieu;
        this.date_emargement = date_emargement;
        this.date_debut_formation = date_debut_formation;
        this.date_fin_formation = date_fin_formation;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate_emargement() {
        return date_emargement;
    }

    public void setDate_emargement(Date date_emargement) {
        this.date_emargement = date_emargement;
    }

    public Date getDate_debut_formation() {
        return date_debut_formation;
    }

    public void setDate_debut_formation(Date date_debut_formation) {
        this.date_debut_formation = date_debut_formation;
    }

    public Date getDate_fin_formation() {
        return date_fin_formation;
    }

    public void setDate_fin_formation(Date date_fin_formation) {
        this.date_fin_formation = date_fin_formation;
    }

    @Override
    public String toString() {
        return "FeuilleEmargement{" +
                "num='" + num + '\'' +
                ", intitule='" + intitule + '\'' +
                ", lieu='" + lieu + '\'' +
                ", date_emargement=" + date_emargement +
                ", date_debut_formation=" + date_debut_formation +
                ", date_fin_formation=" + date_fin_formation +
                '}';
    }
}
