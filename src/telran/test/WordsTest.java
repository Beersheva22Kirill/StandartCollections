package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
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
	}

	@Test
	void addWordTest() {
		assertFalse(str.addWord("first"));
		assertTrue(str.addWord("six"));
	}
	
	@Test
	void getWordsByPrefixTest() {
		List<String> list = new ArrayList<>();
		String[] expected = {"Two","Three"};
		String[] expected2 = {"First","Four","Five"};
		String[] expected3 = {};
		assertArrayEquals(expected, str.getWordsByPrefix("T").toArray());
		assertArrayEquals(expected2, str.getWordsByPrefix("F").toArray());
		assertArrayEquals(expected3, str.getWordsByPrefix("VV").toArray());
		
	}
	
	

}
