package tec;

public class TecInvalidException extends Exception {

	/**
	 * 
	 */
	public TecInvalidException() {
		super();
	}

	public TecInvalidException(String s) {
		super(s);
	}

	public TecInvalidException(Throwable e){
		super(e);
	}
}
