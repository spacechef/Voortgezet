package main;
public class Identifier implements IdentifierInterface {
	
	char[] karakterArray;
	
	public Identifier() {
		this.karakterArray = new char[0];
	}

	public Identifier(Identifier teKopieerenIdentifier) {
		this.karakterArray = new char[teKopieerenIdentifier.lengte()];
		for(int i=0; i<this.lengte();i++){
			this.karakterArray[i] = teKopieerenIdentifier.karakterArray[i];
		}
	}

	@Override
	public void init(char c) {
		this.karakterArray = new char[1];
		this.voegToe(c);
	}

	@Override
	public void voegToe(char c) {	
		Identifier buffer = new Identifier();
		buffer.karakterArray = new char[this.lengte()];
		for(int i=0; i<this.lengte(); i++){
			buffer.karakterArray[i] = this.karakterArray[i];
		}
		this.karakterArray = new char[this.lengte()+1];
		for(int i=0; i < buffer.lengte(); i++){
			this.karakterArray[i] = buffer.karakterArray[i];
		}
		this.karakterArray[buffer.lengte()] = c;
		/*
		this.aantalKaraktersToegevoegd += 1;
		if (this.aantalKaraktersToegevoegd > this.aantalKarakters){
			char[] nieuweKarakterArray = new char[aantalKarakters + 1];
			for (int i = 0; i < this.aantalKarakters; i++){
				nieuweKarakterArray[i] = this.karakterArray[i];
		 	}
			nieuweKarakterArray[aantalKarakters - 1] = c;
			this.karakterArray = nieuweKarakterArray;
		}
		else {
			this.karakterArray[aantalKarakters - 1] = c;
		}
		*/
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