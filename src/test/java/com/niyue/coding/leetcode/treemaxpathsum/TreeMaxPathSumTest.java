package com.niyue.coding.leetcode.treemaxpathsum;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class TreeMaxPathSumTest {

	@Test
	public void testEmptyTree() {
		Solution sl = new Solution();
		int sum = sl.maxPathSum(null);
		assertThat(sum, is(Integer.MIN_VALUE));
	}
	
	@Test
	public void testOneNodeTree() {
		Solution sl = new Solution();
		TreeNode root = new TreeNode(1);
		int sum = sl.maxPathSum(root);
		assertThat(sum, is(1));
	}
	
	@Test
	public void testOneNodeNegativeTree() {
		Solution sl = new Solution();
		TreeNode root = new TreeNode(-3);
		int sum = sl.maxPathSum(root);
		assertThat(sum, is(-3));
	}
	
	@Test
	public void testNodeWithLeftChildTree() {
		Solution sl = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		int sum = sl.maxPathSum(root);
		assertThat(sum, is(3));
	}
	
	@Test
	public void testNodeWithRightChildTree() {
		Solution sl = new Solution();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		int sum = sl.maxPathSum(root);
		assertThat(sum, is(4));
	}
	
	@Test
	public void testNodeWithNegativeChildTree() {
		Solution sl = new Solution();
		TreeNode root = new TreeNode(-2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		int sum = sl.maxPathSum(root);
		assertThat(sum, is(3));
	}
	
	@Test
	public void testNodeWithTwoLeftChildrenTree() {
		Solution sl = new Solution();
		TreeNode root = new TreeNode(-2);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(3);
		int sum = sl.maxPathSum(root);
		assertThat(sum, is(3));
	}
	
	@Test
	public void testNodeWithTwoLeftChildrenAndRightChildrenTree() {
		Solution sl = new Solution();
		TreeNode root = new TreeNode(-2);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(-1);
		int sum = sl.maxPathSum(root);
		assertThat(sum, is(3));
	}
	
	@Test
	public void testNullRightChildTree() {
		Solution sl = new Solution();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(11);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(2);
		int sum = sl.maxPathSum(root);
		assertThat(sum, is(22));
	}
	
	/*
	 *         5
	 *	    4     8
	 *	  11 #  13 4
	 *	 7 2   # # # 1
	 */
	@Test
	public void testComplexTree() {
		Solution sl = new Solution();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		int sum = sl.maxPathSum(root);
		assertThat(sum, is(48));
	}

}
