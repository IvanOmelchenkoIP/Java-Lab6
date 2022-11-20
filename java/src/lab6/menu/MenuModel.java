package lab6.menu;

import lab6.dictionary.TranslateDictionaryController;

class MenuOptions {

	public final static String MENU_ADD_PARE = "1";
	public final static String MENU_TRANSLATE = "2";
	public final static String MENU_EXIT = "3";
}

public class MenuModel {

	private TranslateDictionaryController dictionary;

	public void setControllers(TranslateDictionaryController dictionary) {
		this.dictionary = dictionary;
	}

	public int processCommand(String command) {
		int status;
		switch (command) {
		case MenuOptions.MENU_ADD_PARE -> status = MenuStates.STATUS_ADD_PARE;
		case MenuOptions.MENU_TRANSLATE -> status = MenuStates.STATUS_TRANSLATE;
		case MenuOptions.MENU_EXIT -> status = MenuStates.STATUS_EXIT;
		default -> status = MenuStates.STATUS_INCORRECT_COMMAND;
		}
		return status;
	}

	public void add(String en, String ua) {
		dictionary.add(en, ua);
	}

	public void translate(String phrase) {
		dictionary.translate(phrase);
	}
}
