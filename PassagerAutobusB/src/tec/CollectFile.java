package tec;

import java.io.*;
import java.util.*;

class CollectFile implements GreffonCollect{

	int passager;
	int arret;
	File fichier;


	public CollectFile(String pathname){
		arret = 0;
		passager = 0;
		try{
			fichier = new File(pathname);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void uneEntree(){
		try{
			FileWriter fw = new FileWriter(fichier,true);
			passager++;
			fw.write("[FILE]Un passager entre dans le bus. Total: "+passager+"\n");
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void uneSortie(){
		try{
			FileWriter fw = new FileWriter(fichier,true);
			passager--;
			fw.write("[FILE]Un passager sort du bus. Total: "+passager+"\n");
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void changerArret(){
		try{
			FileWriter fw = new FileWriter(fichier,true);
			arret++;
			fw.write("[FILE]Changement d'arret. Arret: "+ arret +". Total passager: "+passager+"\n");
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}