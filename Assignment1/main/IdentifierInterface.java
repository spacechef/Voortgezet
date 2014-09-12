package main;

/** Elementen: Alfanumerieke karakters van het type char
 * Structuur: Linear
 * Domein: Alle rijen van alfanumerieke karakters die beginnen met een letter en met een minimale lengte van 1.
 **/

public interface IdentifierInterface {

	/** constructor
	 * PRE: -
	 * POST: Heeft een nieuw object van het type Identifier aangemaakt.
	 **/
	void Identifier();
	
	/** PRE: -
	 * POST: Maakt een nieuw object van het type identifier aan met dezelfde waarde als deze identifier
	 **/	
	void copy();

	/** PRE: -
	 * POST: Herstelt deze identifier naar de oorspronkelijke (lege) waarden.
	 **/	
	void init();

	/** PRE:-
	 * POST: Heeft aan het einde van deze identifier een char c toegevoegd
	 **/	
	void voegToe(char c);

	/** PRE: -
	 * POST: Retourneert de lengte van deze identifier
	 **/	
	int lengte();

	/** PRE: - 
	 * POST: Drukt de identifier af.
	 **/	
	void drukAf();

	/** PRE: -
	 * POST: Geeft aan of de meegegeven identfier gelijk is aan deze identifier
	 **/	
	boolean equals(Object Identifier);

	/** PRE: -
	 * POST: Retourneert char die op de meegegeven index positie staat.
	 **/	
	char get(int i);

}
