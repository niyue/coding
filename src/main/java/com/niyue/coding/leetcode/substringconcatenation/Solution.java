package com.niyue.coding.leetcode.substringconcatenation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_30
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
    	char[] chars = S.toCharArray();
    	ArrayList<Integer> solutions = new ArrayList<Integer>();
    	Map<String, Integer> wordCount = wordCount(L);
		if(L.length > 0) {
			int wordLength = L[0].length();
			Map<Integer, String> indexes = wordIndexes(chars, wordCount, wordLength);
			Map<Integer, String> wordsInS = new HashMap<Integer, String>(indexes);
			while(!indexes.isEmpty()) {
				Integer firstKey = indexes.keySet().iterator().next();
				List<Integer> equallySpacedWords = new ArrayList<Integer>();
				for(int key = firstKey; indexes.containsKey(key); key += wordLength) {
					equallySpacedWords.add(key);
					indexes.remove(key);
				}
				solutions.addAll(findSubstring(equallySpacedWords, wordsInS, wordLength, wordCount, L.length));
			}
		}   
		return solutions;     
    }
    
    private Map<Integer, String> wordIndexes(char[] chars, Map<String, Integer> wordCount, int wordLength) {
    	Map<Integer, String> indexes = new java.util.LinkedHashMap<Integer, String>();
    	for(int i = 0; i + wordLength <= chars.length; i++) {
			String word = new String(chars, i, wordLength);
			if(wordCount.containsKey(word)) {
				indexes.put(i, word);
			}
		}
    	return indexes;
    }

    private List<Integer> findSubstring(List<Integer> words, 
    		final Map<Integer, String> indexes, 
    		final int wordLength, 
    		final Map<String, Integer> wordCount, 
    		int wordSetSize) {
    	List<Integer> solutions = new ArrayList<Integer>();
    	if(words.size() >= wordSetSize) {
    		Map<String, List<Integer>> positions = new HashMap<String, List<Integer>>();
    		int start = 0;
    		int wordsSize = 0;
    		for(int i = 0; i < words.size(); i++) {
    			String word = indexes.get(words.get(i));
    			if(!positions.containsKey(word)) {
    				positions.put(word, new LinkedList<Integer>());
    			} else if(positions.get(word).size() == wordCount.get(word)) {
    				int previousPosition = positions.get(word).get(0);
    				for(int j = start; j <= previousPosition; j++) {
    					String w = indexes.get(words.get(j));
    					positions.get(w).remove(0);
    					wordsSize--;
    				}
    				start = previousPosition + 1;
    			}
    			positions.get(word).add(i);
    			wordsSize++;
    			if(wordsSize == wordSetSize) {
    				solutions.add(words.get(start));
    			}
    		}
    	}
    	return solutions;
    }

    private Map<String, Integer> wordCount(String[] L) {
    	Map<String, Integer> wordCount = new HashMap<String, Integer>();
    	for(String word : L) {
    		if(!wordCount.containsKey(word)) {
    			wordCount.put(word, 0);
    		}
    		wordCount.put(word, wordCount.get(word) + 1);
    	}
    	return wordCount;
    }
}
