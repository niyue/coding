package com.niyue.coding.leetcode.validatebst;

import java.util.ArrayDeque;
import java.util.Deque;

import com.niyue.coding.leetcode.common.TreeNode;

public class SimpleIterativeSolution {
	public boolean isValidBST(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode current = root;
		boolean isBst = true;
		Integer prev = null;
		while(!stack.isEmpty() || current != null) {
			if(current != null) {
				stack.offerFirst(current);
				current = current.left;
			} else {
				current = stack.pollFirst();
				if(prev != null && prev >= current.val) {
					isBst = false;
					break;
				}
				prev = current.val;
				current = current.right;
			}
		}
		return isBst;
	}
}
