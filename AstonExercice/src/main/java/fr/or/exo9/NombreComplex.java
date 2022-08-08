package fr.or.exo9;

public class NombreComplex {
    private int partieReelle;

    private int partieImaginaire;

    public NombreComplex() {
    }

    public NombreComplex(int partieReelle, int partieImaginaire) {
        this.partieReelle = partieReelle;
        this.partieImaginaire = partieImaginaire;
    }

    public int getPartieReelle() {
        return partieReelle;
    }

    public void setPartieReelle(int partieReelle) {
        this.partieReelle = partieReelle;
    }

    public int getPartieImaginaire() {
        return partieImaginaire;
    }

    public void setPartieImaginaire(int partieImaginaire) {
        this.partieImaginaire = partieImaginaire;
    }

    public void claculSomme(NombreComplex br){
        System.out.println("La somme est : " + (br.getPartieReelle()+this.partieReelle)+" + "+(br.getPartieImaginaire()+this.partieImaginaire)+" i");
    }
}
