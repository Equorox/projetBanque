package banque;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	private static Scanner sc = new Scanner(System.in);

	public static void affichageMenu() {
		System.out.println("------MENU------");
		System.out.println("1. Créer une agence");
		System.out.println("2. Créer un client");
		System.out.println("3. Créer un compte");
		System.out.println("4. Recherche de compte (numéro de compte)");
		System.out.println("5. Recherche de client");
		System.out.println("6. Afficher la liste des comptes d'un client");
		System.out.println("7. Imprimer les infos client");
		System.out.println("8. Afficher listes");
		System.out.println("9. Quitter le programme");
	}

	public static int choix() {

		System.out.print("Votre choix : ");
		int choix = sc.nextInt();
		return choix;
	}

	public static void processMenu() {
		deserializationClient();
		deserializationAgence();
		deserializationCompte();
		while (true) {
			affichageMenu();
			int choix = choix();
			switch (choix) {
			case 1:
				Agence.instanceAgence();
				break;
			case 2:
				Client.instanceClient();
				break;
			case 3:
				Compte.instanceCompte();
				break;
			case 4:
				Compte.afficherIdComptes();
				System.out.printf("%nEntrez l'id du compte : ");
				long id = sc.nextLong();
				sc.nextLine();
				System.out.println(Compte.getCompteFromId(id).toString());
				break;
			case 5:
				System.out.printf(
						"%nComment voulez vous rechercher le client ? %n1. Nom du client%n2. Numéro du compte %n3. Id du client%n");
				int choix5 = choix();
				switch (choix5) {
				case 1:
					System.out.printf("%nEntrez le nom du client : ");
					String nom = sc.next();
					Client client = Client.getClientFromName(nom);
					if (client == null) {
						break;
					}
					System.out.println(Client.getClientFromName(nom).toString());
					break;
				case 2:
					Compte.afficherIdComptes();
					System.out.printf("%nEntrez le numéro du compte :");
					long idCompte = sc.nextLong();
					System.out.println(Client.getClientFromCompte(Compte.getCompteFromId(idCompte)));
					break;
				case 3:
					Client.afficherIds();
					System.out.printf("%nEntrez l'id du client : ");
					String idClient = sc.next();
					System.out.println(Client.getClientFromId(idClient));
					break;
				default:
					break;
				}
				break;
			case 6:
				Client.afficherIds();
				System.out.printf("%nEntrez l'id du client : ");
				String idClient = sc.next();
				Client client = Client.getClientFromId(idClient);
				if (client == null) {
					break;
				}
				Client.getClientFromId(idClient).afficheListeComptes();
				break;
			case 7:
//				Client.printClient();
				break;
			case 8:
				System.out.println();
				System.out.println("Clients ");
				System.out.println();
				for (Client clients : Client.getListeClients()) {
					System.out.println(clients);
				}
				System.out.println();
				System.out.println("Agences");
				System.out.println();
				for (Agence agences : Agence.getListeAgences()) {
					System.out.println(agences);
				}
				System.out.println();
				System.out.println("Comptes ");
				System.out.println();
				for (Compte comptes : Compte.getListeCompte()) {
					System.out.println(comptes);
				}
			case 9:
				System.out.println("A bientôt !");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}

	public static void deserializationClient() {
		String filename = "C:\\Users\\mistr\\Documents\\Programmation\\fclient.txt";
		try (FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(fileIn)) {

			while (true) {
				try {
					@SuppressWarnings("unchecked")
					ArrayList<Client> object = (ArrayList<Client>) in.readObject();
					for (Client client : object) {
						Client.getListeClients().add(client);
					}
				} catch (EOFException e) {
					break;
				}
			}
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Object class not found");
			c.printStackTrace();
		}
	}
	
	public static void deserializationAgence() {
		String filename = "C:\\Users\\mistr\\Documents\\Programmation\\fagence.txt";
		try (FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(fileIn)) {

			while (true) {
				try {
					@SuppressWarnings("unchecked")
					ArrayList<Agence> object = (ArrayList<Agence>) in.readObject();
					for (Agence agence : object) {
						Agence.getListeAgences().add(agence);
					}
				} catch (EOFException e) {
					break;
				}
			}
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Object class not found");
			c.printStackTrace();
		}
	}
	
	public static void deserializationCompte() {
		String filename = "C:\\Users\\mistr\\Documents\\Programmation\\fcompte.txt";
		try (FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(fileIn)) {

			while (true) {
				try {
					@SuppressWarnings("unchecked")
					ArrayList<Compte> object = (ArrayList<Compte>) in.readObject();
					for (Compte compte : object) {
						Compte.getListeCompte().add(compte);
					}
				} catch (EOFException e) {
					break;
				}
			}
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Object class not found");
			c.printStackTrace();
		}
	}
}
