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
	protected static ArrayList<Compte> listeCompte = new ArrayList<>();
	
	
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
	
	public String toString() {
		String string = String.format("Id Compte : %d%nAgence : %d%nClient : %s%nSolde : %d%nDecouvert Autorisé : %s", this.idCompte, this.agence, this.client.getNom(), this.solde, this.decouvertAutorise);
		return string;
	}
	
	public static void instanceCompte() {
		Agence.afficherAgences();
		System.out.printf("Entrez l'id de l'agence concernée : ");
		int agence = sc.nextInt();
		System.out.printf("%nEntrez l'id du client concerné : ");
		Client client = Client.getClientFromId(sc.nextInt());
		
		if (client.getListeCompte().size()>3) {
			System.out.println("Ce client a déjà 3 comptes");
			return;
		}
		
		System.out.printf("%nEntrez le solde de départ du compte");
		double solde = sc.nextDouble();
		System.out.printf("%nLe découvert est-il autorisé sur ce compte ?%n1. Oui%n2. Non");
		int choix = Menu.choix();
		boolean decouvert = false;
		switch (choix) {
		case 1:
			decouvert = true;
			break;
		default:
			break;
		}
		System.out.printf("%nQuel type de compte souhaitez vous ouvrir ?%n1. Compte courant%n2. Livret A%n3. Epargne logement");
		choix = Menu.choix();
			switch (choix) {
			case 1:
				CompteCourant compte = new CompteCourant(agence, client, solde, decouvert);
				client.getListeCompte().add(compte);
				break;
			case 2:
				LivretA livretA = new LivretA(agence, client, solde, decouvert);
				client.getListeCompte().add(livretA);
				break;
			case 3:
				PlanEpargneLogement epargneLogement = new PlanEpargneLogement(agence, client, solde, decouvert);
				client.getListeCompte().add(epargneLogement);
				break;
			default:
				break;
			}
	}
	
	public static Compte getCompteFromId(int id) {
		for (Compte compte : listeCompte) {
			if (id == compte.getIdCompte()) {
				return compte;
			}
		}
		System.out.println("Ce compte n'existe pas");
		return null;
	}
	
	public static void afficherIdComptes() {
		for (long id : listeIdComptes) {
			System.out.println(id);
		}
	}
	


}
