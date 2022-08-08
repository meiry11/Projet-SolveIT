package fr.exemple.factory;

import fr.exemple.entity.Guitare;
import fr.exemple.entity.Instrument;
import fr.exemple.entity.Piano;

/**
 * Factory qui a pour role d instancier des instruments
 * @author roumaissa
 */
public class InstrumentFactory {

    public static Instrument getGuitare(){
        return new Guitare();
    }

    public static Instrument getGuitare(String model){
        return new Guitare(model);
    }

    public static Instrument getPiano(){
        return new Piano();
    }

    public static Instrument getPiano(String model){
        return new Piano(model);
    }
}
