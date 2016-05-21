package tec;

import java.lang.String;

abstract class PassagerAbstrait implements Passager, Usager {

	private String nom;
	private int destination;
	private EtatPassager etat;
	private Caractere caractere;

	public PassagerAbstrait(String nom, int destination, Caractere c) {
		this.nom = nom;
		if (destination < 0) {
			throw new IllegalArgumentException();
		}
		this.destination = destination;
		etat = EtatPassager.creer();
		caractere = c;
	}

	protected int distanceRelative(int numArret) {
		return Math.abs(numArret - destination);
	}

	final public void nouvelArret(Bus bus, int numeroArret)
			throws IllegalStateException {

		if (distanceRelative(numeroArret) == 0) {
			bus.demanderSortie(this);
		}
		caractere.choixChangerPlace(bus, numeroArret, this);

	}

	final public void monterDans(Transport t) throws TecInvalidException {
		if (!(t instanceof Bus)) {
			throw new TecInvalidException();
		}
		try {
			choixPlaceMontee((Bus) t);
		} catch (IllegalStateException e) {
			throw new TecInvalidException(e.getCause());
		}
	}

	abstract void choixPlaceMontee(Bus b);

	public void accepterPlaceAssise() {
		etat = etat.assis();
	}

	public void accepterSortie() {
		etat = etat.dehors();
	}

	public void accepterPlaceDebout() {
		etat = etat.debout();
	}

	public String nom() {
		return nom;
	}

	public boolean estDehors() {
		return etat.estExterieur();
	}

	public boolean estDebout() {
		return etat.estDebout();
	}

	public boolean estAssis() {
		return etat.estAssis();
	}

	public String toString() {
		String tmp = nom + " ";
		if (etat.estExterieur())
			tmp += "dehors";
		else if (etat.estAssis())
			tmp += "assis";
		else if (etat.estDebout())
			tmp += "debout";
		else
			tmp += "erreur";

		return tmp;
	}
}
