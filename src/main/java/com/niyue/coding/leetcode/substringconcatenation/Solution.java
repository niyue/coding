package com.niyue.coding.leetcode.substringconcatenation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_30
/*
 * 1) Count number of times for each word, O(L * wordLength)
 * 2) Find all indexes for each word in S, O(S * wordLength)
 * 3) Find all continuous equally spaced words, O(S * wordLength)
 * 		For each set of continuous equally spaced words, find if there is a set of words matching L given
 * 			Keep a rolling window [start, end]
 * 				if [start, end] matches word count for L, add it to solution
 * 				else if a word appears more times than in L, slide the window to move the first appearance of this word out of the window
 * Time complexity: O((L + S) * wordLength), where wordLength is a small constant typically
 */
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
				solutions.addAll(findSubstring(equallySpacedWords, wordsInS, wordCount, L.length));
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
    		final Map<String, Integer> wordCount, 
    		int wordSetSize) {
    	List<Integer> solutions = new ArrayList<Integer>();
    	if(words.size() >= wordSetSize) {
    		Map<String, LinkedList<Integer>> positions = new HashMap<String, LinkedList<Integer>>();
    		int start = 0;
    		int wordsSize = 0;
    		for(int i = 0; i < words.size(); i++) {
    			String word = indexes.get(words.get(i));
    			if(!positions.containsKey(word)) {
    				positions.put(word, new LinkedList<Integer>());
    			} else if(positions.get(word).size() == wordCount.get(word)) {
    				int nextStart = positions.get(word).getFirst() + 1;
    				wordsSize -= nextStart - start;
    				slideWindowStart(positions, indexes, words, start, nextStart);
    				start = nextStart;
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
    
    private void slideWindowStart(Map<String, LinkedList<Integer>> positions, Map<Integer, String> indexes, List<Integer> words, int start, int nextStart) {
		for(int j = start; j < nextStart; j++) {
			String w = indexes.get(words.get(j));
			positions.get(w).removeFirst();
		}
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
