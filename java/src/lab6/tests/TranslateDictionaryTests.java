package lab6.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lab6.dictionary.TranslateDictionaryModel;
import lab6.exceptions.NoTranslationException;

class TranslateDictionaryTests {

	@Test
	void TestAddPare() {
		String[] expected = { "word", "слово" };

		TranslateDictionaryModel dictionary = new TranslateDictionaryModel();
		String[] result = dictionary.addWordPare("word", "слово");

		assertTrue(Arrays.equals(expected, result));
	}

	@Test
	void TestAddPareWrong() {
		String[] expected = { "word", "слово" };

		TranslateDictionaryModel dictionary = new TranslateDictionaryModel();
		String[] result = dictionary.addWordPare("word data", "слово data");

		assertTrue(Arrays.equals(expected, result));
	}

	@Test
	void TestTranslateWordUnadded() {
		String expected = "No translation found for word: word";

		TranslateDictionaryModel dictionary = new TranslateDictionaryModel();
		Exception exception = assertThrows(Exception.class, () -> {
			dictionary.translate("word");
		});

		assertTrue(exception instanceof NoTranslationException);
		assertEquals(expected, exception.getMessage());
	}

	@Test
	void TestTranslateWordAdded() {
		String expected = "слово";

		TranslateDictionaryModel dictionary = new TranslateDictionaryModel();
		dictionary.addWordPare("word data", "слово data");
		try {
			String result = dictionary.translate("word");
			assertEquals(expected, result);
		} catch (Exception exception) {
			fail(exception.getMessage());
		}
	}

	@Test
	void TestTranslatePhraseUnadded() {
		String expected = "No translation found for word: translator";

		TranslateDictionaryModel dictionary = new TranslateDictionaryModel();
		dictionary.addWordPare("word data", "слово data");
		dictionary.addWordPare("to", "щоб");
		dictionary.addWordPare("check", "перевірити");
		Exception exception = assertThrows(Exception.class, () -> {
			dictionary.translate("word, to check translator 1");
		});

		assertTrue(exception instanceof NoTranslationException);
		assertEquals(expected, exception.getMessage());
	}

	@Test
	void TestTranslatePhraseAdded() {
		String expected = "слово, щоб перевірити перекладач 1";

		TranslateDictionaryModel dictionary = new TranslateDictionaryModel();
		dictionary.addWordPare("word", "слово");
		dictionary.addWordPare("to", "щоб");
		dictionary.addWordPare("check", "перевірити");
		dictionary.addWordPare("translator", "перекладач");
		try {
			String result = dictionary.translate("word, to check translator 1");
			assertEquals(expected, result);
		} catch (Exception exception) {
			fail(exception.getMessage());
		}
	}

}
