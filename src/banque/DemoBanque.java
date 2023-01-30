package banque;

import java.time.LocalDate;


public class DemoBanque {
	
	public static void main (String[] args) {

		Agence a1 = new Agence("iozdh", "ziodhuahd znidaouj");
		LocalDate date = LocalDate.parse("1938-05-15");
		Client c1 = new Client("iuahd", "ailzdjha", date, "apdjaohd");
		LocalDate bdate = LocalDate.of(2020, 1, 8);
		Client cd1 = new Client("Soprano", "Tony", bdate, "loveUgina@gmail.com");
		Client c2 = new Client("Kill", "Bill", bdate, "kill@gmail.com");
		Client c3 = new Client("Neutron", "Jimmy", bdate, "godar@gmail.com");
		Compte com1 = new Compte(a1.getCodeAgence(), c1, 150, false);
		
//		Agence.afficherAgences();
//		Compte.afficherIdComptes();
//		Agence.instanceAgence();
//		Agence.afficherAgences();
		
//		Client.afficherClients();
//		System.out.println(Client.getClientFromName("Soprano"));
//		Compte.afficherIdComptes();
		Menu.processMenu();
		
		
		
		
		
	}
	
}