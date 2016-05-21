package tec;

public class Fauxbus implements Bus, Transport {

	Messages messages = new Messages();

	public Fauxbus() {
	}

	public boolean aPlaceAssise() {
		return false;
	}

	public boolean aPlaceDebout() {
		return true;
	}

	public void demanderPlaceAssise(Passager p) {
		messages.add("demanderPlaceAssise");
	}

	public void demanderPlaceDebout(Passager p) {
		messages.add("demanderPlaceDebout");
	}

	public void demanderSortie(Passager p) {
		messages.add("demanderSortie");
	}

	public void demanderChangerEnDebout(Passager p) {
		messages.add("demanderChangerEnDebout");
	}

	public void demanderChangerEnAssis(Passager p) {
		messages.add("demanderChangerEnAssis");
	}

	public void allerArretSuivant() {
		messages.add("demanderAllerArretSuivant");
	}

		public void allerArretSuivant(Bus t) {
		messages.add("demanderAllerArretSuivant");
	}
}
