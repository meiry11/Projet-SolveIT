package fr.or.ProjetBank;

import java.util.Objects;

public class Compte implements ICompte{
    /**
     * Indique le numero de compte
     */
    private int numCompte;
    /**
     * indique le solde du compte
     */
    private double solde;

    /**
     * Constructeur sans arguments
     */
    public Compte() {

    }

    /**
     * Constructeur avec arguments
     * @param numCompte
     * @param solde
     */
    public Compte(int numCompte, double solde) throws Exception{
        this.numCompte = numCompte;
        setSolde(solde);
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public double getSolde() {
        return solde;
    }

    private void setSolde(double solde) throws Exception {
        if(solde<0) throw new Exception("Votre negatif non acceptée");
        this.solde = solde;
    }

    /**
     * Ajoute un montant au solde
     * @param unMontant
     */
    @Override
    public void ajouter(double unMontant) {
        solde+=unMontant;
    }

    /**
     * retir un montant du solde
     * @param unMontant
     */
    @Override
    public void retirer(double unMontant) throws Exception  {
        if(solde-unMontant<0) throw  new Exception ("Votre solde est insuffisant");
        solde-=unMontant;

    }

    @Override
    public String toString() {
        return "Compte{" +
                "numCompte=" + numCompte +
                ", solde=" + solde +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return numCompte == compte.numCompte && Double.compare(compte.solde, solde) == 0;
    }

    public String addCommentaire(String m) throws Exception {
        if (m.length() == 0) throw new Exception("Commentaire Vide");
        if(m.length()>10) throw new Exception("Commentaire long");
        return m;
    }

}
