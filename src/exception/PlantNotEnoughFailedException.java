package exception;

public class PlantNotEnoughFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlantNotEnoughFailedException(String message) {
		super(message);
	}

}
