package com.niyue.coding.careercup.doublebst;

// http://www.careercup.com/question?id=12697664
// A BST, each of its node is of double value, find the closest node for some k
// An O(lgn) solution to find the closest node in a BST with double value
public class DoubleBst {
	public TreeNode findClosest(TreeNode node, double k) {
		TreeNode closest = null;
		if (node != null) {
			TreeNode branch = k < node.value ? node.left : node.right;
			closest = findClosest(branch, k);
			closest = closest(closest, node, k);
		}
		return closest;
	}

	private TreeNode closest(TreeNode n1, TreeNode n2, double k) {
		if (n1 != null && n2 != null) {
			return Math.abs(n1.value - k) < Math.abs(n2.value - k) ? n1 : n2;
		} else {
			return n1 != null ? n1 : n2;
		}
	}
}
