package com.niyue.coding.leetcode.balancedbinarytree;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class BalancedBinaryTreeTest {

	@Test
	// forget to update 'current' during while loop
	public void test12() {
		Solution sl = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		assertTrue(sl.isBalanced(root));
	}
}
