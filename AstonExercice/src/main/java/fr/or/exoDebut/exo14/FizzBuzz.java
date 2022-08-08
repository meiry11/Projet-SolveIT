package fr.exo14;


import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        int nombre = demanderNOmbre();
     // Methode 1
        for (int i = 1; i <= nombre; i++) {
            if (i % 15 == 0) {
                System.out.println("FIZZBUZZ");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            }else if(i % 3 == 0) {
                System.out.println("FIZZ");
            }else {
                System.out.println(i);
            }
        }


        // Autre methode ternaire
//        for (int i = 1; i <= nombre; i++) {
//            System.out.println(i % 15 == 0 ? "FIZZBUZZ" : i % 5 == 0 ? "BUZZ" : i % 3 == 0 ? "FIZZ" : i );
//        }

    }

    public static int demanderNOmbre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre: ");
        return scanner.nextInt();
    }
}

