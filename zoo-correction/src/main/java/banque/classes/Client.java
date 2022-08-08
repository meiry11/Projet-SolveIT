package banque.classes;

import banque.interfaces.IClient;

import java.util.ArrayList;
import java.util.List;

public class Client implements IClient {

    private String nom;
    private String prenom;
    private int age;
    private int numero;
    private List<Compte> tablCompte = new ArrayList<Compte>();

    public Client(String nom, String prenom, int age, int numero) {
        this.setPrenom(prenom);
       this.setNumero(numero);
       this.setNom(nom);
       this.setAge(age);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public void ajouterCompte(Compte compte) throws Exception {
        if(this.tablCompte.size() >= 5) throw new Exception("dejà 5 comptes");
        this.tablCompte.add(compte);
    }

    @Override
    public List<Compte> getComptes() {
        return this.tablCompte;
    }

    @Override
    public Compte getCompte(int numero) throws Exception {
        for ( Compte compte : tablCompte
             ) {
            if(compte.getNumero() == numero) {
                return compte;
            }
        }
        throw new Exception("compte introuvable");
    }
}
