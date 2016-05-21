package tec;

import java.lang.String;

public class Nerveux implements Caractere {

	static final Nerveux singleton = new Nerveux();

	public static Nerveux creerNerveux() {
		return singleton;
	}

	public void choixChangerPlace(Bus b, int arret, PassagerAbstrait p)
			throws IllegalStateException {
		if (p.estAssis()) {
			b.demanderChangerEnDebout(p);
		} else if (p.estDebout()) {
			b.demanderChangerEnAssis(p);
		}
	}

}