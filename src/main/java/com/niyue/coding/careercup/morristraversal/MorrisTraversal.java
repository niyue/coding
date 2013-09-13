package com.niyue.coding.careercup.morristraversal;

import java.util.ArrayList;
import java.util.List;

import com.niyue.coding.leetcode.common.TreeNode;

/*
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * http://en.wikipedia.org/wiki/Threaded_binary_tree
 * Morris in order traversal only uses null right pointer,
 * the left tree's right most node always has null right pointer, use that to point to its successor
 */
public class MorrisTraversal {
	private List<Integer> values = new ArrayList<Integer>();
	public List<Integer> inorder(TreeNode node) {
		TreeNode current = node;
		TreeNode prev = null;
		while(current != null) {
			if(current.left == null) {
				visit(current);
				current = current.right;
			} else {
				prev = current.left;
				while(prev.right != null && prev.right != current) {
					prev = prev.right;
				}
				if(prev.right == null) {
					prev.right = current;
					current = current.left;
				} else { // prev.right == current
					prev.right = null;
					visit(current);
					current = current.right;
				}
			}
		}
		return values;
	}
	
	private void visit(TreeNode current) {
		values.add(current.val);
	}
	
}
