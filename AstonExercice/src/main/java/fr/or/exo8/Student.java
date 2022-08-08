package fr.or.exo8;

public class Student {
    private String nom;
    private int[] notes;

    public Student() {
    }

    public Student(String nom, int[] notes) {
        this.nom = nom;
        this.notes = notes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int[] getNotes() {
        return notes;
    }

    public void setNotes(int[] notes) {
        this.notes = notes;
    }

    public float calcMoyenne(){
        float resul=0;
        for(int i=0;i<notes.length;i++){
            resul+=notes[i];
        }

        return (resul/notes.length);
    }

    public void show(){

        System.out.println("L'étudiant "+nom+" a eu la moyenne  "+calcMoyenne());

    }
}
