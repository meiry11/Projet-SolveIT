package fr.solveit.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/***
 * Classe stagiaire qui etends de utilisateur
 * @author roumaissa
 */
@Entity
@DiscriminatorValue(value = "S")
//@JsonDeserialize(as = Stagiaire.class)
//@JsonIgnoreProperties
public class Stagiaire extends Utilisateur implements Serializable {
    /**
     * Diplome du stagiaire
     */
    @Column
    private String diplome;
    /**
     * Niveau du stagiaire avant cette formation
     */
    @Column
    private String niveau_entree;
    /**
     * Diffuculte phisique ou mental du stagiaire
     */
    @Column
    private boolean difficulte;
    /**
     * etat de santé du stagiaire
     */
    @Column
    private boolean handicape;
    /**
     * habite à DomTom ou pas
     */
    @Column
    private boolean domtom;
    /**
     * situation du stagiare
     */
    @Column
    private String situation;
    /**
     * nombre de travailleur à la maison
     */
    @Column
    private int nbr_travailleur;
    /**
     * permet de savoir si le stagiaire à des enfants
     */
    @Column
    private boolean enfant;
    /**
     * permet de savoir le type de logement du stagiaire
     */
    @Column
    private String logement;
    @Column
    private String parent_francais;
    @Column
    private boolean rique_perte_logement;
    @Column
    private String origine_formation;
    @Column
    private String transport;
    @Column
    private String allocation;
    //@Column
    //private Blob signature;
    @ManyToOne
    @JoinColumn(name="session_id")
    @JsonManagedReference
    private Session session;

    @ManyToOne
    @JoinColumn(name="hebergement_id")
    @JsonManagedReference
    private Hebergement hebergement;

    @ManyToOne
    @JoinColumn(name="situation_professionnelle_id")
    @JsonManagedReference
    private SituationProrfessionnelle situationProfessionnelle;


    public Stagiaire() {
        super();
    }

    public Stagiaire(String nom, String prenom, Date dateNaissance, String adresse, String civilite, Compte compte, Ville villeHabitation, Ville villeNaissance, String numSecu, String diplome, String niveau_entree, boolean difficulte, boolean handicape, boolean domtom, String situation, int nbr_travailleur, boolean enfant, String logement, String parent_francais, boolean rique_perte_logement, String origine_formation, String transport, String allocation, Session session, Hebergement hebergement, SituationProrfessionnelle situationProfessionnelle){//, Blob signature) {
        super(numSecu, nom, prenom, dateNaissance, adresse, civilite, compte, villeHabitation, villeNaissance);

        this.diplome = diplome;
        this.niveau_entree = niveau_entree;
        this.difficulte = difficulte;
        this.handicape = handicape;
        this.domtom = domtom;
        this.situation = situation;
        this.nbr_travailleur = nbr_travailleur;
        this.enfant = enfant;
        this.logement = logement;
        this.parent_francais = parent_francais;
        this.rique_perte_logement = rique_perte_logement;
        this.origine_formation = origine_formation;
        this.transport = transport;
        this.allocation = allocation;
        this.session = session;
        this.hebergement = hebergement;
        this.situationProfessionnelle = situationProfessionnelle;
        //77this.signature = signature;
    }

    public String getNumSecu() {
        return super.getNumSecu();
    }

    public void setNumSecu(String numSecu) {
        super.setNumSecu(numSecu);
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getNiveau_entree() {
        return niveau_entree;
    }

    public void setNiveau_entree(String niveau_entree) {
        this.niveau_entree = niveau_entree;
    }

    public boolean isDifficulte() {
        return difficulte;
    }

    public void setDifficulte(boolean difficulte) {
        this.difficulte = difficulte;
    }

    public boolean isHandicape() {
        return handicape;
    }

    public void setHandicape(boolean handicape) {
        this.handicape = handicape;
    }

    public boolean isDomtom() {
        return domtom;
    }

    public void setDomtom(boolean domtom) {
        this.domtom = domtom;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public int getNbr_travailleur() {
        return nbr_travailleur;
    }

    public void setNbr_travailleur(int nbr_travailleur) {
        this.nbr_travailleur = nbr_travailleur;
    }

    public boolean isEnfant() {
        return enfant;
    }

    public void setEnfant(boolean enfant) {
        this.enfant = enfant;
    }

    public String getLogement() {
        return logement;
    }

    public void setLogement(String logement) {
        this.logement = logement;
    }

    public String getParent_francais() {
        return parent_francais;
    }

    public void setParent_francais(String parent_francais) {
        this.parent_francais = parent_francais;
    }

    public boolean isRique_perte_logement() {
        return rique_perte_logement;
    }

    public void setRique_perte_logement(boolean rique_perte_logement) {
        this.rique_perte_logement = rique_perte_logement;
    }

    public String getOrigine_formation() {
        return origine_formation;
    }

    public void setOrigine_formation(String origine_formation) {
        this.origine_formation = origine_formation;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getAllocation() {
        return allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Hebergement getHebergement() {
        return hebergement;
    }

    public void setHebergement(Hebergement hebergement) {
        this.hebergement = hebergement;
    }

    public SituationProrfessionnelle getSituationProfessionnelle() {
        return situationProfessionnelle;
    }

    public void setSituationProfessionnelle(SituationProrfessionnelle situationProfessionnelle) {
        this.situationProfessionnelle = situationProfessionnelle;
    }


    /*public Blob getSignature() {
        return signature;
    }

    public void setSignature(Blob signature) {
        this.signature = signature;
    }*/

    @Override
    public String toString() {
        return "Stagiaire{" +
                "numSecu='" + super.getNumSecu() + '\'' +
                ", diplome='" + diplome + '\'' +
                ", niveau_entree=" + niveau_entree +
                ", difficulte=" + difficulte +
                ", handicape=" + handicape +
                ", domtom=" + domtom +
                ", situation='" + situation + '\'' +
                ", nbr_travailleur=" + nbr_travailleur +
                ", enfant=" + enfant +
                ", logement='" + logement + '\'' +
                ", parent_francais='" + parent_francais + '\'' +
                ", rique_perte_logement=" + rique_perte_logement +
                ", origine_formation='" + origine_formation + '\'' +
                ", transport='" + transport + '\'' +
                ", allocation='" + allocation + '\'' +
                ", session=" + session +
                ", hebergement=" + hebergement +
                ", situationProfessionnelle=" + situationProfessionnelle +
              //  ", signature=" + signature +
                '}';
    }
}
