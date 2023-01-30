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
	
	public ArrayList<Integer> getListeId(){
		return Client.listeIdClients;
	}
	
	public ArrayList<Client> getListeClients(){
		return Client.listeClients;
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
	
}
