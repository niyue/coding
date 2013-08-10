package com.niyue.coding.misc.suffixtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuffixTreeNode {
	private Map<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
	private List<Integer> indexes = new ArrayList<Integer>();
	
	public void insert(String s, int current, int index) {
		indexes.add(index);
		if(current < s.length()) {
			Character currentChar = s.charAt(current);
			SuffixTreeNode child = null;
			if(children.containsKey(currentChar)) {
				child = children.get(currentChar);
			} else {
				child = new SuffixTreeNode();
				children.put(currentChar, child);
			}
			child.insert(s, current + 1, index);
		}
	}
	
	public List<Integer> getIndexes(String s, int current) {
		List<Integer> allIndexes = null;
		if(current == s.length()) {
			allIndexes = indexes;
		} else {
			Character currentChar = s.charAt(current);
			if(children.containsKey(currentChar)) {
				allIndexes = children.get(currentChar).getIndexes(s, current + 1);
			}
		}
		return allIndexes;
	}
}
