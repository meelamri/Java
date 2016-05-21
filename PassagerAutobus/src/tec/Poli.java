package tec;

import java.lang.String;

public class Poli implements Caractere {

	static final Poli singleton = new Poli();

	public static Poli creerPoli() {
		return singleton;
	}

	public void choixChangerPlace(Bus b, int arret, PassagerAbstrait p)
			throws IllegalStateException {
		if (!b.aPlaceAssise()) {
			b.demanderChangerEnDebout(p);
		}
	}

}