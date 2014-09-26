package main;

/** Elementen: Alle positive getallen van 0 t/m 9 van het type int
 * Structuur: Linear
 * Domein: Alle rijen van positieve getallen die niet met een 0 beginnen en met een minimale lengte van 1 getal.
 **/

public interface NatuurlijkGetalInterface extends Data{
	
	/** @constructor
	 * PRE: -
	 * POST: Heeft een nieuw object van het type NatuurlijkGetal aangemaakt met de waarde 0.
	 * NatuurlijkGetal(); 
	 **/
	
	/** PRE: - De meegegeven karakter is een positief getal.
	 * POST: Herstelt dit NatuurlijkGetal-object naar de meegegeven waarde: i.
	 **/	
	void init(int i);

	/** PRE: Alle positieve getallen van 0 t/m 9.
	 * POST: Heeft aan het einde van NatuurlijkGetal-object een int i toegevoegd 
	 **/	
	void voegToe(int i);
	
	/** PRE: -
	 *  POST: Een kopie van dit NatuurlijkGetal-object, met dezelfde waarden als dit object, wordt geretourneerd.
	 **/
	NatuurlijkGetal clone();
	
	/** PRE: -
	 * POST: Retourneert de lengte van dit NatuurlijkGetal-object
	 **/	
	int lengte();

	/** PRE: -
	 * POST: TRUE: Waarden van de twee NatuurlijkGetal-objecten zijn gelijk
	 *  	 FALSE: De meegegeven NatuurlijkGetal-object is niet gelijk is aan dit NatuurlijkGetal-object.
	 **/	
	boolean equals(NatuurlijkGetal ingevoerdeNatuurlijkGetal);

	/** PRE: Heeft een getal
	 * POST: Retourneert het getal dat staat opgeslagen in dit object.
	 **/	
	int get();

}
