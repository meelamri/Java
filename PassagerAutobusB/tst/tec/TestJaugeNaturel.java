package tec;

class TestJaugeNaturel {

	public void vrai(boolean expr, String str) {
		assert expr : "\n Vrai : < " + str + ">";
	}

	public void faux(boolean expr, String str) {
		assert !expr : "\n Faux : < " + str + ">";
	}

	public void testDansIntervalle() {
		JaugeNaturel jauge = new JaugeNaturel(67899, 100);
		faux(jauge.estRouge(), "testDansIntervalle : estRouge");
		vrai(jauge.estVert(), "testDansIntervalle : estVert");
		faux(jauge.estBleu(), "testDansIntervalle : estBleu");
	}

	public void testEgale() {
		JaugeNaturel jauge = new JaugeNaturel(100, 100);
		faux(jauge.estBleu(), "testEgale : estBleu");
		faux(jauge.estVert(), "testEgale : estVert");
		vrai(jauge.estRouge(), "testEgale : estRouge");
	}

	public void testDepartNegatif() {
		JaugeNaturel jauge = new JaugeNaturel(67899, -100);
		faux(jauge.estRouge(), "testDepartNegatif : estRouge");
		faux(jauge.estVert(), "testDepartNegatif : estVert");
		vrai(jauge.estBleu(), "testDepartNegatif : estBleu");
	}

	public void testDepartEgalZero() {
		JaugeNaturel jauge = new JaugeNaturel(67899, 0);
		faux(jauge.estRouge(), "testDepartEgalZero : estRouge");
		vrai(jauge.estVert(), "testDepartEgalZero : estVert");
		vrai(jauge.estBleu(), "testDepartEgalZero : estBleu");
	}

	public void testDeplacement() {
		JaugeNaturel jauge = new JaugeNaturel(67899, 3);
		jauge.decrementer();
		jauge.decrementer();
		jauge.decrementer();
		faux(jauge.estRouge(), "testDeplacementDecrementer : estRouge");
		vrai(jauge.estVert(), "testDeplacementDecrementer : estVert");
		vrai(jauge.estBleu(), "testDeplacementDecrementer : estBleu");
		jauge.incrementer();
		jauge.incrementer();
		jauge.incrementer();
		faux(jauge.estRouge(), "testDeplacementIncrementer: estRouge");
		vrai(jauge.estVert(), "testDeplacementIncrementer : estVert");
		faux(jauge.estBleu(), "testDeplacementIncrementer : estBleu");

	}

	public void testExceptionCasLimites() {
		try {
			JaugeNaturel inverse = new JaugeNaturel(-42, -10);
			assert false : "exception non levé, erreur critique";
		} catch (IllegalArgumentException e) {

		}
	}

	public void lancer() {
		int nbTest = 0;
		System.out.println(".");
		nbTest++;
		testDansIntervalle();
		System.out.println(".");
		nbTest++;
		testEgale();
		System.out.println(".");
		nbTest++;
		testDepartNegatif();
		System.out.println(".");
		nbTest++;
		testDepartEgalZero();
		System.out.println(".");
		nbTest++;
		testDeplacement();
		System.out.println("OK");
	}
}