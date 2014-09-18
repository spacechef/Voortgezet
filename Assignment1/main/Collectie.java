package main;

public class Collectie implements CollectieInterface {
	
	static final int MAXIMALE_AANTAL_IDENTIFIERS = 20;
	static final int MINIMALE_AANTAL_IDENTIFIERS = 0;
	
	private Identifier[] identifierArray;
	private Collectie kopie;
			
	public Collectie() {
		Identifier[] identifierArray = new Identifier[0];
	}

	public Collectie(Collectie teKopierenCollectie) {
		Collectie kopie = new Collectie();
		for(int i = 0; i<teKopierenCollectie.lengte(); i++){
			kopie.identifierArray[i] = teKopierenCollectie.identifierArray[i];
		}
	}

	@Override
	public void init() {
		this.identifierArray = new Identifier[0];
	}

	
	@Override
	public void voegToe(Identifier invoerIdentifier) throws IndexOutOfBoundsException {	
		if(this.bevat(invoerIdentifier)){
			break;
		}
		else{
			if(this.lengte() < MAXIMALE_AANTAL_IDENTIFIERS){
				Collectie buffer = new Collectie(this);
				this.identifierArray = new Identifier[this.lengte()+1];
				for(int i = 0; i < buffer.lengte(); i++){
					this.identifierArray[i] = new Identifier(buffer.identifierArray[i]);
					}
				this.identifierArray[this.lengte()] = new Identifier(invoerIdentifier);
			}
			else{
				throw new IndexOutOfBoundsException();	
			}
		}
	}

	
	@Override
	public int lengte() {
		return this.identifierArray.length;
	}
	
	
	public boolean bevat(Identifier meegegevenIdentifier){
		for(int i = 0; i < this.lengte(); i++){
			if(this.identifierArray[i].equals(meegegevenIdentifier)){
				return true;
			}
		}
		return false;
	}
	
	
	//deze is misschien toch niet nuttig
	public int index(Identifier meegegevenIdentifier) throws IllegalArgumentException{
		int index = -1;
		for(int i = 0; i < this.lengte(); i++){
			if(this.identifierArray[i].equals(meegegevenIdentifier)){
				index = i;
			}
		}
		if(index == -1){
			throw new IllegalArgumentException();
		}
		else{
		return index;
		}
	}
	
	
	@Override//Let op: Programma moet voorkomen dat er dubbele identifiers in een collectie komen
	//edit: wordt misschien opgelost door gebruik van while in verschil en symm verschil.
	public void verwijder(Identifier teVerwijderenIdentifier) {
		while(this.bevat(teVerwijderenIdentifier)){
			Collectie buffer = new Collectie(this);
			this.identifierArray = new Identifier[this.lengte()-1];
			for(int i = 0; i < buffer.lengte(); i++){
				if(buffer.identifierArray[i] != teVerwijderenIdentifier){
					this.voegToe(buffer.identifierArray[i]);
				}
				break;
			}	
		}			
	}

	
	@Override
	public Identifier pak() {
		return this.identifierArray[this.lengte()-1];
	}

	
	@Override//Eerdere implementatie maakte ipv voegToe() direct een nieuwe identifier 
	//met meegegeven waarden op de aangegeven indexpositie. Dit vermeed het herhaaldelijke 
	//kopieren dat voegToe() doet. (omdat van de al lopende loop gebruikt werd gemaakt)
	public Collectie vereniging(Collectie collectie2) throws IndexOutOfBoundsException {
		Collectie vereniging = new Collectie();
		Collectie ander = new Collectie(collectie2); 
		for(int i = 0; i < ander.lengte(); i++){
			if(ander.bevat(this.identifierArray[i])){  //evt veranderen in while?
					ander.verwijder(ander.identifierArray[i]);
			}
		}
		vereniging.identifierArray = new Identifier[this.lengte() + ander.lengte()];
		if(vereniging.lengte() <= MAXIMALE_AANTAL_IDENTIFIERS){
			for(int i = 0; i < this.lengte(); i++){
				vereniging.voegToe(this.identifierArray[i]);
			}
			for(int i = 0; i<ander.lengte(); i++){
				vereniging.voegToe(ander.identifierArray[i]);
			}
			return vereniging;
		}
		else{
			throw new IndexOutOfBoundsException();
		}
	}

	
	@Override
	public Collectie verschil(Collectie ander) {
		Collectie verschil = new Collectie(this);
		final int startIndex = verschil.lengte()-1;
		for(int i = startIndex; i == 0; i--){
			if(ander.bevat(verschil.identifierArray[i])){ //evt while?
				verschil.verwijder(verschil.identifierArray[i]);
			}
		}
		return verschil;
	}

	
	@Override
	public Collectie symmetrischVerschil(Collectie ander) throws IndexOutOfBoundsException {
		Collectie symmetrischVerschil;
		Collectie verschil1 = this.verschil(ander);
		Collectie verschil2 = ander.verschil(this);
		try{
			symmetrischVerschil = verschil1.vereniging(verschil2);
		}
		catch(IndexOutOfBoundsException e){	//vangen en opnieuw gooien niet nodig?
			throw new IndexOutOfBoundsException();
		}
		return symmetrischVerschil;
	}

	
	@Override
	public Collectie intersectie(Collectie ander) {
		Collectie intersectie = new Collectie();
		Collectie kleinsteCollectie;
		Collectie grootsteCollectie;
		
		if(this.lengte() > ander.lengte()){
			kleinsteCollectie = ander;
			grootsteCollectie = this;
		}
		else{
			kleinsteCollectie = this;
			grootsteCollectie = ander;
		}
		for(int i = 0; i < kleinsteCollectie.lengte(); i++){
			if(grootsteCollectie.bevat(kleinsteCollectie.identifierArray[i])){
				intersectie.voegToe(kleinsteCollectie.identifierArray[i]);
			}
		}
		return intersectie;
	}

}
