package com.niyue.coding.careercup.distinctsubstrings;

import java.util.HashMap;
import java.util.Map;

/*
 * http://www.careercup.com/question?id=3315662
 * given a string find the number of distinct substrings of the string. 
 * ex: 
 * input-> aaaa 
 * output-> 4(a, aa, aaa, aaaa) 
 * input->abcd 
 * output->10(a, b, c, d, ab, bc, cd, abc, bcd, abcd)
 * 
 * 1) Build a suffix tree for the string, insert each suffix into a Trie O(n^2)
 * 2) Traverse the Trie to count the total number of nodes in the Trie 	O(n^2)
 */
public class DistinctSubstrings {
	public int count(String s) {
		TrieNode root = new TrieNode();
		for(int i = 0; i < s.length(); i++) {
			root.insert(s, i);
		}
		return root.count();
	}
	
	private static class TrieNode {
		private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		public void insert(String s, int i) {
			if(i < s.length()) {
				Character ch = s.charAt(i);
				if(!children.containsKey(ch)) {
					children.put(ch, new TrieNode());
				}
				children.get(ch).insert(s, i + 1);
			}
		}
		
		public int count() {
			int count = children.size();
			for(TrieNode child : children.values()) {
				count += child.count();
			}
			return count;
		}
	}
}
