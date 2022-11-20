package lab6.exceptions;

public class NoTranslationException extends Exception {

	public NoTranslationException() {
		super();
	}

	public NoTranslationException(String str) {
		super(str);
	}

	public NoTranslationException(String str, Throwable ex) {
		super(str, ex);
	}

	public NoTranslationException(Throwable ex) {
		super(ex);
	}
}
