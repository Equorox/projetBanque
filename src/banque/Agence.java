package banque;

import java.io.*;
import java.util.*;

public class Agence implements Serializable{

	private static final long serialVersionUID = -2438547408077953067L;

	private static Scanner sc = new Scanner(System.in);

	private int codeAgence;
	private String nomAgence;
	private String adresseAgence;
	private static ArrayList<Integer> listeCodes = new ArrayList<>();
	private static ArrayList<Agence> listeAgences = new ArrayList<>();

	public Agence(String nomAgence, String adresseAgence) {
		this.codeAgence = idGenerator();
		Agence.listeCodes.add(codeAgence);
		this.nomAgence = nomAgence;
		this.adresseAgence = adresseAgence;
		Agence.listeAgences.add(this);
		serializationAgence();
	}
	
	public void serializationAgence() {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream("C:\\Users\\mistr\\Documents\\Programmation\\fagence.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(listeAgences);
			out.flush();
			out.close();
			System.out.println("Agence saved");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public int idGenerator() {
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
		return codeGenere;
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

	public static ArrayList<Agence> getListeAgences() {
		return Agence.listeAgences;
	}

	public String toString() {
		String string = String.format("Id : %d%nNom : %s%nAdresse : %s", this.codeAgence, this.nomAgence, this.adresseAgence);
		return string;
	}

	public static void instanceAgence() {
		System.out.println("Entrez le nom de l'agence");
		String nomAgence = sc.nextLine();
		System.out.println("Entrez l'adresse de l'agence");
		String adresseAgence = sc.nextLine();
		new Agence(nomAgence, adresseAgence);

	}

	public static Agence getAgenceFromId(int id) {
		for (Agence agence : listeAgences) {
			if (id == agence.getCodeAgence()) {
				return agence;
			}
		}
		System.out.println("Cette agence n'existe pas");
		return null;
	}
	
	public static void afficherAgences() {
		for (Agence agence : listeAgences) {
			System.out.println(agence.toString());
		}
	}

}
