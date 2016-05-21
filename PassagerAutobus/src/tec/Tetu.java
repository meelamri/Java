package tec;

import java.lang.String;

class Tetu extends PassagerAbstrait {

	public Tetu(String nom, int destination, Caractere c) {
		super(nom, destination, c);
	}

	void choixPlaceMontee(Bus b) throws IllegalStateException {
		b.demanderPlaceDebout(this);
	}

}
