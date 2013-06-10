package com.niyue.coding.careercup.shuffledwords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// http://www.careercup.com/question?id=15070901
// only characters within a word are shuffled but they are not shuffled across different words
public class ShuffledWords {
	public String restore(String shuffledWords, Set<String> dict) {
		Map<String, Set<String>> anagramSet = anagramSet(dict);
		List<String> words = separate(shuffledWords, 0, anagramSet);
		String sentence = join(words, anagramSet);
		return sentence;
	}
	
	private String join(List<String> words, Map<String, Set<String>> anagramSet) {
		StringBuilder s = new StringBuilder();
		for(String word : words) {
			String anagramWord = anagramSet.get(word).iterator().next(); 
			if(s.length() == 0) {
				s.append(anagramWord);
			} else {
				s.append(" ").append(anagramWord);
			}
		}
		return s.toString();
	}
	
	private List<String> separate(String shuffledWords, int start, Map<String, Set<String>> anagramSet) {
		List<String> separatedWords = new ArrayList<String>();
		for(int i = start; i < shuffledWords.length(); i++) {
			String word = shuffledWords.substring(start, i + 1);
			String anagram = sortedAnagram(word);
			if(anagramSet.containsKey(anagram)) {
				if(i + 1 == shuffledWords.length()) {
					separatedWords.add(anagram);
				} else {
					List<String> words = separate(shuffledWords, i + 1, anagramSet);
					if(!words.isEmpty()) {
						separatedWords.add(anagram);
						separatedWords.addAll(words);
						break;
					}
				}
			}
		}
		return separatedWords;
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
