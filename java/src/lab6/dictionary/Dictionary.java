package lab6.dictionary;

import java.util.HashMap;

public class Dictionary {

	HashMap<String, String> dictionary;

	public Dictionary() {
		dictionary = new HashMap<String, String>();
	}

	public void add(String en, String ua) {
		if (dictionary.containsKey(en)) {
			dictionary.replace(en, ua);
		} else {
			dictionary.put(en, ua);
		}
	}

	public String translate(String phrase) {
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
				translated.replace(" ", dictionary.get(word));
			}
			translation += translated + " ";
		}
		return translation.substring(0, translation.length() - 1);
	}
}
