package com.niyue.coding.leetcode.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_49
public class Solution {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> anagram = new ArrayList<String>();
		Map<String, List<String>> groups = new HashMap<String, List<String>>();
		for (String string : strs) {
			char[] chars = string.toCharArray();
			Arrays.sort(chars);
			String anagramKey = new String(chars);
			if(!groups.containsKey(anagramKey)) {
				groups.put(anagramKey, new LinkedList<String>());
			}
			groups.get(anagramKey).add(string);
		}
		for (List<String> anagramGroup : groups.values()) {
			if (anagramGroup.size() > 1) {
				anagram.addAll(anagramGroup);
			}
		}
		return anagram;
	}
}
