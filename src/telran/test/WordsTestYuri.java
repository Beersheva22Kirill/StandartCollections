package telran.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Words;
import telran.util.WordsIMPL;

class WordsTestYuri {

	String words[]= {"abcdef","ab123","aaa","ab","ablmn","abbbb",
			"a", "ABd","bbb", "B12", "*/"};
	String wordsStartB[] = {"bbb", "B12"};
	String wordsStartAB[] = {"abcdef","ab123","ab","ablmn","abbbb","ABd"};
	String wordsStartABC[] = {"abcdef"};
	String wordsStartAsteric[] = {"*/"};
	Words elasticSearch;
		@BeforeEach
		void setUp() throws Exception {
			elasticSearch = new WordsIMPL();
			for(String word: words) {
				elasticSearch.addWord(word);
			}
				
				
		}

		@Test
		void test() {
			assertArrayEquals(wordsStartABC,elasticSearch.getWordsByPrefix("abc").toArray(String[]::new));
			assertArrayEquals(wordsStartB, elasticSearch.getWordsByPrefix("B").toArray(String[]::new));
			assertArrayEquals(wordsStartAB, elasticSearch.getWordsByPrefix("ab").toArray(String[]::new));
			assertArrayEquals(wordsStartAsteric, elasticSearch.getWordsByPrefix("*").toArray(String[]::new));
			
		}

}
