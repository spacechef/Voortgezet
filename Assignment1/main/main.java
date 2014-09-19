package main;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class main {
	
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

	static String vraagInput(BufferedReader in)throws Exception{
		String stringVanEersteCollectie = null;
		boolean dataIsOngeldig = true;
		while (dataIsOngeldig){
			System.out.print("\nVoer eerste collectie in:");
			stringVanEersteCollectie = in.readLine();
				if (checkInvoer(stringVanEersteCollectie)){ //er gaat wat mis in het tellen van de woorden/ er komt een exception op de -1ste plek van de array te staan
					dataIsOngeldig = false;
			}
		}
		return stringVanEersteCollectie;
	}
	
	static Collectie maakCollectie(String input){
		String collectieZonderBrackets = verwijderBrackets(input);
		String [] stringArrayEersteCollectie = collectieZonderBrackets.split("\\s+");
		Collectie huidigeCollectie = new Collectie();
		for (String s : stringArrayEersteCollectie) {
			Identifier identifier = new Identifier();
			char [] woordInChar = s.toCharArray();
				for (char c : woordInChar){
					identifier.voegToe(c);
				}
			huidigeCollectie.voegToe(identifier);	
		}
		return huidigeCollectie;
	}
	
	public static void main(String[] args) {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			Collectie collectie1 = null;
			Collectie collectie2 = null;
			
			try {
				String input = vraagInput(in);
				collectie1 = maakCollectie(input);
			}
			catch (Exception e){
				System.out.print(e);
			}
				
			try {
				String input = vraagInput(in);
				collectie2 = maakCollectie(input);
			}
			catch (Exception e){
				System.out.print(e);
			}
			
			System.out.println(collectie1.lengte());
			Collectie vereniging = collectie1.vereniging(collectie2);
			System.out.println(vereniging);
			Collectie verschil = collectie1.verschil(collectie2);
			System.out.println(verschil);
			Collectie intersectie = collectie1.intersectie(collectie2);
			System.out.println(intersectie);
			Collectie symmetrischVerschil = collectie1.symmetrischVerschil(collectie2);
			System.out.println(symmetrischVerschil);

		
		// TODO Auto-generated method stub

	}
}
