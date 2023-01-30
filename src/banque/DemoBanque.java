package banque;

import java.time.LocalDate;

import javax.xml.crypto.Data;

public class DemoBanque {
	
	public static void main (String[] args) {
//		Agence.instanceAgence();
//		for (Agence agence : Agence.getListeAgences()) {
//			System.out.println(agence.getCodeAgence());
//			System.out.println(agence.getNomAgence());
//			System.out.println(agence.getAdresseAgence());
//		}
		
		LocalDate bdate = LocalDate.of(2020, 1, 8);
		Client c1 = new Client("Soprano", "Tony", bdate, "loveUgina@gmail.com");
		Client c2 = new Client("Kill", "Bill", bdate, "kill@gmail.com");
		Client c3 = new Client("Neutron", "Jimmy", bdate, "godar@gmail.com");
		
		
		Menu.processMenu();
		
	}
	
}