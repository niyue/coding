package com.niyue.coding.misc.biggestcommonwordspair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * http://www.mitbbs.com/article_t1/JobHunting/32333649_0_2.html
 * Given a list of sentences, find out one pair of sentences that have most number of common words.
 * For example, three sentences:
 * 1) This is a good day
 * 2) This is a bad day
 * 3) That was good day
 * (1, 2) has four common words (This/is/a/day), (1, 3) has two common words (good/day), (2, 3) has two common words (good/day)
 * (1, 2) should be returned
 * Let's say there are N sentences, each sentence has M words on average, there is an obvious M * N^2 solution
 * The following solution is only slightly better than M * N^2, which is O(M * N * c) where c is the average number of common words between two sentence.
 * And the solution cannot handle duplicated words correctl yet.   
 */
public class BiggestCommonWordsPair {
	public int[] find(List<String> sentences) {
		List<String[]> wordsList = split(sentences);
		Map<String, List<Integer>> invertedIndexes = invertedIndexes(wordsList);
		Map<String, Integer> count = new HashMap<String, Integer>();
		for(int i = 0; i < sentences.size(); i++) {
			String[] words = wordsList.get(i);
			for(String word : words) {
				List<Integer> commonSentences = invertedIndexes.get(word);
				for(int j : commonSentences) {
					if(j != i) {
						String key = String.format("%s,%s", Math.min(i, j), Math.max(i, j));
						if(!count.containsKey(key)) {
							count.put(key, 0);
						}
						count.put(key, count.get(key) + 1);
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		int[] maxPair = null;
		for(Entry<String, Integer> pair : count.entrySet()) {
			if(pair.getValue() > max) {
				String[] p = pair.getKey().split(",");
				maxPair = new int[]{Integer.valueOf(p[0]), Integer.valueOf(p[1])};
			}
		}
		return maxPair;
	}
	
	private List<String[]> split(List<String> sentences) {
		List<String[]> wordsList = new ArrayList<String[]>();
		for(String sentence : sentences) {
			String[] words = sentence.split(" ");
			wordsList.add(words);
		}
		return wordsList;
	}
	
	private Map<String, List<Integer>> invertedIndexes(List<String[]> wordsList) {
		Map<String, List<Integer>> invertedIndexes = new HashMap<String, List<Integer>>();
		for(int i = 0; i < wordsList.size(); i++) {
			String[] words = wordsList.get(i);
			for(String word : words) {
				if(!invertedIndexes.containsKey(word)) {
					invertedIndexes.put(word, new ArrayList<Integer>());
				}
				invertedIndexes.get(word).add(i);
			}
		}
		return invertedIndexes;
	}
}
