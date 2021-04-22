package exception;

public class ChooseCharacterFailException extends Exception {
	public String message;

	public ChooseCharacterFailException(String massage) {
		super(massage);
	}
}
