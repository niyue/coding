package com.niyue.coding.misc.longestsharedprefix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * http://www.mitbbs.com/article_t/JobHunting/32295631.html
 * Given a list of strings, find the longest shared prefix for all these strings.
 * The shared prefix only needs to be shared by at least two strings.
 * Insert all strings into a Trie. Keep a count in each Trie node to indicate if this Trie node is a branch node or not (count > 1).
 * Find the longest Trie node that is a branching node, and the path from root to this Trie node is the longest shared prefix
 * Build a Trie: O(mxn), where m is the number of strings, and n is the average length of each string
 * Search the deepest branching node: O(mxn)
 */
public class LongestSharedPrefix {
	private List<Character> longest = Collections.emptyList();
	
	public String find(List<String> strings) {
		TrieNode root = new TrieNode();
		for(String s : strings) {
			root.insert(s, 0);
		}
		
		root.deepestBranchingNode(new ArrayList<Character>());
		return toString(longest);
	}
	
	private String toString(List<Character> chars) {
		StringBuilder s = new StringBuilder();
		for(Character c : chars) {
			s.append(c);
		}
		return s.toString();
	}
	
	private final class TrieNode {
		private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		private int count = 0;
		
		public void insert(String s, int i) {
			count++;
			if(i < s.length()) {
				Character current = s.charAt(i);
				if(!children.containsKey(current)) {
					children.put(current, new TrieNode());
				}
				TrieNode child = children.get(current);
				child.insert(s, i + 1);
			}
		}
		
		public void deepestBranchingNode(List<Character> chars) {
			if(count > 1) {
				if(chars.size() > longest.size()) {
					longest = new ArrayList<Character>(chars);
				}
				for(Entry<Character, TrieNode> child : children.entrySet()) {
					Character ch = child.getKey();
					chars.add(ch);
					child.getValue().deepestBranchingNode(chars);
					chars.remove(chars.size() - 1);
				}
			}
		}
	}
}
