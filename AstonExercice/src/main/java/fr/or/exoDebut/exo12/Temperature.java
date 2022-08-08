package fr.exo12;


public class Temperature {
    public static void main(String[] args) {
        int[] temperatures = {12, 25, -5, -12, 6, 3, -3, 5};
        int procheZero = temperatures[0];

        for (int temperature : temperatures
        ) {
            if (temperature < 0) {
                if (Math.abs(temperature) <= Math.abs(procheZero)) {
                    procheZero = temperature;
                }
            } else if (temperature < Math.abs(procheZero)) {
                procheZero = temperature;
            }
        }
        System.out.println(procheZero);
    }
}