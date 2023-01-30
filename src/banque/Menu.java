package banque;

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
		System.out.println("8. Quitter le programme");
	}

	public static int choix() {

		System.out.print("Votre choix : ");
		int choix = sc.nextInt();
		return choix;
	}

	public static void processMenu() {
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

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:
				System.out.println("A bientôt !");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}

}
