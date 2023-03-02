package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import telran.util.WordsIMPL;

class WordsTest {
	WordsIMPL str = new WordsIMPL();

	@BeforeEach
	void setUp() throws Exception {
		str.addWord("First");
		str.addWord("Two");
		str.addWord("Three");
		str.addWord("Four");
		str.addWord("Five");
		str.addWord("fFive");
	}

	@Test
	void addWordTest() {
		assertFalse(str.addWord("first"));
		assertTrue(str.addWord("six"));
	}
	
	@Test
	void getWordsByPrefixTest() {
		String[] expected = {"Two","Three"};
		String[] expected2 = {"First","Four","Five","fFive"};
		String[] expected3 = {};
		assertArrayEquals(expected, str.getWordsByPrefix("T").toArray());
		assertArrayEquals(expected2, str.getWordsByPrefix("f").toArray());
		assertArrayEquals(expected2, str.getWordsByPrefix("F").toArray());
		assertArrayEquals(expected3, str.getWordsByPrefix("VV").toArray());
		
	}
	
	

}
