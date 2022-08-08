package fr.or.exo5;

public class Appreciation {
    public static void main(String[] args) {
        float[] tableNote = {1,12,8,16,19};

        for(int i=0; i< tableNote.length;i++)
            System.out.println("Note : "+tableNote[i]+" --> " +Commentaire(tableNote[i]));
    }

    public static String Commentaire(Float note){

       if (note<=4)
            return "Catastrophe, il faut tout revoir";
        else if (note <=10) {
            return "Insuffisant";
        } else if (note <=14) {
            return "Peux mieux faire";
        }
        else if (note <= 17) {
            return "Bien";
        }
        else if (note <= 20) {
           return "Excellent, bon travail";
        }
        else
            return "Veuillez saisir une note valide";
    }
}
