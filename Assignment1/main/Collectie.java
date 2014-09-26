package main;

import main.Collectie;
import main.CollectieInterface;
import main.Identifier;

public class Collectie implements CollectieInterface {


	static final int MAXIMALE_AANTAL_IDENTIFIERS = 20;
	static final int MINIMALE_AANTAL_IDENTIFIERS = 0;
	Identifier identifierArray[];
	
    public Collectie()
    {
        identifierArray = new Identifier[0];
    }
    
    //retourneert een kopie van de meegegeven collectie
    public Collectie(Collectie teKopierenCollectie)
    {
        identifierArray = new Identifier[teKopierenCollectie.lengte()];
        for(int i = 0; i < lengte(); i++)
            identifierArray[i] = new Identifier(teKopierenCollectie.identifierArray[i]);

    }
    
    //reset de huidige collectie naar een lege warde
    public void init() {
        identifierArray = new Identifier[0];
    }
    
    //voegt de meegegeven identifier terug en voorkomt dat deze dubbel word toegvoegd. Verlengd tevens de array om alle identifiers in op te kunnen slaan
    public void voegToe(Identifier invoerIdentifier) {
        if(!bevat(invoerIdentifier))
            if(lengte() < MAXIMALE_AANTAL_IDENTIFIERS) {
                Collectie buffer = new Collectie(this);
                identifierArray = new Identifier[lengte() + 1];
                for(int i = 0; i < buffer.lengte(); i++)
                    identifierArray[i] = new Identifier(buffer.identifierArray[i]);

                identifierArray[buffer.lengte()] = new Identifier(invoerIdentifier);
            }
    }
    
    //geeft de lengte van de huidige collectie terug
    public int lengte() {
        return identifierArray.length;
    }
    
    //controleert of de collectie de meegegeven identifier bevat
    public boolean bevat(Identifier meegegevenIdentifier) {
        for(int i = 0; i < this.lengte(); i++)
            if(identifierArray[i].equals(meegegevenIdentifier))
                return true;

        return false;
    }
    
    //verwijdert de meegegeven identifier
    public void verwijder(Identifier teVerwijderenIdentifier) {
        Collectie buffer = new Collectie(this);
        identifierArray = new Identifier[lengte() - 1];
        int invoerIndex = 0;
        for(int i = 0; i < buffer.lengte(); i++) {
            if(!buffer.identifierArray[i].equals(teVerwijderenIdentifier)) {
                identifierArray[invoerIndex] = new Identifier(buffer.identifierArray[i]);
                invoerIndex++;
            }
        }

    }
    
    //geeft de laatste identifier terug
    public Identifier pak() {
        return identifierArray[lengte() - 1];
    }
    
    //geeft de vereniging van collectie1 en 2 terug in een collectie object
    public Collectie vereniging(Collectie collectie2) throws Exception {
        Collectie vereniging = new Collectie();
        for(int i = 0; i < lengte(); i++){
            vereniging.voegToe(identifierArray[i]);
        }
        for(int i = 0; i < collectie2.lengte(); i++) {
            vereniging.voegToe(collectie2.identifierArray[i]);
        }
        if(vereniging.lengte() > 20) {
            throw new Exception("Geef maximaal 20 unieke identifiers als input.");
        }
        else {
            return vereniging;
        }
    }
    
    //geeft het het verschil van 1 met 2 terug in een collectie object
    public Collectie verschil(Collectie ander) {
        Collectie verschil = new Collectie(this);
        for(int i = 0; i < ander.lengte(); i++) {
            if(verschil.bevat(ander.identifierArray[i])) {
                verschil.verwijder(ander.identifierArray[i]);
            }
        }
        return verschil;
    }
    
    //geeft het symmetrische verschil terug in een collectie object
    public Collectie symmetrischVerschil(Collectie ander) throws Exception {
        Collectie verschil1 = verschil(ander);
        Collectie verschil2 = ander.verschil(this);
        Collectie symmetrischVerschil = verschil1.vereniging(verschil2);
        if(symmetrischVerschil.lengte() > 20){
            throw new Exception("Geef per collectie maximaal 10 identifiers als input.");
        }
        else {
            return symmetrischVerschil;
        }
    }
    
    //geeft de intersectie van collectie1 en collectie2 terug in een collectie object
    public Collectie intersectie(Collectie ander) {
        Collectie intersectie = new Collectie();
        Collectie kleinsteCollectie;
        Collectie grootsteCollectie;
        if(lengte() > ander.lengte())  {
            kleinsteCollectie = ander;
            grootsteCollectie = this;
        } else {
            kleinsteCollectie = this;
            grootsteCollectie = ander;
        }
        for(int i = 0; i < kleinsteCollectie.lengte(); i++) {
            if(grootsteCollectie.bevat(kleinsteCollectie.identifierArray[i])) {
                try {
                    intersectie.voegToe(kleinsteCollectie.identifierArray[i]);
                }
                catch(Exception e) {
                    System.out.println(e);
                }
            }	
        }
        return intersectie;
    }
}
