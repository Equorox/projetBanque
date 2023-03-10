package banque;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Client implements Serializable {

	private static final long serialVersionUID = -7483845706066474930L;

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
		this.idClient = idGenerator();
		Client.listeIdClients.add(idClient);
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		Client.listeClients.add(this);
		serializationClient();
	}
	
	
	public String idGenerator() {
		boolean nouveauId = false;
		String codeGenere = stringGenerator();
		while (!nouveauId) {
			nouveauId = true;
			codeGenere = stringGenerator();
			for (String code : listeIdClients) {
				if (codeGenere == code) {
					nouveauId = false;
				}
			}
		}
		return codeGenere;
	}
	
	public static void serializationClient() {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream("C:\\Users\\mistr\\Documents\\Programmation\\fclient.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(listeClients);
			out.flush();
			out.close();
			System.out.println("Client saved");
		} catch (Exception e) {
			System.out.println(e);
		}
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

	public static ArrayList<String> getListeId() {
		return Client.listeIdClients;
	}

	public static ArrayList<Client> getListeClients() {
		return Client.listeClients;
	}

	public ArrayList<Compte> getListeCompte() {
		return this.listeComptes;
	}

	public String toString() {
		String string = String.format("Id : %s%nNom : %s%nPr??nom : %s%nDate de naissance : %s%nEmail : %s",
				this.idClient, this.nom, this.prenom, this.dateNaissance, this.email);
		return string;
	}

	public static void instanceClient() {
		System.out.printf("%nEntrez le nom du client : ");
		String nom = sc.next();
		System.out.printf("%nEntrez le pr??nom du client : ");
		String prenom = sc.next();
		System.out.printf("%nEntrez la date de naissance du client : ");
		LocalDate dateNaissance = LocalDate.parse(sc.next());
		System.out.printf("%nEntrez le mail du client : ");
		String email = sc.next();
		new Client(nom, prenom, dateNaissance, email);
	}

	public static Client getClientFromId(String id) {
		for (Client client : listeClients) {
			if (id.equals(client.getIdClient())) {
				return client;
			}
		}
		System.out.println("Ce client n'existe pas");
		return null;
	}

	public static Client getClientFromName(String nom) {
		for (Client client : listeClients) {
			if (nom.equals(client.getNom())) {
				return client;
			}
		}
		System.out.println("Ce client n'existe pas");
		return null;
	}

	public static Client getClientFromCompte(Compte compte) {
		for (Client client : listeClients) {
			if (client.equals(compte.getClient())) {
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
				System.out.printf("id : %s\n", uno.getIdClient());
			}
			System.out.printf("Quel client souahitez vous consulter ?\n\n");
			user = sc.next();
			if (listeIdClients.contains(user)) {
				loop++;
			}
		}
		for (Client uno : listeClients) {
			if (uno.getIdClient().equals(user)) {
				try {
					Client tmp = uno;
					String content = String.format(
							"NUMERO DE CLIENT : %s\n" + "NOM : %s\n" + "PRENOM : %s\n" + "DATE DE NAISSANCE : \n" + "\n"
									+ "------------------------------------------------------------------------------\n"
									+ "LISTE DE COMPTE : \n"
									+ "------------------------------------------------------------------------------\n"
									+ "NUMERO DE COMPTE                          SOLDE\n"
									+ "------------------------------------------------------------------------------\n"
									+ " \n",
							tmp.getIdClient(), tmp.getNom(), tmp.getPrenom());
					File file = new File("C:\\Users\\mistr\\Desktop\\NouveauFichier.txt");
					if (file.createNewFile()) {
						System.out.println("Le fichier est cr????.");
					} else {
						System.out.println("Le fichier existe d??j??.");
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

	public String stringGenerator() {
		String first = Character.toString(getRandomNumber(65, 90));
		String second = Character.toString(getRandomNumber(65, 90));
		int number = getRandomNumber(100000, 999999);
		String string = first + second + String.valueOf(number);
		return string;
	}

	public static void afficherIds() {
		for (String id : listeIdClients) {
			System.out.println(id);
		}
	}
}
