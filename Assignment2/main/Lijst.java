package main;

public class Lijst<E> implements ListInterface<E>, Clonable {

	private Node head;
	private Node current;
	private Node last;
	private int aantalElementen;
	
	public Lijst () {
		this.head = new Node(null);
		this.current = this.head;
		this.last = this.head;
		this.aantalElementen = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public int size() {
		return this.aantalElementen;
	}

	@Override
	public E retrieve() {
		return this.current.data;
	}

	@Override
	public boolean find(E d) {
		return false;
	}

	@Override
	public boolean setFirst() {
		if(this.isEmpty()){
			return false;
		}
		this.current = this.head;		
		return true;
	}

	@Override
	public boolean setLast() {
		if(this.isEmpty()){
			return false;
		}
		this.current = this.last;
		return false;
	}

	@Override
	public boolean getNext() {
		if(this.isEmpty() || this.current == this.last){
			return false;
		}
		this.current = current.next;
		return true;
	}

	@Override
	public boolean getPrior() {
		if(this.isEmpty() || this.current == this.head){
			return false;
		}
		this.current = current.prior;
		return true;
	}

	@Override
	public Lijst<E> init() { 
		return new Lijst();
	}

	@Override
	public Lijst<E> insert(E d) {
		
		return null;
	}

	@Override
	public Lijst<E> remove() {
		// TODO Auto-generated method stub
		return null;
	}

}
