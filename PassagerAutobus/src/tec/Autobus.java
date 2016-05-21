package tec;

import java.util.List;
import java.util.ArrayList;

class Autobus implements Bus, Transport {
	private ArrayList<Passager> passagers;
	private JaugeNaturel passagersAssis;
	private JaugeNaturel passagersDebout;
	private int numeroArret;

	public Autobus(int assis, int debout) {
		numeroArret = 0;
		if (assis < 0 || debout < 0) {
			throw new IllegalArgumentException();
		}
		passagersAssis = new JaugeNaturel(assis, 0);
		passagersDebout = new JaugeNaturel(debout, 0);
		passagers = new ArrayList<Passager>();
	}

	public boolean aPlaceAssise() {
		return passagersAssis.estVert();
	}

	public boolean aPlaceDebout() {
		return passagersDebout.estVert();
	}

	public void demanderPlaceAssise(Passager p) throws IllegalStateException {
		if (p.estAssis() || !p.estDehors()) {
			throw new IllegalStateException();
		}
		if (aPlaceAssise()) {
			p.accepterPlaceAssise();

			passagersAssis.incrementer();
			passagers.add(p);
		}
	}

	public void demanderPlaceDebout(Passager p) throws IllegalStateException {
		if (p.estDebout() || !p.estDehors()) {
			throw new IllegalStateException();
		}
		if (aPlaceDebout()) {
			p.accepterPlaceDebout();
			passagersDebout.incrementer();
			passagers.add(p);
		}
	}

	public void demanderSortie(Passager p) throws IllegalStateException {
		if (p.estDehors()) {
			throw new IllegalStateException();
		}
		if (p.estAssis()) {
			passagersAssis.decrementer();
		} else if (p.estDebout()) {
			passagersDebout.decrementer();
		}
		p.accepterSortie();
		passagers.remove(p);
	}

	public void demanderChangerEnDebout(Passager p)
			throws IllegalStateException {
		if (p.estDebout() || p.estDehors()) {
			throw new IllegalStateException();
		}
		if (p.estAssis() && aPlaceDebout()) {
			p.accepterPlaceDebout();
			passagersAssis.decrementer();
			passagersDebout.incrementer();
		}
	}

	public void demanderChangerEnAssis(Passager p) throws IllegalStateException {
		if (p.estAssis() || p.estDehors()) {
			throw new IllegalStateException();
		}
		if (p.estDebout() && aPlaceAssise()) {
			p.accepterPlaceAssise();
			passagersAssis.incrementer();
			passagersDebout.decrementer();
		}
	}

	public void allerArretSuivant() throws TecInvalidException {
		try {
			ArrayList<Passager> copie = new ArrayList<Passager>(passagers);
			numeroArret++;
			for (Passager p : copie) {
				p.nouvelArret(this, numeroArret);
				
			}
			
		} catch (IllegalStateException e) {
			throw new TecInvalidException(e.getCause());
		}
	}

	public String toString() {
		return ("[arret: " + numeroArret + ", assis: " + passagersAssis
				+ ", debout: " + passagersDebout + "]");
	}
}
