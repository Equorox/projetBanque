package banque;

import java.time.LocalDate;
import java.util.*;

public class Client {
	
	private static Scanner sc = new Scanner(System.in);
	
	private int idClient;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String email;
	private static ArrayList<Integer> listeIdClients = new ArrayList<>();
	private static ArrayList<Client> listeClients = new ArrayList<>();
	private ArrayList<Compte> listeComptes = new ArrayList<>();
	
	public Client(String nom, String prenom, LocalDate dateNaissance, String email) {
		//TODO changer la génération pour prendre en compte les règles métier
		boolean nouveauId = false;
		Random rand = new Random();
		int codeGenere = rand.nextInt(900) + 100;
		while (!nouveauId) {
			nouveauId = true;
			codeGenere = rand.nextInt(900) + 100;
			for (int code : listeIdClients) {
				if (codeGenere == code) {
					nouveauId = false;
				}
			}
		}
		this.idClient = codeGenere;
		Client.listeIdClients.add(idClient);
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		Client.listeClients.add(this);
	}
	
	public int getIdClient() {
		return this.idClient;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public LocalDate getDateNaissance() {
		return this.dateNaissance;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public static ArrayList<Integer> getListeId(){
		return Client.listeIdClients;
	}
	
	public static ArrayList<Client> getListeClients(){
		return Client.listeClients;
	}
	
	public ArrayList<Compte> getListeCompte(){
		return this.listeComptes;
	}
	
	public static void instanceClient() {
		System.out.printf("%nEntrez le nom du client : ");
		String nom = sc.next();
		System.out.printf("%nEntrez le prénom du client : ");
		String prenom = sc.next();
		System.out.printf("%nEntrez la date de naissance du client : ");
		LocalDate dateNaissance = LocalDate.parse(sc.next());
		System.out.printf("%nEntrez le mail du client : ");
		String email = sc.next();
		Client client = new Client(nom, prenom, dateNaissance, email);
		Client.listeClients.add(client);
	}
	
	public static Client getClientFromId(int id) {
		for (Client client : listeClients) {
			if (id == client.getIdClient()) {
				return client;
			}
		}
		System.out.println("Ce client n'existe pas");
		return null;
	}
	
	public static Client getClientFromName(String nom) {
		for (Client client : listeClients) {
			if(nom == client.getNom()) {
				return client;
			}
		}
		System.out.println("Ce client n'existe pas");
		return null;
	}
	
	public static Client getClientFromCompte(Compte compte) {
		for (Client client : listeClients) {
				if (client == compte.getClient()) {
					return client;
			}
		}
		System.out.println("Ce client n'existe pas");
		return null;
	}

	public static void printClient() {
		int user = 0;
		int loop = 0;
		
		while (loop == 0) {
			System.out.printf("\nListe des clients : \n");
			for (Client uno : listeClients) {
				System.out.printf("id : %d\n", uno.getIdClient());
			}
			System.out.printf("Quel client souahitez vous consulter ?\n\n");
			user = sc.nextInt();
			sc.nextLine();
			if (listeIdClients.contains(user)) {
				loop++;
			}
		}
		for(Client uno : listeClients) {
			if (uno.getIdClient() == user) {
				Client tmp = uno;
				System.out.printf("Nom : %s, Prenom : %s, Email : %s\n\n", tmp.getNom(), tmp.getPrenom(), tmp.getEmail());
				break;
			}
		}
	}

}





























