package fr.or.ProjetBank;

public class CompteASeuil extends Compte implements ICompteASeuil{
    private double seuil;

    public CompteASeuil() {
    }

    public CompteASeuil(int numCompte, double solde, double seuil) throws Exception {
        super(numCompte, solde);
        this.seuil = seuil;
    }

    public double getSeuil() {
        return seuil;
    }

    public void setSeuil(double seuil) {
        this.seuil = seuil;
    }

    @Override
    public String toString() {
        return "CompteASeuil{" +
                "seuil=" + seuil +
                '}';
    }

    @Override
    public boolean verifier(double uneValeur) {
        boolean reponse = false;

        if (getSolde() - uneValeur > seuil) {
            reponse = true;
        }
        return reponse;
    }
    @Override
    public void retirer(double uneValeur) throws Exception  {
        if (!verifier(uneValeur)) throw new Exception ("Depassement du plafond");
        super.retirer(uneValeur);
    }

}
