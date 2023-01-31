package banque;

public class CompteCourant extends Compte {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7729404449574418356L;



	public CompteCourant(int agence, Client client, double solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);
		// TODO Auto-generated constructor stub
	}
	


	public double getFraisTenue() {
		return 25;
	}
	
}
