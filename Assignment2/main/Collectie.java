package main;

import java.util.List;

public class Collectie<E> implements Clonable, CollectieInterface<E>, Data {

	private Lijst<natuurlijkGetal> natuurlijkGetalLijst;
	
	Collectie(){
		this.natuurlijkGetalLijst = new List[0];
	}
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void init() {
		this.natuurlijkGetalLijst = new List[0];
	}
	
	@Override
	boolean bevat(natuurlijkGetal n){
		return this.natuurlijkGetalLijst.bevat(n);	
	}

	@Override
	public boolean voegToe(E invoerElement) {
		if(!bevat(invoerElement)){
			this.natuurlijkGetalLijst.voegToe();
			return true;
		}
		return false;
	}

	@Override
	public boolean verwijder(E e) {
		this.natuurlijkGetalLijst.verwijder(e);

	}

	@Override
	public int lengte() {
		return this.natuurlijkGetalLijst.lengte();
	}

	@Override
	public boolean isLeeg() {
		return this.natuurlijkGetalLijst.isLeeg()
	}

	@Override
	public boolean equals(Collectie<E> meegegevenCollectie) {
		return this.natuurlijkGetalLijst.isGelijk(meegegevenCollectie);
	}

	@Override
	public E pak(int i){
		return this.natuurlijkGetalLijst.pak(i);
	}

	@Override
	public Collectie<E> vereniging(Collectie<E> meegegevenCollectie) {
		Collectie<E> vereniging = new Collectie<natuurlijkGetal>();
		for(natuurlijkGetal n : this.natuurlijkGetalLijst){
			vereniging.voegToe(n);
		}
		for(natuurlijkGetal n : meegegevenCollectie.natuurlijkGetalLijst){
			vereniging.voegToe(n);
		}
		return vereniging;
	}

	@Override
	public Collectie<E> verschil(Collectie<E> meegegevenCollectie) {
		Collectie<E> verschil = new Collectie<natuurlijkGetal>();
		for(natuurlijkGetal n : this.natuurlijkGetalLijst){
			if(!meegegevenCollectie.bevat(n)){
				verschil.voegToe(n);
			}
		}
		return verschil;
	}

	@Override
	public Collectie<E> intersectie(Collectie<E> meegegevenCollectie) {
		Collectie<E> intersectie = new Collectie<natuurlijkGetal>();
		for(natuurlijkGetal n : this.natuurlijkGetalLijst){
			if(meegegevenCollectie.bevat(n)){
				intersectie.voegToe(n);
			}
		}
		return intersectie;
	}

	@Override
	public Collectie<E> symVerschil(Collectie<E> meegegevenCollectie) {
		Collectie<E> verschil1 = this.verschil(meegegevenCollectie);
		Collectie<E> verschil2 = meegegevenCollectie.verschil(this);
		Collectie<E> symVerschil = verschil1.vereniging(verschil2);
		return symVerschil;
	}
}