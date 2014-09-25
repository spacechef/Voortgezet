package main;

import main.Identifier;

/** Elementen: Alfanumerieke karakters van het type char
 * Structuur: Linear
 * Domein: Alle rijen van alfanumerieke karakters die beginnen met een letter en met een minimale lengte van 1.
 **/

public interface IdentifierInterface {

	/** @constructor
	 * PRE: -
	 * POST: Heeft een nieuw object van het type Identifier aangemaakt met de waarde 'L''E''E''G'.
	 * Identifier(); 
	 **/
	
	
	/** PRE: -
	 * POST: Maakt een nieuw object van het type identifier aan met een kopie van dezelfde waarde als de meegegeven identifier
	 * Identifier(Identifier identifier);
	**/
	
	/** PRE: - De meegegeven karakter is een letter.
	 * POST: Herstelt deze identifier naar de oorspronkelijke c waarden.
	 **/	
	void init(char c);

	/** PRE: Alle alfanumerieke karakters.
	 * POST: Heeft aan het einde van deze identifier een char c toegevoegd 
	 **/	
	void voegToe(char c);

	/** PRE: -
	 * POST: Retourneert de lengte van deze identifier
	 **/	
	int lengte();


	/** PRE: -
	 * POST: TRUE: Waarden van de identifiers zijn gelijk
	 * `	 FALSE: De meegegeven identfier is niet gelijk is aan deze identifier
	 **/	
	boolean equals(Identifier ingevoerdeIdentifier);

	/** PRE: min 0 max lengte van Identifier
	 * POST: Retourneert char die op de meegegeven index positie staat.
	 **/	
	char get(int i);

}
