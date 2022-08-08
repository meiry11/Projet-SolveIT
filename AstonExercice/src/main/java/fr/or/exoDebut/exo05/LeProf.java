package fr.exo05;

public class LeProf {
    public static void main(String[] args) {
        double[] tabNotes = {4.5, 8, 9, 10.5, -5, 15, 13, 17, 20, 25};

        for (int i = 0; i < tabNotes.length; i++) {
            double note = tabNotes[i];

            if (note >= 0 && note <= 4) {
                System.out.println(note + ": Catastrophique");
            } else if (note > 4 && note <= 10) {
                System.out.println(note + ": Insuffisant");
            } else if (note > 10 && note <= 14) {
                System.out.println(note + ": Peut mieux faire");
            } else if (note > 14 && note <= 17) {
                System.out.println(note + ": Bien");
            } else if (note > 17 && note <= 20) {
                System.out.println(note + ": Excellent");
            } else {
                System.out.println(note + ": La note n'est pas comprise entre 0 et 20 !");
            }
        }
    }
}
