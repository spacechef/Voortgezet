package main;

public class NatuurlijkGetal implements NatuurlijkGetalInterface {
	StringBuffer getallenArray;
	
	NatuurlijkGetal(){
		this.getallenArray = new StringBuffer();
	}
	
	@Override
	public void init(char c) {
		getallenArray = new StringBuffer();
		this.voegToe(c);
	}

	@Override
	public void voegToe(char c) {
		getallenArray.append(c);
	}

	@Override
	public int lengte() {
		return this.getallenArray.length();
	}

	@Override
	public char get(int i) {
		return this.getallenArray.charAt(i);
	}

}
