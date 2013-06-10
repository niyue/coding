package com.niyue.coding.careercup.shuffledwords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

// http://www.careercup.com/question?id=15070901
// only characters within a word are shuffled but they are not shuffled across different words
public class ShuffledWords {
	private Integer[] result;
	private static final int NO_SOLUTION = -1;
	public String restore(String shuffledWords, Set<String> dict) {
		result = new Integer[shuffledWords.length()];
		Map<String, Set<String>> anagramSet = anagramSet(dict);
		Integer nextWord = separate(shuffledWords, 0, anagramSet);
		String sentence = join(shuffledWords, nextWord, anagramSet);
		return sentence;
	}
	
	private String join(String shuffledWord, Integer nextWord, Map<String, Set<String>> anagramSet) {
		StringBuilder s = new StringBuilder();
		Integer prev = 0;
		while(nextWord != null && nextWord <= shuffledWord.length()) {
			String word = shuffledWord.substring(prev, nextWord);
			String anagram = sortedAnagram(word);
			String anagramWord = anagramSet.get(anagram).iterator().next(); 
			if(s.length() == 0) {
				s.append(anagramWord);
			} else {
				s.append(" ").append(anagramWord);
			}
			prev = nextWord;
			nextWord = nextWord < shuffledWord.length() ? result[nextWord] : null;
		}
		return s.toString();
	}
	
	private int separate(String shuffledWords, int start, Map<String, Set<String>> anagramSet) {
		Integer nextWord = NO_SOLUTION;
		if(result[start] != null) {
			nextWord = result[start];
		} else {
			for(int i = start; i < shuffledWords.length(); i++) {
				String word = shuffledWords.substring(start, i + 1);
				String anagram = sortedAnagram(word);
				if(anagramSet.containsKey(anagram)) {
					if(i + 1 == shuffledWords.length()) {
						nextWord = i + 1;
					} else {
						Integer next = separate(shuffledWords, i + 1, anagramSet);
						if(next != NO_SOLUTION) {
							nextWord = i + 1;
							break;
						}
					}
				}
			}
			result[start] = nextWord;
		}
		return nextWord;
	}
	
	private String sortedAnagram(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	private Map<String, Set<String>> anagramSet(Set<String> dict) {
		Map<String, Set<String>> anagramSet = new HashMap<String, Set<String>>();
		for(String word : dict) {
			String anagram = sortedAnagram(word);
			if(!anagramSet.containsKey(anagram)) {
				anagramSet.put(anagram, new LinkedHashSet<String>());
			}
			anagramSet.get(anagram).add(word);
		}
		return anagramSet;
	}
}
