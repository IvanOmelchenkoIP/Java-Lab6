package lab6.menu;

import lab6.dictionary.TranslateDictionary;
import lab6.scanner.InputScanner;

public class MenuController {

	private boolean runFlag;
	
	private MenuModel model;
	private MenuView view;
	
	public MenuController(MenuModel model, MenuView view) {
		this.model = model;
		this.view = view;
	}
	
	public void launch(TranslateDictionary dictionary, InputScanner scanner) {
		model.setControllers(dictionary);
	}
	
}