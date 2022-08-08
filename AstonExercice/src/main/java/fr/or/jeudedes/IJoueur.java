package fr.or.jeudedes;

public interface IJoueur {
    public String get_nom();
    public int get_score();
    public void jouer(Gobelet gobelet) throws Exception;
    public void afficher_score();
}
