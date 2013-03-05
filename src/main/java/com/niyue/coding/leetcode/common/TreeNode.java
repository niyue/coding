package com.niyue.coding.leetcode.common;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return String.format("(%s %s %s)", val, left, right);
	}
}
