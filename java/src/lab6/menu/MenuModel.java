package lab6.menu;

import java.io.IOException;

import lab6.dictionary.TranslateDictionary;

class MenuOptions {

	public final static String MENU_ADD_PARE = "1";
	public final static String MENU_TRANSLATE = "2";
	public final static String MENU_EXIT = "3";
}

public class MenuModel {

	private TranslateDictionary dictionary;
	
	public void setControllers(TranslateDictionary dictionary) {
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

	public void tagsByAlphabet(String en, String ua) throws IOException {
		try {
			dictionary.add(en, ua); 
		} catch (IOException exception) {
			throw exception;
		}
	}

	public void tagsByOccurence(String phrase) throws IOException {
		try {
			dictionary.translate(phrase);
		} catch (IOException exception) {
			throw exception;
		}
	}
}
