package tec;

class Greffon extends Autobus{

	GreffonCollect collecte;

	public Greffon(int assis, int debout, GreffonCollect g){
		super(assis,debout);
		collecte = g;
	}

	public void demanderPlaceAssise(Passager p) throws IllegalStateException {
		if (super.aPlaceAssise()){
            collecte.uneEntree();
        }
		super.demanderPlaceAssise(p);
	}

	public void demanderPlaceDebout(Passager p) throws IllegalStateException {
		if (super.aPlaceDebout()){
            collecte.uneEntree();
        }
		super.demanderPlaceDebout(p);
	}

	public void demanderSortie(Passager p) throws IllegalStateException {
		super.demanderSortie(p);
		collecte.uneSortie();
	}

	public void allerArretSuivant() throws TecInvalidException {
		super.allerArretSuivant();
		collecte.changerArret();
	}

	public String toString() {
		return super.toString();
	}
}