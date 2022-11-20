package lab6;

import lab6.dictionary.*;
import lab6.menu.*;
import lab6.scanner.InputScanner;

public class Main {

	public static void main(String[] args) {
		MenuModel model = new MenuModel();
		MenuView view = new MenuView();
		MenuController menu = new MenuController(model, view);

		TranslateDictionaryModel dictionaryModel = new TranslateDictionaryModel();
		TranslateDictionaryView dictionaryView = new TranslateDictionaryView();
		TranslateDictionaryController dictionary = new TranslateDictionaryController(dictionaryModel, dictionaryView);
		InputScanner scanner = new InputScanner();
		menu.launch(dictionary, scanner);
	}

}
