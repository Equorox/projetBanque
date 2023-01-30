package banque;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Client {
	
	private static Scanner sc = new Scanner(System.in);
	
	private String idClient;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String email;
	private static ArrayList<String> listeIdClients = new ArrayList<>();
	private static ArrayList<Client> listeClients = new ArrayList<>();
	private ArrayList<Compte> listeComptes = new ArrayList<>();
	
	public Client(String nom, String prenom, LocalDate dateNaissance, String email) {
		//TODO changer la génération pour prendre en compte les règles métier
		boolean nouveauId = false;
		String codeGenere = idGenerator();
		while (!nouveauId) {
			nouveauId = true;
			codeGenere = idGenerator();
			for (String code : listeIdClients) {
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
	
	public String getIdClient() {
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
	
	public static ArrayList<String> getListeId(){
		return Client.listeIdClients;
	}
	
	public static ArrayList<Client> getListeClients(){
		return Client.listeClients;
	}
	
	public ArrayList<Compte> getListeCompte(){
		return this.listeComptes;
	}
	
	public String toString() {
		String string = String.format("Id : %s%nNom : %s%nPrénom : %s%nDate de naissance : %s%nEmail : %s", this.idClient, this.nom, this.prenom, this.dateNaissance, this.email);
		return string;
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
	
	public static Client getClientFromId(String id) {
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

	
	public void afficheListeComptes() {
		for (Compte compte : listeComptes) {
			System.out.println(compte.toString());
		}
	}

	public static void printClient() {
		String user = "";
		int loop = 0;
		
		while (loop == 0) {
			System.out.printf("\nListe des clients : \n");
			for (Client uno : listeClients) {
				System.out.printf("id : %d\n", uno.getIdClient());
			}
			System.out.printf("Quel client souahitez vous consulter ?\n\n");
			user = sc.next();
			if (listeIdClients.contains(user)) {
				loop++;
			}
		}
		for(Client uno : listeClients) {
			if (uno.getIdClient() == user) {	
				try {
					Client tmp = uno;
					 String content = String.format("NUMERO DE CLIENT : %d\n"
					 		+ "NOM : %s\n"
					 		+ "PRENOM : %s\n"
					 		+ "DATE DE NAISSANCE : \n"
					 		+ "\n"
					 		+ "------------------------------------------------------------------------------\n"
					 		+ "LISTE DE COMPTE : \n"
					 		+ "------------------------------------------------------------------------------\n"
					 		+ "NUMERO DE COMPTE                          SOLDE\n"
					 		+ "------------------------------------------------------------------------------\n"
					 		+ " \n",
							 tmp.getIdClient(), tmp.getNom(), tmp.getPrenom());
					 File file = new File("C:\\Users\\59013-42-11\\Desktop\\NouveauFichier.txt"); 
				        if (file.createNewFile()){
				          System.out.println("Le fichier est créé.");
				        }else{
				          System.out.println("Le fichier existe déjà.");
				        }
					 FileWriter fw = new FileWriter(file, false);
					 BufferedWriter bw = new BufferedWriter(fw);
					 bw.write(content);
					 bw.close();
				 } catch (IOException e) {
					 e.printStackTrace();
				 }
				
				break;
			}
		}
	}

	
	public static void afficherClients() {
		for (Client client : listeClients) {
			System.out.println(client.toString());
		}
	}
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public String idGenerator() {
		String first = Character.toString(getRandomNumber(65, 90));
		String second = Character.toString(getRandomNumber(65, 90));
		int number = getRandomNumber(100000, 999999);
		String string = first+second+String.valueOf(number);
		return string;
	}

}





























