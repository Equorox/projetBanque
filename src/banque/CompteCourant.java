package banque;

public class CompteCourant extends Compte {

	public CompteCourant(int num, int agence, Client client, double solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);
		// TODO Auto-generated constructor stub
	}
	
	public double getFraisTenue() {
		return 25;
	}
	
}
