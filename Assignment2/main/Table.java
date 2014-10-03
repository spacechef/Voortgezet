package main;

public class Table<K extends Data, V extends Clonable> implements TableInterface<K, V>, Clonable {

	private Lijst<Node> rijLijst;
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int lengte() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void voegToe(K k, V v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verwijder(K k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V vind(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bevat(K k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Table<K, V> init() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
