package jdd.classes;

import jdd.interfaces.IDe;

import java.util.Random;

public class De implements IDe {

    private int valeur;

    public De() {
        this.valeur = 0;
    }

    private void setValeur(int valeur) {
        this.valeur = valeur;
    }

    @Override
    public int getValeur() {
        System.out.println("valeur du de : " + this.valeur);
        return this.valeur;
    }

    @Override
    public void lancer() {
        Random random = new Random();

       this.valeur = random.nextInt((6 - 1) + 1)+ 1;
    }
}
