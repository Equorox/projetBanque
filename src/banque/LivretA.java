package banque;

public class LivretA extends Compte{

	public LivretA(int num, int agence, Client client, double solde, boolean decouvertAutorise) {
		super(agence, client, solde, decouvertAutorise);
		// TODO Auto-generated constructor stub
	}
	
	public double getFraisTenue() {
		return 25 + this.solde*(10/100);
	}	
	
}
