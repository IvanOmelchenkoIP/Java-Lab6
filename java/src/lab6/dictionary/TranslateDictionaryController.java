package lab6.dictionary;

import lab6.exceptions.NoTranslationException;

public class TranslateDictionaryController {

	TranslateDictionaryModel model;
	TranslateDictionaryView view;

	public TranslateDictionaryController(TranslateDictionaryModel model, TranslateDictionaryView view) {
		this.model = model;
		this.view = view;
	}

	public void addWordPare(String en, String ua) {
		String[] pare = model.addWordPare(en, ua);
		view.showAddSuccess(TranslateDictionaryView.ADD_SUCCESS, pare[0], pare[1]);
	}

	public void translate(String phrase) {
		try {
			String translation = model.translate(phrase);
			view.showTranslation(TranslateDictionaryView.TRANSLATE_SUCCESS, translation);
		} catch (NoTranslationException exception) {
			view.showException(TranslateDictionaryView.TRANSLATE_ERROR, exception);
		}
	}
}
