package fr.or.zoo;

public interface IAnimal {
    public void manger();
    public void dormir();
    public void setVoler(Boolean bool);
    public void setMarcher(Boolean bool);
    public void setNager(Boolean bool);

    public boolean getVoler();
    public boolean getNager();
    public boolean getMarcher();
}
