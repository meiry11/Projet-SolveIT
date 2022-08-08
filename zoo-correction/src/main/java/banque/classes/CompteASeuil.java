package banque.classes;

import banque.interfaces.ICompteASeuil;

public class CompteASeuil extends Compte implements ICompteASeuil {

    private double seuil;

    public CompteASeuil(double seuil, double solde, int numero) throws Exception {
        super(solde, numero);
        this.setSeuil(seuil);
    }

    public double getSeuil() {
        return seuil;
    }

    public void setSeuil(double seuil) {
        this.seuil = seuil;
    }

    @Override
    public void retirer(double montant) throws Exception {
        if(this.solde - montant < this.seuil) throw new Exception("le retrait dépasse le plafond");
        this.solde -= montant;
    }

    @Override
    public String toString() {
        return "CompteASeuil{" +
                "solde=" + solde +
                ", numero=" + numero +
                '}';
    }
}
