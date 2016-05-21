package tec;

import java.lang.String;

class Sportif extends PassagerAbstrait {

	public Sportif(String nom, int destination, Caractere c) {
		super(nom, destination, c);
	}

	void choixPlaceMontee(Bus b) throws IllegalStateException {
		if (b.aPlaceDebout()) {
			b.demanderPlaceDebout(this);
		}
	}

}
