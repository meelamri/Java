package tec;

public abstract class TestPassagerAbstrait {

	abstract protected PassagerAbstrait creerPassager(String nom,
			int destination);

	public void testAccepterPlaceAssise() {
		PassagerAbstrait test = creerPassager("A", 1);
		test.accepterPlaceAssise();
		assert (!test.estDebout());
		assert (test.estAssis());
	}

	public void testAccepterSortir() {
		PassagerAbstrait test = creerPassager("A", 1);
		test.accepterSortie();
		assert (test.estDehors());
	}

	public void testAccepterPlaceDebout() {
		PassagerAbstrait test = creerPassager("A", 1);
		test.accepterPlaceDebout();
		assert (test.estDebout());
		assert (!test.estAssis());
	}

	public void testMonterDans() {
		PassagerAbstrait test = creerPassager("A", 1);
		Autobus t = new Autobus(2, 2);
		try {
			test.monterDans(t);
		} catch (TecInvalidException e) {

		}
		assert (!test.estDehors());
	}

	public void testExeceptionMonterDans() {
		PassagerAbstrait test = creerPassager("A", 1);
		Transport t = new Transport() {
			public void allerArretSuivant() throws TecInvalidException {
			}

			public boolean aPlaceAssise() {
				return false;
			}

			public boolean aPlaceDebout() {
				return false;
			}
		};
		try {
			test.monterDans(t);
		} catch (TecInvalidException e) {
			assert e != null;
		}
	}

}
