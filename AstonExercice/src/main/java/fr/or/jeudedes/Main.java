package fr.or.jeudedes;

public class Main {
    public static void main(String[] args) {
        De de = new De();
        Gobelet gb = new Gobelet(2);
        try {
            Joueur joueur = new Joueur("JONE");
            Joueur joueur1 = new Joueur("TOM");
            Joueur joueur2 = new Joueur("EMILIE");
//            joueur.jouer(gb);
//            joueur.afficher_score();
//            joueur.jouer(gb);
//            joueur.afficher_score();
//            joueur.jouer(gb);
            Partie part = new Partie(3,10);
            part.initialiser(joueur);
            part.initialiser(joueur1);
            part.initialiser(joueur2);
            part.lancer();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
