package com.niyue.coding.misc.longestcommonprefix;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a billion of URLs, find the longest common prefix for these URLs. 
 * The prefix should appear in at least 75% of URLs.
 * Implement using a Trie. Insert all URLs into a Trie, and traverse trie to get the longest common prefix satisfying the percentage.
 */
public class LongestCommonPrefix {
	public String find(String[] strings, double percentage) {
		assert percentage <= 1;
		TrieNode root = new TrieNode();
		for(String s : strings) {
			root.insert(s, 0);
		}
		String prefix = root.longestCommonPrefix(strings.length, percentage);
		return prefix;
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
		
		public String longestCommonPrefix(int total, double percentage) {
			StringBuffer string = new StringBuffer();
			if(maxCountChar != null && children.get(maxCountChar).count / (total * 1.0) >= percentage) {
				string.append(maxCountChar);
				String childString = children.get(maxCountChar).longestCommonPrefix(total, percentage);
				string.append(childString);
			}
			return string.toString();
		}
	}
}
