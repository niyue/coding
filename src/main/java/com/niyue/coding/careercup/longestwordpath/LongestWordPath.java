package com.niyue.coding.careercup.longestwordpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Suppose you are given a dictionary of words based on an alphabet with a fixed number of characters. 
 * Please write a method / function which will find the longest word in the dictionary such that it can be built from successively adding a single character to an existing word in the dictionary (in any location). 
 * For instance, "a" -> "at" -> "cat" -> "chat" -> "chart".
 * http://www.careercup.com/question?id=1446667
 * A O(max-word-length ^2 * dict-size) solution
 * 
 * Another similar but different problem:
 * http://www.careercup.com/question?id=24423662
 */
public class LongestWordPath {
	
	public List<String> longestWordPath(Set<String> dict) {
		Map<String, List<String>> connectedWords = new HashMap<String, List<String>>();
		Set<String> alphabet = new HashSet<String>();
		for(String word : dict) {
			if(word.length() == 1) {
				alphabet.add(word.toString());
			}
			for(int i = 0; i < word.length(); i++) {
				StringBuilder w = new StringBuilder(word);
				String smallerWord = w.deleteCharAt(i).toString();
				if(dict.contains(smallerWord)) {
					if(!connectedWords.containsKey(smallerWord)) {
						connectedWords.put(smallerWord, new ArrayList<String>());
					}
					connectedWords.get(smallerWord).add(word);
				}
			}
		}
		
		List<String> path = searchLongestPath(connectedWords, alphabet);
		return path;
	}
	
	private List<String> searchLongestPath(Map<String, List<String>> connectedWords, Set<String> alphabet) {
		List<String> max = Collections.emptyList();
		for(String letter : alphabet) {
			List<String> maxPath = search(connectedWords, letter);
			if(maxPath.size() > max.size()) {
				max = maxPath;
			}
		}
		return max;
	}
	
	private List<String> search(Map<String, List<String>> connectedWords, String letter) {
		List<String> maxSubPath = new ArrayList<String>();
		if(connectedWords.containsKey(letter)) {
			List<String> longerWords = connectedWords.get(letter);
			for(String longerWord : longerWords) {
				List<String> pathForWord = search(connectedWords, longerWord);
				if(pathForWord.size() > maxSubPath.size()) {
					maxSubPath = pathForWord;
				}
			}
		}
		List<String> path = new ArrayList<String>();
		path.add(letter);
		path.addAll(maxSubPath);
		return path;
	}
}
