package com.niyue.coding.leetcode.validatebst;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_98
// Validate if a tree is binary search tree using in order traversal
public class InOrderTraversalSolution {
	private boolean isBst;
	private Integer prev;

	public boolean isValidBST(TreeNode root) {
		isBst = true;
		prev = null;
		if (root != null) {
			visit(root);
		}
		return isBst;
	}

	private void visit(TreeNode node) {
		if (node != null && isBst) {
			visit(node.left);
			// one more check for isBst
			if (prev != null && isBst) {
				isBst = node.val > prev;
			}
			prev = node.val;
			visit(node.right);
		}
	}
}
