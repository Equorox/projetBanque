package banque;

public class PlanEpargneLogement extends Compte{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8235861289797563247L;

	public PlanEpargneLogement(int agence, Client client, double solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);
		// TODO Auto-generated constructor stub
	}

	public double getFraisTenue() {
		return 25 + this.solde*(2.5/100);
	}		
	
}
