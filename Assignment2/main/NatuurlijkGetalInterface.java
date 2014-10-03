package main;

/** Elementen: Alle positive getallen van 0 t/m 9 van het type char
 * Structuur: Linear
 * Domein: Alle rijen van positieve getallen (nul mag ook) die niet met een 0 beginnen en met een minimale lengte van 1 getal.
 **/

public interface NatuurlijkGetalInterface extends Data{
	
	/** @constructor
	 * PRE: -
	 * POST: Heeft een nieuw object van het type NatuurlijkGetal aangemaakt met de waarde 0.
	 * NatuurlijkGetal(); 
	 **/
	
	/** PRE: - De meegegeven karakter is een positief getal (of nul).
	 * POST: Herstelt dit NatuurlijkGetal-object naar de meegegeven waarde: c.
	 **/	
	void init(char c);

	/** PRE: Alle positieve getallen van 0 t/m 9.
	 * POST: Heeft aan het einde van NatuurlijkGetal-object een char c toegevoegd (als er een 0 inzit is deze overschreven met c)
	 **/	
	void voegToe(char c);
	
	/** PRE: -
	 * POST: Retourneert de lengte van dit NatuurlijkGetal-object
	 **/	
	int lengte();

	/** PRE: Heeft een getal
	 * POST: Retourneert het getal dat staat opgeslagen op index positie i in dit object.
	 **/	
	char get(int i);

}
