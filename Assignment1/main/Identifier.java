package main;

import main.Identifier;
import main.IdentifierInterface;

public class Identifier implements IdentifierInterface {
	StringBuffer karakterArray;
    
	public Identifier() {
        
		karakterArray = new StringBuffer();
    }
	
	//retourneert een kopie van de meegegeven identifier in een identifier object
    public Identifier(Identifier teKopierenIdentifier) {
        karakterArray = new StringBuffer(teKopierenIdentifier.karakterArray);
    }
    
    //zet de waarde van deze identifier terug naar de waarde c
    public void init(char c) {
        karakterArray = new StringBuffer();
        voegToe(c);
    }
    
    //voegt char c terug aan de karakterarray
    public void voegToe(char c) {
        karakterArray.append(c);
    }
    
    //retourneert de lengte van de karakter array in een int
    public int lengte() {
        return karakterArray.length();
    }
    
    //retourneert of deze identifer hetzelfde is als de meegeven identifier
    public boolean equals(Identifier ingevoerdeIdentifier) {
        return karakterArray.toString().equals(ingevoerdeIdentifier.karakterArray.toString());
    }
    
    //geeft de char op index i terug
    public char get(int i) {
        return karakterArray.charAt(i);
    }

    
}