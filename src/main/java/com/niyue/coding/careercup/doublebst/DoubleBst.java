package com.niyue.coding.careercup.doublebst;

// http://www.careercup.com/question?id=12697664
// A BST, each of its node is of double value, find the closest node for some k
// An O(lgn * lgn) solution to find the closest node in a BST with double value
public class DoubleBst {
	public TreeNode findClosest(TreeNode node, double k) {
		TreeNode closest = null;
		if (node != null) {
			if (node.value < k) {
				TreeNode LeftClosest = findClosest(node.left, k);
				TreeNode next = next(node.right);
				closest = closest(LeftClosest, next, k);
			} else if (node.value > k) {
				TreeNode rightClosest = findClosest(node.right, k);
				TreeNode prev = prev(node.left);
				closest = closest(rightClosest, prev, k);
			}
			closest = closest(closest, node, k);
		}
		return closest;
	}

	private TreeNode closest(TreeNode n1, TreeNode n2, double k) {
		if (n1 != null && n2 != null) {
			return Math.abs(n1.value - k) > Math.abs(n2.value - k) ? n2 : n1;
		} else {
			return n1 != null ? n1 : n2;
		}
	}

	private TreeNode prev(TreeNode node) {
		TreeNode rightMost = null;
		while (node != null) {
			rightMost = node;
			node = node.right;
		}
		return rightMost;
	}

	private TreeNode next(TreeNode node) {
		TreeNode mostLeft = null;
		while (node != null) {
			mostLeft = node;
			node = node.left;
		}
		return mostLeft;
	}
}
