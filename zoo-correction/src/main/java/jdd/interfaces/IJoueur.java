package jdd.interfaces;

public interface IJoueur {
    public String getNom();
    public int getScore();
    public void jouer(IGobelet gobelet);
    public void afficherScore();
}
