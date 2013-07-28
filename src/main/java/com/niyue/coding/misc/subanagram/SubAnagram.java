package com.niyue.coding.misc.subanagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * http://www.mitbbs.com/article_t/JobHunting/32113351.html
 * Given two strings, a and b, find substrings of a which is anagram of b
 */
public class SubAnagram {
	public List<String> find(String a, String b) {
		List<String> results = new ArrayList<String>();
		Map<Character, Integer> count = countingMap(b);
		for(int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			change(count, c, 1);
			
			if(i >= b.length()) {
				int last = i - b.length();
				char lastChar = a.charAt(last);
				change(count, lastChar, -1);
			}
			if(count.isEmpty()) {
				// JDK 6, substring is an O(1) operation, which can give an O(n) algorithm for this problem
				// but from some version of JDK 7, substring becomes O(n) operation
				results.add(a.substring(i + 1 - b.length(), i + 1));
			}
		}
		return results;
	}
	
	private void change(Map<Character, Integer> map, char c, int value) {
		if(!map.containsKey(c)) {
			map.put(c, 0);
		}
		map.put(c, map.get(c) + value);
		if(map.get(c) == 0) {
			map.remove(c);
		}
	}
	
	private Map<Character, Integer> countingMap(String b) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : b.toCharArray()) {
			change(map, c, -1);
		}
		return map;
	}
}
