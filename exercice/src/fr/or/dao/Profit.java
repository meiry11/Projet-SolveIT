package fr.or.dao;

import java.util.Scanner;

public class Profit {
    private float prixAchat;
    private float prixVente;

    public Profit() {
    }

    public float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    public float DemandeSomme(String message){
        Scanner sc = new Scanner(System.in);
        float reponse=0;

        do{
            System.out.println(message);
            reponse = sc.nextInt();
        }while(reponse < 0);


        return reponse;
    }

    public void CalculBenefice(){
        Float benefice = prixVente - prixAchat;

        if (benefice > 0){
            System.out.println("Felicitation vous avez gagne : "+ benefice);
        }
        else {
            System.out.println("Malheureusement vous avez perdu : "+Math.abs(benefice));
        }
    }
}
