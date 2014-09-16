package main;

/** Elementen: identifiers van het type Identifier
 * Structuur: none
 * Domein: identifiers met minimaal 0 en maximaal 20 identifiers, die uniek moeten zijn.
 * 
 * @constructor
 * 		Collectie();
 *	    	<dl>
 *				<dt><b>PRE:</b><dd>-
 *				<dt><b>POST:</b><dd>Retourneert een nieuw leeg collectie object.
 *	    	</dl>
 *	 	<br>
 *	 	Collectie(Collectie bronCollectie);
 *	 	    <dl>
 *	 			<dt><b>PRE-condition</b><dd>-
 *	 			<dt><b>POST-condition</b><dd>Retourneert een nieuw collectie object
 *				dat een kopie is van bronCollectie.
 *	    	</dl>
**/

public interface CollectieInterface {
	
	static final int MAXIMALE_AANTAL_IDENTIFIERS = 20;
	static final int MINIMALE_AANTAL_IDENTIFIERS = 0;

	/** PRE: - 
	 * POST: Reset deze collectie naar de lege collectie.
	 **/	
	void init();

	/** PRE: -
	 * POST: 	SUCCESS: De collectie bevat de meegegeven identifier.
	 * 			FAILURE: Exception gegooid als aantal max overschrijdt.
	 **/	
	void voegToe(Identifier invoerIdentifier)throws Exception;

	/** PRE: - 
	 * POST: Het aantal identifiers in deze collectie is geretourneerd
	 **/
	int lengte();
	
	/** PRE: -
	 * POST: Element i komt niet meer in de collectie voor.
	 */
	void verwijder(Identifier i); 
	
	/**
	 * PRE: De collectie bevat ten minste 1 identifier. 
	 * POST: Er is een identifier teruggegeven. 
	 */
	Identifier pak();

	/** PRE: -
	 * POST: SUCCESS: Geeft een nieuw object terug met daarin de vereniging van deze en de meegegeven collectie
	 * 			FAIL:
	 **/
	Collectie vereniging(Collectie ander) throws Exception;
	
	/** PRE: -
	 * POST: Geeft een collectie object terug met daarin de elementen die in deze collectie zitten maar niet in de meegegeven collectie.
	 **/
	Collectie verschil(Collectie ander);

	/** PRE: - 
	 * POST: SUCCESS: Er is een nieuw collectie object teruggegeven met daarin de elementen die niet in de vereniging van beide collecties zitten.
	 * 			FAIL: er
	 **/	
	Collectie symmetrisch_verschil(Collectie ander) throws Exception;

	/** PRE: -
	 * POST: Geeft een nieuw collectie object terug met daarin alle elementen die in beide collecties zitten.
	 **/	
	Collectie intersectie(Collectie ander);

}