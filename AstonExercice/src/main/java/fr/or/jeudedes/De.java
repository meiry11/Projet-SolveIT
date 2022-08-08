package fr.or.jeudedes;

import java.util.Random;

public class De implements IJouer{
    private int valeur;

    public De() {
        valeur=0;
    }

    public int getValeur() {
        return valeur;
    }

    public void lancer(){
        Random rd = new Random();
        valeur = rd.nextInt(6)+1;
    }
}
