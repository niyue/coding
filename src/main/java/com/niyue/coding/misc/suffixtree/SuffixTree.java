package com.niyue.coding.misc.suffixtree;

import java.util.List;

/**
 * A naive suffix tree implementation
 */
public class SuffixTree {
	private SuffixTreeNode root = new SuffixTreeNode();
	/**
	 * Build a suffix tree from the string s
	 * @param s the string where the suffix tree is built from
	 */
	public SuffixTree(String s) {
		for(int i = 0; i < s.length(); i++) {
			root.insert(s, i, i);
		}
	}
	
	/**
	 * Return the indexes where the substring appears
	 * @param pattern the pattern to be searched
	 * @return a list of indexes that the pattern appears in the string
	 */
	public List<Integer> getIndexes(String pattern) {
		return root.getIndexes(pattern, 0);
	}
}
