package tec;

class Greffon implements Bus, Transport {
 
    private GreffonCollect collecte;
    private Bus bus;

    public Greffon(Transport t,GreffonCollect g) {
	bus = (Bus) t;
	collecte = g;
    }
    
    public boolean aPlaceAssise(){
	return bus.aPlaceAssise();
    }
    
    public boolean aPlaceDebout(){
	return bus.aPlaceDebout();
    }
    
    public void demanderPlaceAssise(Passager p) throws IllegalStateException{
        if (aPlaceAssise()){
            collecte.uneEntree();
        }
	    bus.demanderPlaceAssise(p);
    }

    public void demanderPlaceDebout(Passager p) throws IllegalStateException{
        if (aPlaceDebout()){
            collecte.uneEntree();
        }
	    bus.demanderPlaceDebout(p);
    }
    
    public void demanderSortie(Passager p) throws IllegalStateException{
	bus.demanderSortie(p);
	collecte.uneSortie();
    }

    public void demanderChangerEnDebout(Passager p) throws IllegalStateException{
	bus.demanderChangerEnDebout(p);
    }
    
    public void demanderChangerEnAssis(Passager p) throws IllegalStateException{
	bus.demanderChangerEnAssis(p);
    }
    
    public void allerArretSuivant() throws TecInvalidException{
	bus.allerArretSuivant(this);
	collecte.changerArret();
    }

    public void allerArretSuivant(Bus b) throws TecInvalidException{
    bus.allerArretSuivant(b);
    collecte.changerArret();
    }

    public String toString() {
        return bus.toString();
    }
}
