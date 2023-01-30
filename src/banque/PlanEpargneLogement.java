package banque;

public class PlanEpargneLogement extends Compte{

	public PlanEpargneLogement(int num, int agence, Client client, double solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);
		// TODO Auto-generated constructor stub
	}

	public double getFraisTenue() {
		return 25 + this.solde*(2.5/100);
	}		
	
}
