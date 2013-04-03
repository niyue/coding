package com.niyue.coding.leetcode.palindromepartitionii;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_132
// pre-process the string to get all palindrome's start and end, O(n^2)
// use top down approach DP to get the min cut, the recurrance is:
// minCut(start) = each 'end' for the 'start' Math.min(minCut(end + 1) + 1); if start == last, minCut = 0
public class Solution {

	private Integer[] minCutCache;

	public int minCut(String s) {
		minCutCache = new Integer[s.length()];
		Map<Integer, List<Integer>> palindromes = palindromes(s);
		return minCut(s, 0, palindromes);
	}

	private int minCut(String s, int start, Map<Integer, List<Integer>> palindromes) {
		int min = Integer.MAX_VALUE;
		if (minCutCache[start] != null) {
			min = minCutCache[start];
		} else {
			if (palindromes.containsKey(start)) {
				List<Integer> ends = palindromes.get(start);
				for (int end : ends) {
					if (end + 1 == s.length()) {
						min = 0;
					} else {
						int minCutForEnd = minCut(s, end + 1, palindromes);
						if (minCutForEnd + 1 < min) {
							min = minCutForEnd + 1;
						}
					}
				}
			}
			minCutCache[start] = min;
		}
		return min;
	}

	private Map<Integer, List<Integer>> palindromes(String s) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		char[] string = s.toCharArray();
		for (int i = 0; i < string.length; i++) {
			// odd length palindromes
			for (int j = 0; i - j >= 0 && i + j < string.length; j++) {
				if (string[i - j] == string[i + j]) {
					if (!map.containsKey(i - j)) {
						map.put(i - j, new LinkedList<Integer>());
					}
					map.get(i - j).add(i + j);
				} else {
					break;
				}
			}
			// even length palindromes
			for (int j = 1; i - j + 1 >= 0 && i + j < string.length; j++) {
				if (string[i - j + 1] == string[i + j]) {
					if (!map.containsKey(i - j + 1)) {
						map.put(i - j + 1, new LinkedList<Integer>());
					}
					map.get(i - j + 1).add(i + j);
				} else {
					break;
				}
			}
		}
		return map;
	}
}
