package tec;

import java.lang.String;

public class Prudent implements Caractere {

	static final Prudent singleton = new Prudent();

	public static Prudent creerPrudent() {
		return singleton;
	}

	public void choixChangerPlace(Bus b, int arret, PassagerAbstrait p)
			throws IllegalStateException {
		if (p.distanceRelative(arret) < 3) {
			b.demanderChangerEnDebout(p);
		} else if (p.distanceRelative(arret) > 5) {
			b.demanderChangerEnAssis(p);
		}
	}

}