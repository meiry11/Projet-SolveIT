package fr.exo13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CentraleDeTri {
    public static void main(String[] args) {
        // En utilisant les tableaux
        int[] tab = { 12, 25, -5, 6, 5 };

        for(int num : tab) {
            // Pour chaque temperature du tableau (sauf la derniere)
            for(int index = 0; index < tab.length -1; index++) {
                // Si la temperature est plus grande que celle d'après
                if(tab[index] > tab[index+1]) {
                    // On inverse les places des deux temperatures
                    int temp = tab[index];
                    tab[index] = tab[index+1];
                    tab[index+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(tab));




        // En utilisant des listes
        /*
        List<Integer> tab = Arrays.asList(12,5,65,7,-7);

        // Par ordre croissant
        Collections.sort(tab);

        // Par ordre decroissant
        //Collections.sort(tab, Collections.reverseOrder());

        System.out.println(tab);
        */

    }
}
