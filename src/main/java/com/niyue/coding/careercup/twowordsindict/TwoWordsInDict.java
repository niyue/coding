package com.niyue.coding.careercup.twowordsindict;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

// Given a dictionary find out if given word can be made by two words in dictionary.
// For eg. given "newspaper" you have to find if it can be made by two words. 
// (news and paper in this case)
// http://www.careercup.com/question?id=7400667
// this solution is simple but O(n^2) in time 
public class TwoWordsInDict {
	public List<String> split(String word, Set<String> dict) {
		List<String> words = null;
		for(int i = 0; i < word.length(); i++) {
			String first = word.substring(0, i + 1);
			String second = word.substring(i + 1, word.length());
			if(dict.contains(first) && dict.contains(second)) {
				words = Arrays.asList(first, second);
				break;
			}
		}
		return words;
	}
}
