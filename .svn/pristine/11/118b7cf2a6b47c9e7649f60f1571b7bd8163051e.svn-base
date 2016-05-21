package tec;

public final class FabriqueTec {

	public static Usager FairePassagerStandard(String nom, int arret) {
		return new Repos(nom, arret, Calme.creerCalme());
	}

	public static Usager FairePassagerStresse(String nom, int arret) {
		return new Fatigue(nom, arret, Prudent.creerPrudent());
	}

	public static Usager FairePassagerLunatique(String nom, int arret) {
		return new Sportif(nom, arret, Nerveux.creerNerveux());
	}

	public static Usager FairePassagerReposPrudent(String nom, int arret) {
		return new Repos(nom, arret, Prudent.creerPrudent());
	}

	public static Usager FairePassagerFatigueCalme(String nom, int arret) {
		return new Fatigue(nom, arret, Calme.creerCalme());
	}

	public static Usager FairePassagerFatigueNerveux(String nom, int arret) {
		return new Fatigue(nom, arret, Nerveux.creerNerveux());
	}

	public static Usager FairePassagerSportifCalme(String nom, int arret) {
		return new Sportif(nom, arret, Calme.creerCalme());
	}

	public static Usager FairePassagerSportifPrudent(String nom, int arret) {
		return new Sportif(nom, arret, Prudent.creerPrudent());
	}

	public static Usager FairePassagerTetuNerveux(String nom, int arret) {
		return new Tetu(nom, arret, Nerveux.creerNerveux());
	}

	public static Usager FairePassagerTetuCalme(String nom, int arret) {
		return new Tetu(nom, arret, Calme.creerCalme());
	}

	public static Usager FairePassagerTetuPrudent(String nom, int arret) {
		return new Tetu(nom, arret, Prudent.creerPrudent());
	}

	public static Usager FairePassagerTetuPoli(String nom, int arret) {
		return new Tetu(nom, arret, Poli.creerPoli());
	}

	public static Usager FairePassagerTetuAgoraphobe(String nom, int arret) {
		return new Tetu(nom, arret, Agoraphobe.creerAgoraphobe());
	}

	public static Usager FairePassagerReposPoli(String nom, int arret) {
		return new Repos(nom, arret, Poli.creerPoli());
	}

	public static Usager FairePassagerReposAgoraphobe(String nom, int arret) {
		return new Repos(nom, arret, Agoraphobe.creerAgoraphobe());
	}

	public static Usager FairePassagerSportifPoli(String nom, int arret) {
		return new Sportif(nom, arret, Poli.creerPoli());
	}

	public static Usager FairePassagerSportifAgoraphobe(String nom, int arret) {
		return new Sportif(nom, arret, Agoraphobe.creerAgoraphobe());
	}

	public static Usager FairePassagerFatiguePoli(String nom, int arret) {
		return new Fatigue(nom, arret, Poli.creerPoli());
	}

	public static Usager FairePassagerFatigueAgoraphobe(String nom, int arret) {
		return new Fatigue(nom, arret, Agoraphobe.creerAgoraphobe());
	}

	public static Transport FaireAutobus(int assis, int debout) {
		return new Autobus(assis, debout);
	}

	public static Transport FaireGreffon(int assis, int debout) {
		return new Greffon(assis,debout,new CollectMem());
	}

	public static Transport FaireGreffonFile(int assis, int debout) {
		return new Greffon(assis,debout,new CollectFile("./data"));
	}
}
