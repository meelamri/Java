package tec;

class CollectMem implements GreffonCollect{

	int passager;
	int arret;

	public CollectMem(){
		arret = 0;
		passager = 0;
	}

	public void uneEntree(){
		passager++;
		System.out.print("[MEMOIRE]Un passager entre dans le bus. Total: "+passager+"\n");		
	}

	public void uneSortie(){
		passager--;
		System.out.print("[MEMOIRE]Un passager sort du bus. Total: "+passager+"\n");	
	}

	public void changerArret(){
		arret++;
		System.out.print("[MEMOIRE]Changement d'arret. Arret: "+ arret +". Total passager: "+passager+"\n");
	}
}