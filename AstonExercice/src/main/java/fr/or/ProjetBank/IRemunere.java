package fr.or.ProjetBank;

public interface IRemunere  extends ICompte{
    public double calculerInterets();
    public void verserInterets();
    public double getTaux();
    public void setTaux(double unTaux);
}
