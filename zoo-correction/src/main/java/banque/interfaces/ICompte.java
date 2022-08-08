package banque.interfaces;

public interface ICompte {
    public void ajouter(double montant);

    public void retirer(double montant) throws Exception;

}
