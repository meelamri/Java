//classe faussaire de PassagerStandard
package tec;

public class FauxPassager implements Passager, Usager {
	/** passager assis à l'intérieur */
	static int ASSIS = 0;
	/** passager debout à l'intérieur */
	static int DEBOUT = 1;
	/** passager à l'extérieur */
	static int DEHORS = 2;
	private String nom;
	private int destination;
	// private EtatPassager monEtat;
	public int status;
	public Messages messages;

	public FauxPassager() {
		this(null, 50);
	}

	public FauxPassager(String nom, int destination) {
		this.nom = nom;
		this.destination = destination;
		status = DEHORS;
		messages = new Messages();
	}

	public String nom() {
		return null;
	}

	public boolean estDehors() {
		return (status == DEHORS);
	}

	public boolean estAssis() {
		return (status == ASSIS);
	}

	public boolean estDebout() {
		return (status == DEBOUT);
	}

	public void accepterSortie() {
		messages.add("accepterSortie");
		status = 2;
	}

	public void accepterPlaceAssise() {
		messages.add("accepterPlaceAssise");
		status = 0;
	}

	public void accepterPlaceDebout() {
		messages.add("accepterPlaceDebout");
		status = 1;
	}

	public void nouvelArret(Bus bus, int numeroArret) {
		messages.add("nouvelArret");
	}

	public void monterDans(Transport t) {
	}
}