package main;

import java.util.List;

public class Collectie implements CollectieInterface {
	
	private Identifier[] identifierArray;
	private Collectie kopie;
	
		
	
	public Collectie() {
		Identifier[] identifierArray = new Identifier[0];
	}

	public Collectie(Collectie bronCollectie) {
		Collectie kopie = new Collectie();
		kopie.identifierArray = this.identifierArray; 
	}

	@Override
	public void init() {
		this.identifierArray = new Identifier[0];
	}

	@Override
	public void voegToe(Identifier invoerIdentifier) {
		for(int i=0; i<this.lengte(); i++){
			if()
			this.identifierArray = 

	}

	@Override
	public int lengte() {
		return this.identifierArray.length;
		
	}

	@Override
	public void verwijder(Identifier i) {
		
		
	}

	@Override
	public Identifier pak() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collectie vereniging(Collectie ander) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collectie verschil(Collectie ander) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collectie symmetrisch_verschil(Collectie ander) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collectie intersectie(Collectie ander) {
		// TODO Auto-generated method stub
		return null;
	}

}
