package lab6.dictionary;

import java.util.HashMap;

import lab6.exceptions.NoTranslationException;

public class TranslateDictionaryModel {

	HashMap<String, String> dictionary;

	public TranslateDictionaryModel() {
		dictionary = new HashMap<String, String>();
	}

	public void addWordPare(String en, String ua) {
		en = en.split("\\s+")[0];
		ua = ua.split("\\s+")[0];
		if (dictionary.containsKey(en)) {
			dictionary.replace(en, ua);
		} else {
			dictionary.put(en, ua);
		}
	}

	public String translate(String phrase) throws NoTranslationException {
		String translation = "";
		String[] words = phrase.split("\\s+");
		for (String word : words) {
			String translated = "";
			if (word.matches("[+-]?\\d+(.\\d+)?") || word.matches("\\W")) {
				translated = word;
			} else {
				String first = Character.toString(word.charAt(0));
				String last = Character.toString(word.charAt(word.length() - 1));
				if (first.matches("\\W")) {
					word = word.substring(1);
					translated += first;
				}
				if (last.matches("\\W")) {
					word = word.substring(0, word.length() - 1);
					translated += " " + last;
				}
				String translatedWord = dictionary.get(word);
				if (translatedWord == null) {
					throw new NoTranslationException("No translation found for word: " + word);
				}
				translated.replace(" ", translatedWord);
			}
			translation += translated + " ";
		}
		return translation.substring(0, translation.length() - 1);
	}
}
