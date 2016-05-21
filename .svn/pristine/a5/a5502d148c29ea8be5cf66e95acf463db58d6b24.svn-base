package tec;

import java.lang.String;

class Fatigue extends PassagerAbstrait {

	public Fatigue(String nom, int destination, Caractere c) {
		super(nom, destination, c);
	}

	void choixPlaceMontee(Bus b) throws IllegalStateException {
		if (b.aPlaceAssise())
			b.demanderPlaceAssise(this);
	}
}
