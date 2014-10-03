package main;

public class Identifier implements IdentifierInterface {
	
	StringBuffer karakterArray;
	
	Identifier(){
		karakterArray = new StringBuffer();
		voegToe('L');
		voegToe('E');
		voegToe('E');
		voegToe('G');
	}
	
	@Override
	public void init(char c) {
		karakterArray = new StringBuffer();
		this.voegToe(c);
	}

	@Override
	public void voegToe(char c) {
		this.karakterArray.append(c);
	}

	@Override
	public int lengte() {
		return this.karakterArray.length();
	}

	@Override
	public char get(int i) {
		return this.karakterArray.charAt(i);
	}

}
