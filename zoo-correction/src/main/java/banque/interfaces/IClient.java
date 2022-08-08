package banque.interfaces;

import banque.classes.Compte;

import java.util.List;

public interface IClient {
    public void ajouterCompte(Compte compte) throws Exception;

    public List<Compte> getComptes();

    public Compte getCompte(int numero) throws Exception;
}
