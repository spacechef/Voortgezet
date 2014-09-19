package main;

import java.io.*;

public class main {
	
//	static final Collectie eersteCollectie;
//	static final Collectie tweedeCollectie;
	
	static boolean checkAlfanumeriek(String stringVanCollectie) throws Exception {
		String collectieZonderBrackets = verwijderBrackets(stringVanCollectie);
		if (collectieZonderBrackets.matches("\\w.*")){
			return true;
		}
		else {
			throw new Exception ("De woorden mogen alleen alfanumerieke karakters bevatten!");
		} 
	}
	
	static boolean checkAantalWoorden(String stringVanCollectie) throws Exception {
//		System.out.println("dit"+stringVanCollectie);
		String[] arrayCollectie = stringVanCollectie.split("\\s+");
//		System.out.println(arrayCollectie.length);
		//System.out.println("hallo");
		//System.out.print(arrayCollectie[0]);
		if (arrayCollectie.length < 10){
			return true;
		}
		else {
			throw new Exception("De ingegeven collectie bevat teveel woorden!");
		}
	}
	
	static boolean checkBrackets(String stringVanCollectie) throws Exception {
		if (stringVanCollectie.startsWith("{") && stringVanCollectie.endsWith("}")){
				return true;
		} 
		else { 
			throw new Exception("De collectie moet worden ingevoerd met een { aan het begin en een } aan het eind!");
		}
	}
	
	static boolean checkEersteLetter(String stringVanCollectie) throws Exception {
		String eersteLetter = Character.toString(stringVanCollectie.charAt(1)); //pakt indexpositie 1 van de string aangezien er een bracket op 0 zit
		if (eersteLetter.matches("[a-zA-Z]")){
			return true;
		}
		else {
			throw new Exception("De eerste letter van het eerste woord is geen letter!");
		}
	}
	
	static boolean checkInvoer(String stringVanCollectie) {
		try {
			if (checkBrackets(stringVanCollectie) && checkAantalWoorden(stringVanCollectie) && checkAlfanumeriek(stringVanCollectie)){
				return true;
			}
		
		} catch (Exception e){
			System.out.print(e);
			}
		return false;
		
	}
	
	static String verwijderBrackets(String stringVanCollectie){
		String collectieZonderBrackets = stringVanCollectie.substring(1, (stringVanCollectie.length() - 1));
		return collectieZonderBrackets;
	}


	
//	static boolean checkCTRLz(Scanner in){
//		if (nextCharIs(in, '{')){
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	
	
	static Collectie controleerEnMaakCollectie(String stringVanCollectie){
		Collectie eersteCollectie;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			boolean dataIsOngeldig = true;
			while (dataIsOngeldig){
			System.out.print("\nVoer eerste collectie in:");
			String stringVanEersteCollectie = in.readLine();
			if (checkInvoer(stringVanCollectie)){ 
				dataIsOngeldig = false;
				String collectieZonderBrackets = verwijderBrackets(stringVanCollectie);
				String [] stringArrayCollectie = collectieZonderBrackets.split("\\s+");
				eersteCollectie = new Collectie();
				for (String s : stringArrayCollectie) {
					Identifier identifier = new Identifier();
//					System.out.print(s);
					char [] woordInChar = s.toCharArray();
//					System.out.print(woordInChar);
						for (char c : woordInChar){
//							System.out.println(c);
							identifier.voegToe(c);
						}
					eersteCollectie.voegToe(identifier);
					}
				return eersteCollectie;
			}
		}
		
		} 	catch (Exception e){
			System.out.print(e);
		}
	}
	
	
	public static void main(String[] args) {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				
				boolean dataIsOngeldig = true;
				while (dataIsOngeldig){
				System.out.print("\nVoer eerste collectie in:");
				String stringVanEersteCollectie = in.readLine();
				if (checkInvoer(stringVanEersteCollectie)){ 
					dataIsOngeldig = false;
					String collectieZonderBrackets = verwijderBrackets(stringVanEersteCollectie);
//					System.out.println(collectieZonderBrackets);
					String [] stringArrayEersteCollectie = collectieZonderBrackets.split("\\s+");
					final Collectie eersteCollectie = new Collectie();
					for (String s : stringArrayEersteCollectie) {
						Identifier identifier = new Identifier();
//						System.out.print(s);
						char [] woordInChar = s.toCharArray();
//						System.out.print(woordInChar);
							for (char c : woordInChar){
//								System.out.println(c);
								identifier.voegToe(c);
							}
						eersteCollectie.voegToe(identifier);
						
					}
					
				}
				}
			}
			catch (Exception e){
				System.out.print(e);
			}
			
			try {
				boolean dataIsOngeldig = true;
				while (dataIsOngeldig){
				System.out.print("\nVoer tweede collectie in:");
				String stringVanTweedeCollectie = in.readLine();
				if (checkInvoer(stringVanTweedeCollectie)){
					dataIsOngeldig = false;
					String collectieZonderBrackets = verwijderBrackets(stringVanTweedeCollectie);
					String [] stringArrayTweedeCollectie = collectieZonderBrackets.split("\\s+");
					final Collectie tweedeCollectie = new Collectie();
					for (String s : stringArrayTweedeCollectie) {
						Identifier identifier = new Identifier();
						char [] woordInChar = s.toCharArray();
							for (char c : woordInChar){
								identifier.voegToe(c);
							}
						tweedeCollectie.voegToe(identifier);
						
					}
					
				}
				}
			}
			catch (Exception e){
				System.out.print(e);
			}
			
			try {
				Collectie vereniging = eersteCollectie.vereniging(tweedeCollectie);
			}
			catch (Exception e){
				System.out.print(e);
			}
			
			

			}



			
		
		// TODO Auto-generated method stub

	}
