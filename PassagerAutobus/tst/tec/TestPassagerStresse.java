package tec;

public class TestPassagerStresse extends TestPassagerAbstrait {
	protected PassagerAbstrait creerPassager(String nom, int destination) {
		PassagerAbstrait tmp = new Fatigue(nom, destination,
				Prudent.creerPrudent());
		return tmp;
	}

	public void testchoixPlaceMontee() {
		PassagerAbstrait test = new Fatigue("A", 1, Prudent.creerPrudent());
		Autobus t = new Autobus(0, 2);
		test.choixPlaceMontee(t);
		assert (test.estDehors());
	}

	public void testchoixChangerPlace() {
		PassagerAbstrait test = new Fatigue("A", 2, Prudent.creerPrudent());
		Autobus t = new Autobus(2, 2);
		try {
			test.monterDans(t);
		} catch (TecInvalidException e) {
			e.printStackTrace();
		}
		assert (test.estAssis());
		test.nouvelArret(t, 1);
		assert (test.estDebout());
	}
}
