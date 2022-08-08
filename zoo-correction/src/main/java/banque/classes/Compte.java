package banque.classes;

import banque.interfaces.ICompte;
import org.w3c.dom.ranges.RangeException;

import java.util.Objects;

public class Compte implements ICompte {

    protected double solde;
    protected int numero;

    public Compte(double solde, int numero) throws Exception {
        this.setSolde(solde);
        this.setNumero(numero);
    }

    public double getSolde() {
        return solde;
    }

    private void setSolde(double solde) throws Exception {
        if(solde < 0) throw new Exception("un solde ne peut être négatif");
        this.solde = solde;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws Exception {
        if(Integer.toString(numero).length() > 9 || Integer.toString(numero).length() < 5) {
            throw new Exception("la taille du numero de compte doit être comprise entre 5 et 10 chiffres");
        }
        this.numero = numero;
    }

    public void ajouter(double montant) {
        this.solde += montant;
    }

    public void retirer(double montant) throws Exception {
        this.solde -= montant;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "solde=" + solde +
                ", numero=" + numero +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return Double.compare(compte.solde, solde) == 0 && numero == compte.numero;
    }

}


