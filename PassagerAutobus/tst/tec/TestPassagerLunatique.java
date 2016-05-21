package tec;

public class TestPassagerLunatique extends TestPassagerAbstrait {

	protected PassagerAbstrait creerPassager(String nom, int destination) {
		PassagerAbstrait tmp = new Sportif(nom, destination,
				Nerveux.creerNerveux());
		return tmp;
	}

	public void testchoixPlaceMontee() {
		PassagerAbstrait test = new Sportif("A", 1, Nerveux.creerNerveux());
		Autobus t = new Autobus(2, 0);
		test.choixPlaceMontee(t);
		assert (test.estDehors());
	}

	public void testchoixChangerPlace() {
		PassagerAbstrait test = new Sportif("A", 2, Nerveux.creerNerveux());
		Autobus t = new Autobus(2, 2);
		try {
			test.monterDans(t);
		} catch (TecInvalidException e) {
			e.printStackTrace();
		}
		assert (test.estDebout());
		test.nouvelArret(t, 1);
		assert (test.estAssis());
	}
}
