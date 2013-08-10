package com.niyue.coding.misc.longestcommonprefix;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a billion of URLs, find the longest common prefix for these URLs. 
 * The prefix should appear in at least 75% of URLs.
 * Implement using a Trie. Insert all URLs into a Trie, and traverse trie to get the longest common prefix satisfying the percentage.
 * Build the Trie, time complexity: O(N * M) where N the number of strings, and M is the average length of given strings
 * Search the longest common prefix, time complexity: Time complexity: O(L) where L is the length of longest common prefix
 */
public class LongestCommonPrefix {
	public String find(String[] strings, double percentage) {
		assert percentage <= 1;
		TrieNode root = new TrieNode();
		for(String s : strings) {
			root.insert(s, 0);
		}
		StringBuilder prefix = new StringBuilder();
		root.longestCommonPrefix(strings.length, percentage, prefix);
		return prefix.toString();
	}
	
	private static class TrieNode {
		private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		private int count;
		private Character maxCountChar;
		
		public void insert(String s, int i) {
			count++;
			if(i < s.length()) {
				Character currentChar = s.charAt(i);
				if(!children.containsKey(currentChar)) {
					children.put(currentChar, new TrieNode());
				}
				TrieNode currentChild = children.get(currentChar);
				currentChild.insert(s, i + 1);
				if(maxCountChar == null || currentChild.count > children.get(maxCountChar).count) {
					maxCountChar = currentChar;
				}
			}
		}
		
		public void longestCommonPrefix(int total, double percentage, StringBuilder prefix) {
			if(maxCountChar != null && children.get(maxCountChar).count / (total * 1.0) >= percentage) {
				prefix.append(maxCountChar);
				children.get(maxCountChar).longestCommonPrefix(total, percentage, prefix);
			}
		}
	}
}
