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
		model.addWordPare(en, ua);
		view.showSuccess(TranslateDictionaryView.ADD_SUCCESS);
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
