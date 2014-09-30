/**
 * 
 */
package main;

import assignment2.Collectie;
import assignment2.NatuurlijkGetal;

/**
 * @author Tom
 *
 */
public interface CollectieInterface {

	/**
	 *@elements
	 *		getallen van type NatuurlijkGetal en variabelen van type Identifier.
	 *@structure
	 *		none.
	 *@domain
	 *		alle combinaties van getallen en variabelen.
	 *@constructor
	 *		Collectie();
	 *			PRE: - 
	 *			POST: Er is een nieuw leeg Collectie object geretourneerd.
	 *			
	 **/
	
	/**
	 * PRE: -
	 * POST: Een kopie van dit Collectie object is geretourneerd als nieuw Collectie object.
	 * @return
	 */
	Collectie clone();
	
	/**
	 * PRE: -
	 * POST: Dit Collectie object is leeg.
	 */
	void init();
	
	/**
	 * PRE: - 
	 * POST: Het meegegeven element is het laatste element van de collectie.
	 */
	void voegToe(NatuurlijkGetal n);
	
	/**
	 * PRE: - 
	 * POST: Het meegegeven element komt niet in de collectie voor.
	 */
	void verwijder();
	
	/**
	 * PRE: - 
	 * POST: Het aantal elementen in deze collectie is geretourneerd.
	 * @return
	 */
	int lengte();
	
	/**
	 * PRE: - 
	 * POST: 
	 * 		true: Dit collectie object heeft geen elementen.
	 * 		false: Dit collectie object heeft meer dan 0 elementen.
	 * @return
	 */
	boolean isLeeg();
	
	/**
	 * PRE: -
	 * POST: Een nieuw Collectie object is geretourneerd met daarin een 
	 * kopie van alle unieke elementen in deze en de meegegeven collectie.
	 * @return
	 */
	Collectie vereniging(Collectie meegegevenCollectie);
	
	/**
	 * PRE: - 
	 * POST: Een nieuw Collectie object is geretourneerd met daarin een 
	 * kopie van alle unieke elementen die in deze collectie zitten, maar 
	 * niet in de meegegeven collectie. 
	 * @return
	 */
	Collectie verschil(Collectie meegegevenCollectie);
	
	/**
	 * PRE:
	 * POST: Een nieuw Collectie object is geretourneerd met daarin een kopie 
	 * van alle elementen die zowel in deze collectie als in de meegegeven 
	 * collectie zitten.
	 * @return
	 */
	Collectie intersectie(Collectie meegegevenCollectie);
	
	/**
	 * PRE:
	 * POST: Er is een nieuw collectie object teruggegeven met daarin een kopie
	 * van de elementen die niet in de vereniging van beide collecties zitten.
	 * @return
	 */
	Collectie symVerschil(Collectie meegegevenCollectie);
	
	
	
}

