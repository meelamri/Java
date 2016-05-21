package tec;

import java.lang.String;

public class Agoraphobe implements Caractere {

	static final Agoraphobe singleton = new Agoraphobe();

	public static Agoraphobe creerAgoraphobe() {
		return singleton;
	}

	public void choixChangerPlace(Bus b, int arret, PassagerAbstrait p)
			throws IllegalStateException {
		if (!b.aPlaceAssise() || !b.aPlaceDebout()) {
			b.demanderSortie(p);
		}
	}

}