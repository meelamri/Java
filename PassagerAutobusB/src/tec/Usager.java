package tec;

public interface Usager {
	String nom();

	void monterDans(Transport b) throws TecInvalidException;
}
