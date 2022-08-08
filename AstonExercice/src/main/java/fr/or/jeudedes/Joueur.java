package fr.or.jeudedes;

public class Joueur implements IJoueur{
    private String nom;
    private int score;

    public Joueur(String nom) {
        this.nom = nom;
        score = 0;
    }

    @Override
    public String get_nom() {
        return nom;
    }

    @Override
    public int get_score() {
        return score;
    }

    @Override
    public void jouer(Gobelet gobelet) throws Exception {
        gobelet.lancer();
        De de = gobelet.getDes()[gobelet.getValeur()-1];
        score = score+de.getValeur();

    }

    @Override
    public void afficher_score() {
        System.out.println("Le score du joueur est : "+score);
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", score=" + score +
                '}';
    }
}
