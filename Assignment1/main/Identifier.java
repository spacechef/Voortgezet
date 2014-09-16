package main;
public class Identifier implements IdentifierInterface {
	
	char[] karakterArray;
	int aantalKarakters;
	int aantalKaraktersToegevoegd;
	
	public Identifier() {
		this.aantalKaraktersToegevoegd = 0;
		this.aantalKarakters = 1;
		this.karakterArray = new char[aantalKarakters];
	}

	public Identifier Identifier(Identifier teKopieerenIdentifier) {
		Identifier kopieIdentifier = new Identifier();
		kopieIdentifier.karakterArray = new char[this.lengte()];
		for (int i=0; i <= this.lengte(); i++){
			kopieIdentifier.karakterArray[i] = this.karakterArray[i]; 
		} 
		
		return kopieIdentifier;
	}

	@Override
	public void init(char c) {
		this.karakterArray = new char[1];
		this.voegToe(c);
	}

	@Override
	public void voegToe(char c) {
		this.aantalKaraktersToegevoegd += 1;
		if (this.aantalKaraktersToegevoegd >= this.aantalKarakters){
			char[] nieuweKarakterArray = new char[aantalKarakters + 1];
			for (int i = 0; i <= this.aantalKarakters; i++){
				nieuweKarakterArray[i] = this.karakterArray[i];
		 	}
			this.karakterArray = nieuweKarakterArray;
		}
		else {
			this.karakterArray[aantalKarakters - 1] = c;
		}
		
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
		return this.karakterArray[i];
	}

}
