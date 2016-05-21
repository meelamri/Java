package tec;

class TestPassagerStandard extends TestPassagerAbstrait {

	protected PassagerAbstrait creerPassager(String nom, int destination) {
		PassagerAbstrait tmp = new Repos(nom, destination, Calme.creerCalme());
		return tmp;
	}

	public void testchoixPlaceMontee() {
		PassagerAbstrait test = new Repos("A", 1, Calme.creerCalme());
		Autobus t = new Autobus(2, 2);
		test.choixPlaceMontee(t);
		assert (!test.estDehors() && test.estAssis());
	}

	public void testchoixChangerPlace() {
		PassagerAbstrait test = new Repos("A", 2, Calme.creerCalme());
		Autobus t = new Autobus(2, 2);
		try {
			test.monterDans(t);
		} catch (TecInvalidException e) {
			e.printStackTrace();
		}
		assert (test.estAssis());
		test.nouvelArret(t, 1);
		assert (test.estAssis());
	}

	// void Faussaire() {
	// testAccepterPlaceAssise();
	// System.out.print(".\n");
	// testAccepterSortir();
	// System.out.print(".\n");
	// testAccepterPlaceDebout();
	// System.out.print(".\n");
	// testMonterDans();
	// System.out.print(".\n");
	// }
	//
	// void lancer() {
	// int nbTest = 0;
	//
	// nbTest = 4;
	// Faussaire();
	//
	// System.out.println("(" + nbTest + "):OK: " + getClass().getName());
	// }

}
