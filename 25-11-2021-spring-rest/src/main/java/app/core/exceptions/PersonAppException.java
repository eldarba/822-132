package app.core.exceptions;

public class PersonAppException extends Exception {

	private static final long serialVersionUID = 1L;

	public PersonAppException() {
	}

	public PersonAppException(String message) {
		super(message);
	}

	public PersonAppException(Throwable cause) {
		super(cause);
	}

	public PersonAppException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
