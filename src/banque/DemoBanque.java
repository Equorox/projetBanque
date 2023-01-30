package banque;

import java.time.LocalDate;

public class DemoBanque {
	
	public static void main (String[] args) {

		Agence a1 = new Agence("iozdh", "ziodhuahd znidaouj");
		LocalDate date = LocalDate.parse("1938-05-15");
		Client c1 = new Client("iuahd", "ailzdjha", date, "apdjaohd");
				
		Menu.processMenu();
		
	}
	
}
