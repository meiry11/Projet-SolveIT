package fr.or.ProjetBank;

public class CompteRemunere extends Compte implements IRemunere{
    private double taux;

    public CompteRemunere() {
    }

    public CompteRemunere(double taux) {
        this.taux = taux;
    }

    public CompteRemunere(int numCompte, double solde, double taux) throws Exception {
        super(numCompte, solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "CompteRemunere{" +
                "taux=" + taux +
                '}';
    }

    @Override
    public double calculerInterets() {
        return taux*super.getSolde();
    }

    @Override
    public void verserInterets() {
        super.ajouter(calculerInterets());
    }

    public void ajouter(double unMontant){
        super.ajouter(unMontant);
    }
    public void retirer(double unMontant) throws Exception  {
        super.retirer(unMontant);
    }
}
