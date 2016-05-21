package tec;

import java.lang.String;

public class Calme implements Caractere {

	static final Calme singleton = new Calme();

	public static Calme creerCalme() {
		return singleton;
	}

	public void choixChangerPlace(Bus b, int arret, PassagerAbstrait p)
			throws IllegalStateException {
		// nothing
	}

}