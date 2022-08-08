package banque.classes;

import banque.interfaces.ICompteRemunere;

public class CompteRemunere extends Compte implements ICompteRemunere {

    private double taux;

    public CompteRemunere(double taux, double solde, int numero) throws Exception {
        super(solde, numero);
        this.setTaux(taux);
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) throws Exception {
        if(taux > 1 || taux < 0) throw new Exception("le taux doit être compris entre 0 et 1");
        this.taux = taux;
    }

    @Override
    public double calculerInteret() {
        return this.solde * this.taux;
    }

    @Override
    public void verserInteret() {
        this.solde += this.calculerInteret();
    }

    @Override
    public String toString() {
        return "CompteRemunere{" +
                "taux=" + taux +
                ", solde=" + solde +
                ", numero=" + numero +
                '}';
    }
}
