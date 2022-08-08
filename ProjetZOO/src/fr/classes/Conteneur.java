package fr.classes;

import fr.interfaces.IConteneur;

import java.util.ArrayList;
import java.util.List;

public class Conteneur <T, U> implements IConteneur {

        private int quantite;
        List<U> liste = new ArrayList<>();


    public Conteneur(int quantite) {
        this.setQuantite(quantite);
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void ajouter(U param) throws Exception {
            if (liste.size() >= quantite) throw new Exception("Capacité maximale atteinte");
            this.liste.add(param);
        }

        public void addConteneur(IConteneur conteneur){

        }

    public List<U> getListe() {
        return liste;
    }
}
