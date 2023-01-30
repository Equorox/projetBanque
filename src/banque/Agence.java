package banque;

import java.util.*;

public class Agence {
	
	private static Scanner sc = new Scanner(System.in);
	
	private int codeAgence;
	private String nomAgence;
	private String adresseAgence;
	private static ArrayList<Integer> listeCodes = new ArrayList<>();
	private static ArrayList<Agence> listeAgences = new ArrayList<>();

	public Agence(String nomAgence, String adresseAgence) {
		boolean nouveauId = false;
		Random rand = new Random();
		int codeGenere = rand.nextInt(900) + 100;
		while (!nouveauId) {
			nouveauId = true;
			codeGenere = rand.nextInt(900) + 100;
			for (int code : listeCodes) {
				if (codeGenere == code) {
					nouveauId = false;
				}
			}
		}
		this.codeAgence = codeGenere;
		Agence.listeCodes.add(codeAgence);
		this.nomAgence = nomAgence;
		this.adresseAgence = adresseAgence;
	}

	public int getCodeAgence() {
		return this.codeAgence;
	}
	
	public String getNomAgence() {
		return this.nomAgence;
	}
	
	public String getAdresseAgence() {
		return this.adresseAgence;
	}
	
	public static ArrayList<Agence> getListeAgences(){
		return Agence.listeAgences;
	}
	
	public static void instanceAgence() {
		System.out.println("Entrez le nom de l'agence");
		String nomAgence = sc.nextLine();
		System.out.println("Entrez l'adresse de l'agence");
		String adresseAgence = sc.nextLine();
		Agence agence = new Agence(nomAgence, adresseAgence);
		listeAgences.add(agence);
	}

}
