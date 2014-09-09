package main;

/** Elementen: identifiers van het type Identifier
 * Structuur: none
 * Domein: identifiers met minimaal 0 en maximaal 20 identifiers
 **/

public interface CollectionInterface {
	
	static final int MAXIMALE_AANTAL_IDENTIFIERS = 20;
	static final int MINIMALE_AANTAL_IDENTIFIERS = 0;
	

	
	/** constructor
	 * PRE: -
	 *POST: Maakt een nieuw collectie object aan.
	 **/
	void Collection();
	
	
	/** PRE: -
	 * POST: Geeft in een nieuw collectie object een kopie van deze collectie terug.
	 **/	
	void copy();

	/** PRE: - 
	 * POST: Reset deze collectie naar de oorspronkelijke (leeg) waarden.
	 **/	
	void init();

	/** PRE: - De collectie bevat minder dan 20 identifiers.
	 * POST: Een kopie van de identifier is toegevoegd aan het einde van collectie
	 **/	
	void voegToe();

	/** PRE: - 
	 * POST: Het aantal identifiers in deze collectie wordt geretourneerd
	 **/
	void lengte();

	/** PRE: - 
	 * POST: De collectie wordt op het scherm afgedrukt.
	 **/	
	void drukAf();

	/** PRE: -
	 * POST: Geeft een nieuw object terug met daarin de vereniging van deze en de meegegeven collectie
	 **/
	void vereniging(Object collectie);
	
	/** PRE: -
	 * POST: Geeft een collectie object terug met daarin de elementen die in deze collectie zitten maar niet in de meegegeven collectie.
	 **/
	void verschil(Object collectie);

	/** PRE: - 
	 * POST: Geeft een nieuw collectie object terug met daarin de elementen die niet in de vereniging van beide collecties zitten.
	 **/	
	void symmetrisch_verschil(Object collectie);

	/** PRE: -
	 * POST: Geeft een nieuw collectie object terug met daarin alle elementen die in beide collecties zitten.
	 **/	
	void intersectie(Object collectie);

}