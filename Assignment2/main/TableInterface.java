package main;

import javax.xml.crypto.Data;

/**
 * @author Tom
 *
 * @param <Collectie>
 * @param <Identifier>
 * 
 * @elementen: combinaties van het type K en objecten van het type V.
 * 
 * @structuur: none
 * 
 * @domein:	combinaties van een unieke keys gekoppeld aan values.
 * 
 * @constructor - Table();
 */
public interface TableInterface<K extends Data, V extends Clonable> extends Clonable {
	
	/**
	 * PRE: - 
	 * POST: true: dit tabel object bevat 0 elementen
	 * 		false: dit tabel object bevat meer dan 0 elementen
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * PRE: - 
	 * POST: alle elementen zijn uit dit tabel object verwijderd
	 * @return
	 */
	Table<K, V> init();
	
	/**
	 * PRE: - 
	 * POST: het aantal elementen in dit tabel object is geretourneerd
	 * @return
	 */
	int lengte();
	
	/**
	 * PRE: - 
	 * POST: de tabel bevat een combinatie van de meegegeven K en V
	 * @param k
	 * @param v
	 */
	void voegToe(K k, V v);
	
	/**
	 * PRE: -
	 * POST: het meegegeven element k zit niet in de tabel
	 * @param k
	 */
	void verwijder(K k);
	
	/**
	 * PRE: de tabel bevat het meegegeven element k
	 * POST: het element v dat gecombineerd is met k, is geretourneerd
	 * @param k
	 * @return
	 */
	V vind(K k);
	
	/**
	 * PRE: -
	 * POST: true: k is een element van dit tabel object
	 * 		false: k is geen element van dit tabel object
	 * @param k
	 * @return
	 */
	boolean bevat(K k);
	
}
