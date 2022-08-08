package fr.or.tools;

import java.util.Scanner;

public class Tools {
    static Scanner sc =new Scanner(System.in);

    public static int saisirNombre(String message){
        System.out.println(message);
        return Integer.valueOf(sc.nextLine());
    }

    public  static String saisirString(String message){
        System.out.println(message);
        return sc.nextLine();
    }
}
