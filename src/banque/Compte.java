package banque;

import java.util.*;

public class Compte {
	
	private static Scanner sc = new Scanner(System.in);
	
	protected long idCompte;
	protected int agence;
	protected Client client;
	protected double solde;
	protected boolean decouvertAutorise;
	protected static ArrayList<Long> listeIdComptes = new ArrayList<>();
	
	public Compte(int agence, Client client, double solde, boolean decouvertAutorise) {
		boolean nouveauId = false;
		Random r = new Random();
		long number = 10000000000L + (long)(r.nextDouble() * 999999999L);
		while (!nouveauId) {
			nouveauId = true;
			number = 10000000000L + (long)(r.nextDouble() * 999999999L);
			for (long code : listeIdComptes) {
				if (number == code) {
					nouveauId = false;
				}
			}
		}
		this.idCompte = number;
		this.agence = agence;
		this.client = client;
		this.solde = solde;
		this.decouvertAutorise = decouvertAutorise;
	}
	
	public long getIdCompte() {
		return this.idCompte;
	}
	
	public int getAgence() {
		return this.agence;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public double getSolde() {
		return this.solde;
	}
	
	public boolean getDecouvert() {
		return this.decouvertAutorise;
	}
	
	public static void instanceCompte() {
		System.out.printf("Entrez l'id de l'agence concernée : ");
		int agence = sc.nextInt();
		
	}
	
}
