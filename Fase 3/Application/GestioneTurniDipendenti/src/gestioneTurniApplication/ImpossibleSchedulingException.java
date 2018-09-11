package gestioneTurniApplication;

public class ImpossibleSchedulingException extends Exception {

	private static final long serialVersionUID = 1L;

	public ImpossibleSchedulingException(String message) {
		super(message);
	}
}