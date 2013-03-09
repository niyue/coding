package com.niyue.coding.leetcode.validatebst;

import com.niyue.coding.leetcode.common.TreeNode;

public class InOrderTraversalSolution {
	private boolean isBst;
	private Integer prev;

	public boolean isValidBST(TreeNode root) {
		isBst = true;
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
