package main;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Collectie collectie1 = new Collectie();
		Collectie collectie2 = new Collectie();
		
		for(int i=0; i<10; i++){
			Identifier huidigeIdentifier = new Identifier();
			huidigeIdentifier.voegToe((char) (i+48));
			try{
				collectie1.voegToe(huidigeIdentifier);
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		for(int i=5; i<15; i++){
			Identifier huidigeIdentifier = new Identifier();
			huidigeIdentifier.voegToe((char) (i+48));
			try{
				collectie2.voegToe(huidigeIdentifier);
			}catch(Exception e){
				System.out.println(e);
			}
		}

		try{
			Collectie verening = collectie1.vereniging(collectie2);
			System.out.println(verening);
			Collectie verschil = collectie1.verschil(collectie2);
			System.out.println(verschil);
			Collectie symmetrischVerschil = collectie1.symmetrischVerschil(collectie2);
			System.out.println(symmetrischVerschil);
			Collectie intersectie = collectie1.intersectie(collectie2);
			System.out.println(intersectie);
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
	}

}
