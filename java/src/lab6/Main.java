package lab6;

import lab6.dictionary.TranslateDictionary;
import lab6.menu.*;
import lab6.scanner.InputScanner;

public class Main {

	public static void main(String[] args) {
		MenuModel model = new MenuModel();
		MenuView view = new MenuView();
		MenuController menu = new MenuController(model, view);

		TranslateDictionary dictionary = new TranslateDictionary();
		InputScanner scanner = new InputScanner();
		menu.launch(dictionary, scanner);
	}

}
