package poo;

public class Demo implements IDemo  {

    private String nom;
    public int age;
    protected String prenom;

    public static int count = 0;
    public int count2 = 0;

    public Demo(String nom, int age, String prenom) throws Exception {
        this.setNom(nom);
        this.age = age;
        this.prenom = prenom;
        this.count2 ++;
        count ++;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
        if(nom.length() > 10) throw new Exception("message d'erreur");
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public void parler() {
        System.out.println("l'enfant parle");
    }

    public void parler(String test) {
        System.out.println("l'utilisateur " + test);
    }

    public void test() throws Exception {
        Enfant test = new Enfant("nom", 45, "prenom");
    }

    public void test2(Enfant param) {
        System.out.println(param);
    }
}


