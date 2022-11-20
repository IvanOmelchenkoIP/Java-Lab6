package lab6.menu;

public class MenuView {
	public final static String MENU = "1) add pare of words\n" + "2) translate phrase\n" + "3) exit\n";
	public final static String MENU_INPUT_FIELD = "Enter a corresponding number to continue: ";
	
	public final static String EN_INPUT = "Input a single word in English: ";
	public final static String UA_INPUT = "Enter a single word in Ukrainian: ";
	public final static String PHRASE_INPUT = "Enter a phrase to translate: ";

	public final static String COMMAND_ERROR = "Error! Invalid command!\n\n";

	public final static String EXIT = "Exiting the program...\n\n";

	public void showMessage(String msg) {
		System.out.print(msg);
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
