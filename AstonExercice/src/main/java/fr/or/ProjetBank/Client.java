package fr.or.ProjetBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Client implements IClient{
    /**
     * Nom du client
     */
    private String nom;
    /**
     * Prenom du client
     */
    private String prenom;
    /**
     * Age du Client
     */
    private int age;
    /**
     * Numero du Client
     */
    private int numero;
    /**
     * Le tableau des Comptes Client
     */
    private List<Compte> tabComptes;

    public Client() {
        this.tabComptes = new ArrayList<>();
    }

    public Client(String nom, String prenom, int age, int numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.numero = numero;
        this.tabComptes = new ArrayList<>();
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
    public List<Compte> getTabComptes() {
        return tabComptes;
    }


    @Override
    public Compte getCompte(int nuNUm){
        Compte result = null;
        for (Compte compte: tabComptes) {
            if(nuNUm == compte.getNumCompte())
                result = compte;
        }
        return result;
    }

    public void setTabComptes(List<Compte> tabComptes) {
        this.tabComptes = tabComptes;
    }

    @Override
    public void ajouterCompte(Compte compte) throws Exception {
        int i = tabComptes.size();

        if (i>5) throw new Exception("Vous avez deja 5 compte");
        else
            tabComptes.add(compte);
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", numero=" + numero +
                ", tabComptes=" + tabComptes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && numero == client.numero && Objects.equals(nom, client.nom) && Objects.equals(prenom, client.prenom) && Objects.equals(tabComptes, client.tabComptes);
    }

}
