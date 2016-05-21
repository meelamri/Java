package tec;

class TestEtatPassager {

	public void testExterieur() {
		EtatPassager test = EtatPassager.creer();
		assert (!test.estAssis());
		assert (!test.estDebout());
		assert (test.estExterieur());
		assert (!test.estInterieur());

	}

	public void testAssis() {
		EtatPassager test = EtatPassager.creer();
		test = test.assis();
		assert (test.estAssis());
		assert (!test.estDebout());
		assert (!test.estExterieur());
		assert (test.estInterieur());
	}

	public void testDebout() {
		EtatPassager test = EtatPassager.creer();
		test = test.debout();
		assert (!test.estAssis());
		assert (test.estDebout());
		assert (!test.estExterieur());
		assert (test.estInterieur());
	}

	public void testDehors() {
		EtatPassager test = EtatPassager.creer();
		test = test.dehors();
		assert (test.estExterieur());
		assert (!test.estInterieur());
		assert (!test.estAssis());
		assert (!test.estDebout());
	}

	public void lancer() {
		System.out.println(".");
		testExterieur();
		System.out.println(".");
		testAssis();
		System.out.println(".");
		testDebout();
		System.out.println(".");
		testDehors();
		System.out.println("(4):OK: " + getClass().getName());

	}
}
