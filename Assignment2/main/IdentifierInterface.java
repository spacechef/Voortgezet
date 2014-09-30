package main;

/** Elementen: Alle letters en cijfers van het type char.
 * Structuur: Linear
 * Domein: Alle rijen van letters en cijfers waarbij de eerste karakter een letter moet zijn en de totale lengte van de Identifier minimaal 1 moet zijn.
 **/

public interface IdentifierInterface extends Data{
	
	/** @constructor
	 * PRE: -
	 * POST: Heeft een nieuw object van het type Identifier aangemaakt met de waarde 'L''E''E''G'.
	 * Identifier(); 
	 **/
	
	/** PRE: - De eerste meegegeven karakter is een letter
	 * POST: Herstelt dit Identifier-object naar de meegegeven waarde: c.
	 **/	
	void init(char c);

	/** PRE: Alle rijen van letters en getallen. De eerste karakter moet een letter zijn.
	 * POST: Heeft aan het einde van Identifier-object een char c toegevoegd.
	 **/	
	void voegToe(char c);
	
	/** PRE: -
	 * POST: Retourneert de lengte van dit Identifier-object
	 **/	
	int lengte();

	/** PRE: Heeft een letter en een minimale lengte van 1
	 * POST: Retourneert het getal dat staat opgeslagen op index positie i in dit object.
	 **/	
	char get(int i);

}
