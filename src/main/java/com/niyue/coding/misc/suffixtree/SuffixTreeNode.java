package com.niyue.coding.misc.suffixtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuffixTreeNode {
	private Map<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
	private List<Integer> indexes = new ArrayList<Integer>();
	
	public void insert(String s, int index) {
		indexes.add(index);
		if(s != null && s.length() > 0) {
			Character firstChar = s.charAt(0);
			SuffixTreeNode child = null;
			if(children.containsKey(firstChar)) {
				child = children.get(firstChar);
			} else {
				child = new SuffixTreeNode();
				children.put(firstChar, child);
			}
			String remainder = s.substring(1);
			child.insert(remainder, index);
		}
	}
	
	public List<Integer> getIndexes(String s) {
		List<Integer> allIndexes = null;
		if(s == null || s.isEmpty()) {
			allIndexes = indexes;
		} else {
			Character firstChar = s.charAt(0);
			if(children.containsKey(firstChar)) {
				String remainder = s.substring(1);
				allIndexes = children.get(firstChar).getIndexes(remainder);
			}
		}
		return allIndexes;
	}
}
