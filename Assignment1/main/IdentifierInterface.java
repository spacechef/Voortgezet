package main;

public interface IdentifierInterface {
	/* Elementen: Alfanumerieke karakters van het type char
	 * Structuur: Linear
	 * Domein: Alle rijen van alfanumerieke karakters die beginnen met een letter en met een minimale lengte van 1.
	 */
	/* Constructor:
	 * Identifier();
	 * PRE: -
	 * POST: Heeft een nieuw object van het type Identifier aangemaakt.
	 */
	
	void copy();
	/* PRE: -
	 * POST: Maakt een nieuw object van het type identifier aan met dezelfde waarde als deze identifier
	 */
	
	void init();
	/* PRE: -
	 * POST: Herstelt deze identifier naar de oorspronkelijke (lege) waarden.
	 */
	
	void voegToe(char c);
	/* PRE:-
	 * POST: Heeft aan het einde van deze identifier een char c toegevoegd
	 */
	
	int lengte();
	/* PRE: -
	 * POST: Retourneert de lengte van deze identifier
	 */
	
	void drukAf();
	/* PRE: - 
	 * POST: Drukt de identifier af.
	 */
	
	boolean isGelijk(Object Identifier);
	/* PRE: -
	 * POST: Geeft aan of de meegegeven identfier gelijk is aan deze identifier
	 */
	
	char get(int i);
	/* PRE: -
	 * POST: Retourneert char die op de meegegeven index positie staat.
	 */
}
