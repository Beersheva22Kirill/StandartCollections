package telran.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class WordsIMPL implements Words {
	LinkedHashSet<String> words = new LinkedHashSet<>();
	LinkedHashSet<String> wordsInUpper = new LinkedHashSet<>();
	
	@Override
	public boolean addWord(String word) {
		boolean res = false;
		if (!isEquals(word)) {
			words.add(word);
			wordsInUpper.add(word.toUpperCase());
			res = true;
		}
		
		return res;
	}

	private boolean isEquals(String word) {
		
		return wordsInUpper.contains(word.toUpperCase());
	}

	@Override
	public List<String> getWordsByPrefix(String prefix) {
		List<String> res = new ArrayList<>();
		words.stream().filter(n -> n.startsWith(prefix)).forEach(n -> res.add(n));
		return res;
	}

}
