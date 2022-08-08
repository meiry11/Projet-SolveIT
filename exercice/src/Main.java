import fr.or.dao.Profit;

public class Main {
    public static void main(String[] args) {
        Profit pr = new Profit();

        pr.setPrixAchat(pr.DemandeSomme("Veuillez saisir le prix d'achat : "));
        pr.setPrixVente(pr.DemandeSomme("Veuillez saisir le prix de vente : "));

        pr.CalculBenefice();
    }
}

