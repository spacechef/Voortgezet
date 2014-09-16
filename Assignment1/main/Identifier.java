package main;
public class Identifier implements IdentifierInterface {
	
	char[] karakterArray;
	int aantalKarakters;
	
	public Identifier(int aantalKarakters) {
		this.aantalKarakters = aantalKarakters;
		this.karakterArray = new char[aantalKarakters]; 
		// TODO Auto-generated method stub
	}

	public Identifier(Identifier teKopieerenIdentifier) {
		int aantalKarakters = this.lengte();
		Identifier kopieKarakters = new Identifier(aantalKarakters);
		char[] array = new char[aantalKarakters];
		for (int i=0; i <= this.lengte(); i++){
			array[i] = this.karakterArray[i]; 
		} 
		
		return teKopieerenIdentifier;
	}

	@Override
	public void init(char c) {
		this.karakterArray = new char[this.aantalKarakters];
	}

	@Override
	public void voegToe(char c) {
		// this.karakterArray = woord.toCharArray();
	}

	@Override
	public int lengte() {
		return this.karakterArray.length;
	}
	
	@Override
	public boolean equals(Identifier ingevoerdeIdentifier) { 
		if (this.karakterArray == ingevoerdeIdentifier.karakterArray)
			return true;
		return false;
	}

	@Override
	public char get(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
