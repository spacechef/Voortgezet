package main;

import java.util.Arrays;
import java.util.Scanner;

public class main {
	
	static final int MAXIMALE_AANTAL_IDENTIFIERS_PER_COLLECTIE = 10;
	
	//checked voor de gehele invoer (behalve de brackets) of de karakters alfanumeriek zijn 
	static boolean checkAlfanumeriek(String invoer) throws Exception {
		String collectieZonderBrackets = verwijderBrackets(invoer);
		if (collectieZonderBrackets.matches("^[a-zA-Z0-9 ]*$")){
			return true;
		}
		else {
			throw new Exception ("\nDe woorden mogen alleen alfanumerieke karakters bevatten!\n");
		} 
	}
	
	//Telt het aantal woorden dat is ingevoerd. Zorgt ervoor dat dubbele woorden niet meegeteld worden.
	static boolean checkAantalWoorden(String invoer) throws Exception {
		String[] arrayCollectie = verwijderBrackets(invoer).split("\\s+");
		String [] tempArrayCollectie = new String[MAXIMALE_AANTAL_IDENTIFIERS_PER_COLLECTIE + 1];
		int teller = 0;
		for (String s: arrayCollectie){
			if (!Arrays.asList(tempArrayCollectie).contains(s) && teller < MAXIMALE_AANTAL_IDENTIFIERS_PER_COLLECTIE + 1){
				tempArrayCollectie[teller] = s;
				teller ++;
			}
		}	
		
		if (teller <= MAXIMALE_AANTAL_IDENTIFIERS_PER_COLLECTIE){
			return true;
		}
		else {
			throw new Exception("\nDe ingegeven collectie bevat teveel woorden!\n");
		}
		
	}
	//Controleert of de invoer is geopend met een { en gesloten met een}
	static boolean checkBrackets(String invoer) throws Exception {
		if (invoer.startsWith("{") && invoer.endsWith("}")){
				return true;
		} 
		else { 
			throw new Exception("\nDe collectie moet worden ingevoerd met een { aan het begin en een } aan het eind!\n");
		}
	}
	
	//Checked voor elk ingevoerd woord of de eerste karakter een letter is.
	static boolean checkEersteLetter(String invoer) throws Exception {
		String [] inputZonderBrackets = verwijderBrackets(invoer).split("\\s+");
		for (String s: inputZonderBrackets) {
			String eersteLetter = Character.toString(s.charAt(0));
			if (!eersteLetter.matches("[a-zA-Z]")){
				throw new Exception ("\nDe eerste letter van de identifiers moet een letter zijn!\n");
			}
		}
		return true;
	}
	
	//Zorgt ervoor dat alle checks met 1 methode aangeroepen kunnen worden.
	static boolean checkInvoer(String invoer) {
		if (checkLegeCollectie(invoer)){
			return true;
		}
		try {
			if (checkEnter(invoer) && checkAantalWoorden(invoer) && checkAlfanumeriek(invoer) && checkBrackets(invoer) &&checkEersteLetter(invoer)){
				return true;
			}
		
		} catch (Exception e){
			System.out.print(e);
			}
		return false;
	}
	//Verwijdert de ingevoerde brackets in de user input
	static String verwijderBrackets(String invoer){
		String collectieZonderBrackets = invoer.substring(1, (invoer.length() - 1));
		return collectieZonderBrackets;
	}

	//Maakt van de woorden identifiers en stopt deze identifiers in een nieuwe collectie.
	static Collectie maakCollectie(String invoer){
		String collectieZonderBrackets = verwijderBrackets(invoer);
		String [] stringArrayCollectie = collectieZonderBrackets.split("\\s+");
		Collectie huidigeCollectie = new Collectie();
		for (String s : stringArrayCollectie) {
			Identifier identifier = new Identifier();
			char [] woordInChar = s.toCharArray();
				for (char c : woordInChar){
					identifier.voegToe(c);
				}
			huidigeCollectie.voegToe(identifier);
		}
		return huidigeCollectie;
	}

	//controleert over een een enter is ingevoerd
	static boolean checkEnter(String invoer){
		if (!invoer.isEmpty()){
			return true;
		}
		else {
			return false;	
		}
		
	}
	
	//Controleert of de meegegeven collectie leeg is.
	static boolean checkLegeCollectie(String invoer){
		if(invoer.equals("{}")){
			return true;
		}
		return false;
	}

	//Drukt de meegegeven collectie af
	static void drukAf(Collectie collectie, String naamVanCollectie){
		System.out.printf("%-20s: ", naamVanCollectie);
		for (Identifier i: collectie.identifierArray){
			System.out.printf(" %s", i.karakterArray.toString());
		}
		System.out.print("\n");
	}	
	
	//Controleert en maakt de ingevoerde collectie en geeft deze terug in een Collectie object. Blijft net zolang om invoer vragen tot deze juist is.
	static Collectie maakCollectie(Scanner in, String teller){
		String invoer = null;
		do {
			System.out.printf("\nVoer %s collectie in:", teller);
			if (!in.hasNextLine()){
				System.out.println("\nHet programma is gestopt");
				System.exit(0);
			}
			invoer = in.nextLine();
			
		} while (!checkInvoer(invoer));
		Collectie collectie = maakCollectie(invoer);
		return collectie;
	}
	
	public static void main(String[] args) { 
			
			Scanner in = new Scanner(System.in);
			boolean herhaal = true;
			Collectie collectie1 = null;
			Collectie collectie2 = null;
			
			do {
				String collectieTeller = "eerste";
				collectie1 = maakCollectie(in,collectieTeller);
				collectieTeller = "tweede";
				collectie2 = maakCollectie(in,collectieTeller);
			
				try {
					Collectie vereniging = collectie1.vereniging(collectie2);
					drukAf(vereniging, "Vereniging");
					Collectie verschil = collectie1.verschil(collectie2);
					drukAf(verschil, "Verschil");
					Collectie intersectie = collectie1.intersectie(collectie2);
					drukAf(intersectie, "Intersectie");
					Collectie symmetrischVerschil = collectie1.symmetrischVerschil(collectie2);
					drukAf(symmetrischVerschil, "SymmetrischVerschil");
					System.out.println("");
				
				} catch (Exception e) {
					System.out.print(e);
				}
				
		} while (herhaal);
	}
	// Dit zou branch 2 moeten zijn!
}
