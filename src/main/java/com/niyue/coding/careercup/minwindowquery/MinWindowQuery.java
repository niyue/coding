package com.niyue.coding.careercup.minwindowquery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// http://www.careercup.com/question?id=248673
// use a HashMap to keep track of the latest position for each word and update the min length if the latest word is the last word in the window
// the understanding for this question is not very accurate, the minimum window is implemented to 
// contain the least words instead of having least length, but this issue can be overcome with some simple modification 
public class MinWindowQuery {
	public String minWindow(String document, Set<String> keywords) {
		List<String> words = Arrays.asList(document.split(" "));
		Map<String, Integer> latestPositions = new HashMap<String, Integer>();
		Integer minStart = null;
		Integer minEnd = null;
		int i = 0;
		for(int j = 0; j < words.size(); j++) {
			String word = words.get(j);
			if(keywords.contains(word)) {
				latestPositions.put(word, j);
				if(latestPositions.size() == keywords.size()) {
					if(minStart == null || words.get(minStart).equals(word)) {
						while(i <= j) {
							String startWord = words.get(i);
							if(keywords.contains(startWord) && latestPositions.get(startWord) == i) {
								if(minStart == null || j - i < minEnd - minStart) {
									minStart = i;
									minEnd = j;
								}
								break;
							} else {
								i++;
							}
						}
					}
				}
			}
		}
		return minStart == null ? "" : join(words, minStart, minEnd);
	}
	
	private String join(List<String> words, int i, int j) {
		StringBuilder s = new StringBuilder();
		for(int k = i; k <= j; k++) {
			String word = words.get(k);
			if(k == i) {
				s.append(word);
			} else {
				s.append(" ").append(word);
			}
		}
		return s.toString();
	}
}
