package lab6.menu;

import lab6.dictionary.TranslateDictionaryController;
import lab6.scanner.InputScanner;

public class MenuController {

	private boolean runFlag;

	private MenuModel model;
	private MenuView view;

	public MenuController(MenuModel model, MenuView view) {
		this.model = model;
		this.view = view;
	}

	public void launch(TranslateDictionaryController dictionary, InputScanner scanner) {
		runFlag = true;
		model.setControllers(dictionary);
		while (runFlag) {
			view.showMessage(MenuView.MENU);
			view.showMessage(MenuView.MENU_INPUT_FIELD);
			String input = scanner.scanInput();
			int state = model.processCommand(input);
			processMenuState(state, scanner);
		}
		view.showMessage(MenuView.EXIT);
		scanner.close();
	}

	private void processMenuState(int state, InputScanner scanner) {
		switch (state) {
		case MenuStates.STATUS_INCORRECT_COMMAND -> view.showMessage(MenuView.COMMAND_ERROR);
		case MenuStates.STATUS_EXIT -> runFlag = false;
		case MenuStates.STATUS_ADD_PARE -> addWordPare(scanner);
		case MenuStates.STATUS_TRANSLATE -> translate(scanner);
		}
	}

	private void addWordPare(InputScanner scanner) {
		view.showMessage(MenuView.EN_INPUT);
		String en = scanner.scanInput();
		view.showMessage(MenuView.UA_INPUT);
		String ua = scanner.scanInput();
		model.addWordPare(en, ua);
	}

	private void translate(InputScanner scanner) {
		view.showMessage(MenuView.PHRASE_INPUT);
		String phrase = scanner.scanInput();
		model.translate(phrase);
	}

}
