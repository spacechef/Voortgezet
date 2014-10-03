/**
 * 
 */
package main;

/**
 *@author Tom
 *
 *@elements
 *		objecten van het type E.
 *@structure
 *		none.
 *@domain
 *		alle objecten van type E.
 *@constructor
 *		Collectie();
 *			PRE: - 
 *			POST: Er is een nieuw leeg Collectie object geretourneerd.
 *			
 **/
interface CollectieInterface<E extends Data> extends Clonable {
	
	/**
	 * PRE: -
	 * POST: Dit Collectie object is leeg.
	 */
	void init();
	
	/**
	 * PRE: -
	 * POST: true: het meegegeven element komt in dit collectie object voor
	 * 		false: het meegegeven element komt niet in dit collectie object voor
	 */
	boolean bevat(natuurlijkGetal n);
	
	/**
	 * PRE: - 
	 * POST: Collectie bevat een kopie van e
	 */
	boolean voegToe(E invoerElement);
	
	/**
	 * PRE: - 
	 * POST: Het meegegeven element komt niet in de collectie voor.
	 */
	boolean verwijder(E e);
	
	/**
	 * PRE: - 
	 * POST: Het aantal elementen in deze collectie is geretourneerd.
	 * @return
	 */
	int lengte();
	
	/**
	 * PRE: - 
	 * POST: 
	 * 		true: Dit collectie object heeft 0 elementen.
	 * 		false: Dit collectie object heeft meer dan 0 elementen.
	 * @return
	 */
	boolean isLeeg();
	
	/**
	 * PRE: - 
	 * POST: true: Dit collectie object is gelijk aan het meegegeven collectie object.
	 * 		false: Dit collectie object is niet gelijk aan het meegegeven collectie object.
	 */
	boolean equals(Collectie<E> meegegevenCollectie);
	
	/**
	 * PRE: - 
	 * POST: het element op positie i is geretourneerd.
	 */
	E pak(int i);
	
	/**
	 * PRE: -
	 * POST: Een nieuw Collectie object is geretourneerd met daarin een. 
	 * kopie van alle unieke elementen in deze en de meegegeven collectie.
	 * @return
	 */
	Collectie<E> vereniging(Collectie<E> meegegevenCollectie);
	
	/**
	 * PRE: - 
	 * POST: Een nieuw Collectie object is geretourneerd met daarin een 
	 * kopie van alle unieke elementen die in deze collectie zitten, maar 
	 * niet in de meegegeven collectie. 
	 * @return
	 */
	Collectie<E> verschil(Collectie<E> meegegevenCollectie);
	
	/**
	 * PRE:
	 * POST: Een nieuw Collectie object is geretourneerd met daarin een kopie 
	 * van alle elementen die zowel in deze collectie als in de meegegeven 
	 * collectie zitten.
	 * @return
	 */
	Collectie<E> intersectie(Collectie<E> meegegevenCollectie);
	
	/**
	 * PRE:
	 * POST: Er is een nieuw collectie object teruggegeven met daarin een kopie
	 * van de elementen die niet in de vereniging van beide collecties zitten.
	 * @return
	 */
	Collectie<E> symVerschil(Collectie<E> meegegevenCollectie);
	
}

