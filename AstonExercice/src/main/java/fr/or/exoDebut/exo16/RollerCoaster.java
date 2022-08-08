package fr.exo16;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RollerCoaster {
    public static void main(String[] args) {
        int nbPlaces = 5;
        int nbTours = 3;
        List<Integer> file = new ArrayList<>(Arrays.asList(1,1,1,1));
        int benefice = 0;

        // Pour chaque tour du manege
        for(int index = 0; index < nbTours; index++) {
            // Definir un nombre de place restante en fonction du nombre de place dans le manege
            int placesRestantes = nbPlaces;
            // Definir une liste vide qui stockera les groupes qui sont rentrés dans le manege
            List<Integer> dansManege = new ArrayList<>();

            //Tant qu'il reste des gens dans la file
            //Et qu'il reste de la place dans le manege
            while(file.size() > 0 && placesRestantes > 0) {
                //Faire rentrer le groupe dans le manege
                dansManege.add(file.get(0));
                // Encaisser l'argent
                benefice += file.get(0);
                // Enelever les places prises par le groupe
                placesRestantes -= file.get(0);
                // Supprimer le groupe de la file d'attente (le groupe est dans le manege, on vide la file)
                file.remove(0); // Eviter qu'un groupe rentre deux fois dans le manege
            }

            //Remettre les groupes du manege dans la file d'attente
            file.addAll(dansManege);
        }

        //Afficher les benefices
        System.out.println(benefice);

    }
}
