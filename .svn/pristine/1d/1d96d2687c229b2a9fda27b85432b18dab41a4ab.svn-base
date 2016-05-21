package tec;

import java.lang.String;

class Repos extends PassagerAbstrait {

	public Repos(String nom, int destination, Caractere c) {
		super(nom, destination, c);
	}

	void choixPlaceMontee(Bus b) throws IllegalStateException {
		if (b.aPlaceAssise()) {
			b.demanderPlaceAssise(this);
		} else if (b.aPlaceDebout()) {
			b.demanderPlaceDebout(this);
		}
	}

}
