package tec;

class TestAutobus {

	public void testInstanciation() {
		Autobus[] a = { new Autobus(50, 0), new Autobus(0, 50) };

		assert a[0].aPlaceAssise() == true;
		assert a[0].aPlaceDebout() == false;
		assert a[1].aPlaceDebout() == true;
		assert a[1].aPlaceAssise() == false;
	}

	public void testDemanderPlace() {
		FauxPassager[] faux = { null, new FauxPassager(), new FauxPassager(),
				new FauxPassager(), new FauxPassager(), new FauxPassager(),
				new FauxPassager(), new FauxPassager(), new FauxPassager(),
				new FauxPassager() };

		Autobus bus = new Autobus(5, 3);
		for (int i = 1; i <= 5; i++) {

			bus.demanderPlaceAssise(faux[i]);

			// test etat.
			if (i == 5)
				assert false == bus.aPlaceAssise() : "fin assis";
			else
				assert true == bus.aPlaceAssise() : "demande " + i;
		}

		// test interaction.
		for (int i = 1; i <= 5; i++) {
			assert 1 == faux[i].messages.size() : "faux " + i;
			assert "accepterPlaceAssise" == faux[i].messages.getLast() : "message "
					+ i;
		}

		for (int i = 6; i <= 8; i++) {

			// test etat.
			assert true == bus.aPlaceDebout() : "demande " + i;

			bus.demanderPlaceDebout(faux[i]);

			if (i == 8)
				assert false == bus.aPlaceDebout() : "fin debout";
		}

		// test interaction.
		for (int i = 6; i <= 8; i++) {
			assert "accepterPlaceDebout" == faux[i].messages.getLast() : "message "
					+ i;
		}

		/*******************************************/
		bus.demanderSortie(faux[1]);
		bus.demanderSortie(faux[8]);

		// test etat.
		assert true == bus.aPlaceDebout() : "non dispo debout";
		assert true == bus.aPlaceAssise() : "non dispo assis ";

		// test interaction.
		assert "accepterSortie" == faux[1].messages.getLast() : "message 1";
		assert "accepterSortie" == faux[8].messages.getLast() : "message 8";
	}

	void testArret() {
		FauxPassager[] faux = { null, new FauxPassager(), new FauxPassager(),
				new FauxPassager(), new FauxPassager(), new FauxPassager(),
				new FauxPassager(), new FauxPassager(), new FauxPassager(),
				new FauxPassager() }; // 9

		Autobus bus = new Autobus(5, 3);

		bus.demanderPlaceAssise(faux[1]);
		bus.demanderPlaceAssise(faux[2]);
		bus.demanderPlaceDebout(faux[8]);

		// test interaction.
		assert "accepterPlaceAssise" == faux[1].messages.getLast() : "message 1";
		assert "accepterPlaceAssise" == faux[2].messages.getLast() : "message 2";
		assert "accepterPlaceDebout" == faux[8].messages.getLast() : "message 8";

		// Cast car Bus ne contient plus allerArretSuivant, c'est
		// Transport qui le contient
		try {
			((Transport) bus).allerArretSuivant();
		} catch (TecInvalidException e) {
		}

		bus.demanderSortie(faux[1]);
		bus.demanderSortie(faux[8]);

		// test interaction.
		assert "accepterSortie" == faux[1].messages.getLast() : "message 1";
		assert "accepterSortie" == faux[8].messages.getLast() : "message 8";
	}

	public void testExceptionAllerArretSuivant() {
		Autobus bus = new Autobus(5, 3);
		Passager anonyme = new Passager() {
			private EtatPassager etat = EtatPassager.creer();

			public String nom() {
				return "anonyme";
			}

			public boolean estDehors() {
				return etat.estExterieur();
			}

			public boolean estAssis() {
				return etat.estAssis();
			}

			public boolean estDebout() {
				return etat.estDebout();
			}

			public void accepterSortie() {
			}

			public void accepterPlaceAssise() {
			}

			public void accepterPlaceDebout() {
			}

			public void nouvelArret(Bus b, int numeroArret)
					throws IllegalStateException {
				throw new IllegalStateException();
			}

		};
		bus.demanderPlaceAssise(anonyme);
		try {
			((Transport) bus).allerArretSuivant();
		} catch (TecInvalidException e) {
			assert e != null;
		}
	}

	/*
	 * Changer un assis en debout Changer un debout en assis
	 */
	void testChanger() {
		FauxPassager[] faux = { null, new FauxPassager(), new FauxPassager(),
				new FauxPassager(), new FauxPassager(), new FauxPassager(),
				new FauxPassager(), new FauxPassager(), new FauxPassager(),
				new FauxPassager() }; // 9

		Autobus bus = new Autobus(5, 3);

		for (int i = 1; i <= 5; i++)
			bus.demanderPlaceAssise(faux[i]);

		for (int i = 6; i <= 8; i++)
			bus.demanderPlaceDebout(faux[i]);

		bus.demanderChangerEnDebout(faux[1]);

		// test interaction.
		assert "accepterPlaceDebout" != faux[1].messages.getLast() : "message 1";

		bus.demanderChangerEnAssis(faux[7]);

		// test interaction.
		assert "accepterPlaceAssise" != faux[7].messages.getLast() : "message 7";
	}

	void testFaussaire() {
		FauxPassager p = new FauxPassager("POO", 20);
		p.accepterSortie();
		// assert false;
	}

	void lancer() {
		int nbTest = 0;

		System.out.print('.');
		nbTest++;
		testFaussaire();

		System.out.print('.');
		nbTest++;
		testInstanciation();

		System.out.print('.');
		nbTest++;
		testDemanderPlace();

		System.out.print('.');
		nbTest++;
		testArret();

		System.out.print('.');
		nbTest++;
		testChanger();

		System.out.println("(" + nbTest + "):OK: " + getClass().getName());
	}
}