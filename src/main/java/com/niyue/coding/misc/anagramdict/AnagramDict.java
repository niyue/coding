package com.niyue.coding.misc.anagramdict;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given a dictionary and a string, write a program to output the valid words while minimizing the numbers of skipped characters. 
 * The substring that consists of a valid word in the dictionary may swap the characters. 
 * For example, Given a dictionary d = window, cat and a string “iwndowdcta”, the output is “window cat”. 
 * In this case, there is only one number of skipped character which is ’d’.
 * This is a top down DP solution with time complexity O(n^3)
 */
public class AnagramDict {
	private final static Integer SKIP = -1;
	private final static Integer UNKNOWN = Integer.MIN_VALUE;
	private List<Integer> wordEnds;
	private List<Integer> skippedCount;
	
	public List<String> restore(String word, Set<String> dict) {
		Map<String, String> anagramDict = anagramDict(dict);
		wordEnds = new ArrayList<Integer>(Collections.nCopies(word.length(), UNKNOWN));
		skippedCount = new ArrayList<Integer>(Collections.nCopies(word.length(), 0));
		minSkip(word, 0, anagramDict);
		List<String> words = words(word, anagramDict);
		return words;
	}
	
	private List<String> words(String word, Map<String, String> anagramDict) {
		List<String> words = new ArrayList<String>();
		for(int i = 0; i < word.length();) {
			Integer next = wordEnds.get(i);
			if(next == SKIP) {
				i++;
			} else {
				String ithWord = sort(word.substring(i, next));
				words.add(anagramDict.get(ithWord));
				i = next;
			}
		}
		return words;
	}
	
	private int minSkip(String word, int i, Map<String, String> dict) {
		int skipped = 0; 
		if(i < word.length()) {
			if(wordEnds.get(i) == UNKNOWN) {
				Integer wordEnd = SKIP;
				int min = 1 + minSkip(word, i + 1, dict);
				for(int j = i + 1; j <= word.length(); j++) {
					String ithWord = sort(word.substring(i, j));
					if(dict.containsKey(ithWord)) {
						int ith = minSkip(word, j, dict);
						if(ith < min) {
							wordEnd = j;
							min = ith;
						}
					}
				}
				skipped = min;
				skippedCount.set(i, skipped);
				wordEnds.set(i, wordEnd);
			} else {
				skipped = skippedCount.get(i);
			}
		}
		return skipped;
	}
	
	private Map<String, String> anagramDict(Set<String> dict) {
		Map<String, String> anagramDict = new HashMap<String, String>();
		for(String word : dict) {
			String sortedWord = sort(word);
			anagramDict.put(sortedWord, word);
		}
		return anagramDict;
	}
	
	private String sort(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}
