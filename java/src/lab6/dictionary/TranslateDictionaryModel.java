package lab6.dictionary;

import java.util.HashMap;

import lab6.exceptions.NoTranslationException;

public class TranslateDictionaryModel {

	HashMap<String, String> dictionary;

	public TranslateDictionaryModel() {
		dictionary = new HashMap<String, String>();
	}

	public String[] addWordPare(String en, String ua) {
		en = en.split("\\s+")[0];
		ua = ua.split("\\s+")[0];
		if (dictionary.containsKey(en)) {
			dictionary.replace(en, ua);
		} else {
			dictionary.put(en, ua);
		}
		String[] pare = { en, ua };
		return pare;
	}

	public String translate(String phrase) throws NoTranslationException {
		String translation = "";
		String[] words = phrase.split("\\s+");
		for (String word : words) {
			if (word.matches("[^a-zA-Z]+")) {
				translation += word + " ";
			} else {
				String translated = " ";
				String first = Character.toString(word.charAt(0));
				String last = Character.toString(word.charAt(word.length() - 1));
				if (first.matches("\\W")) {
					word = word.substring(1);
					translated = first + translated;
				}
				if (last.matches("\\W")) {
					word = word.substring(0, word.length() - 1);
					translated += last;
				}
				String translatedWord = dictionary.get(word);
				if (translatedWord == null) {
					throw new NoTranslationException("No translation found for word: " + word);
				}
				translation += translated.replace(" ", translatedWord) + " ";
			}
		}
		return translation.substring(0, translation.length() - 1);
	}
}
