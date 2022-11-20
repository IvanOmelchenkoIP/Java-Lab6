package lab6.dictionary;

public class TranslateDictionaryView {
	public final static String ADD_SUCCESS = "A pare of words successfully added...\n";

	public final static String TRANSLATE_SUCCESS = "Translation of a phrase:";
	public final static String TRANSLATE_ERROR = "Translation not successful:";

	public void showSuccess(String msg) {
		System.out.println(msg + "\n");
	}
	
	public void showTranslation(String msg, String translation) {
		System.out.println(msg);
		System.out.println(translation + "\n");
	}

	public void showException(String msg, Exception exception) {
		System.out.println(msg);
		System.out.println(exception.getMessage() + "\n");
	}
}