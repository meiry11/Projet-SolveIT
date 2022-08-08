package fr.or.ProjetBank;

public interface ICompteASeuil extends ICompte{
    public void retirer(double uneValeur) throws Exception ;
    public boolean verifier(double uneValeur);
    public double getSeuil();
    public void setSeuil(double unSeuil);
}
