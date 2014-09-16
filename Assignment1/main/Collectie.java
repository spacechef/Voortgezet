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
	public void voegToe(Identifier invoerIdentifier) throws Exception {	
		try {
			if(this.lengte() < MAXIMALE_AANTAL_IDENTIFIERS){
				Collectie buffer = new Collectie(this);
				this.identifierArray = new Identifier[this.lengte()+1];
				for(int i =0; i<this.lengte(); i++){
					this.identifierArray[i] = new Identifier(buffer.identifierArray[i]);
				}
				this.identifierArray[this.lengte()] = new Identifier(invoerIdentifier);
			}
			else{
				throw Exception IndexOutOfBoundsException
			}
		}catch(Exception e){
			System.out.println("De collectie bevat te veel elementen.");
		}
	}

	@Override
	public int lengte() {
		return this.identifierArray.length;
	}

	@Override
	public void verwijder(Identifier teVerwijderenIdentifier) {
		Collectie buffer = new Collectie(this);
		this.identifierArray = new Identifier[this.lengte()-1];
		int invoegIndex = 0 ;
		for(int i = 0; i < this.lengte(); i++){
			if(buffer.identifierArray[i] != teVerwijderenIdentifier){
				this.identifierArray[invoegIndex] = new Identifier(buffer.identifierArray[i]);
				invoegIndex++;
			}	
		}			
	}

	@Override
	public Identifier pak() {
		return this.identifierArray[this.lengte()-1];
	}

	@Override
	public Collectie vereniging(Collectie ander) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collectie verschil(Collectie ander) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collectie symmetrisch_verschil(Collectie ander) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collectie intersectie(Collectie ander) {
		// TODO Auto-generated method stub
		return null;
	}

}
