package banque;

import java.util.*;
import java.io.*;

public class Compte implements Serializable{
	
	private static final long serialVersionUID = 5086561284302671817L;

	private static Scanner sc = new Scanner(System.in);
	
	protected long idCompte;
	protected int agence;
	protected Client client;
	protected double solde;
	protected boolean decouvertAutorise;
	protected static ArrayList<Long> listeIdComptes = new ArrayList<>();
	protected static ArrayList<Compte> listeCompte = new ArrayList<>();
	
	
	public Compte(int agence, Client client, double solde, boolean decouvertAutorise) {
		this.idCompte = idGenerator();
		this.agence = agence;
		this.client = client;
		this.solde = solde;
		this.decouvertAutorise = decouvertAutorise;
		Compte.listeIdComptes.add(idCompte);
		Compte.listeCompte.add(this);
		serializationCompte();
	}
	
	
	public void serializationCompte() {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream("C:\\Users\\mistr\\Documents\\Programmation\\fcompte.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(listeCompte);
			out.flush();
			out.close();
			System.out.println("Compte saved");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public long idGenerator() {
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
		return number;
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
	
	public static ArrayList<Compte> getListeCompte() {
		return Compte.listeCompte;
	}
	
	public String toString() {
		String string = String.format("Id Compte : %d%nAgence : %d%nClient : %s%nSolde : %f%nDecouvert Autoris?? : %s", this.idCompte, this.agence, this.client.getNom(), this.solde, this.decouvertAutorise);
		return string;
	}
	
	public static void instanceCompte() {
		Agence.afficherAgences();
		System.out.printf("Entrez l'id de l'agence concern??e : ");
		int agence = sc.nextInt();
		Client.afficherClients();
		System.out.printf("%nEntrez l'id du client concern?? : ");
		Client client = Client.getClientFromId(sc.next());
		if (client == null) {
			return;
		}
		if (client.getListeCompte().size()>3) {
			System.out.println("Ce client a d??j?? 3 comptes");
			return;
		}
		
		System.out.printf("%nEntrez le solde de d??part du compte");
		double solde = sc.nextDouble();
		System.out.printf("%nLe d??couvert est-il autoris?? sur ce compte ?%n1. Oui%n2. Non");
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
	
	public static Compte getCompteFromId(long id) {
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
