package com.niyue.coding.leetcode.sumroottoleafnumbers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.niyue.coding.leetcode.sumroottoleafnumbers.Solution.TreeNode;


public class SumRootToLeafNumbersTest {

	@Test
	// fail to consider the last element of stack is popped out 
	public void testSingleNode() {
		TreeNode root = new TreeNode(9);
		Solution sl = new Solution();
		int sum = sl.sumNumbers(root);
		assertEquals(9, sum);
	}
	
	@Test
	public void testNumberWithLeadingZero() throws Exception {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		Solution sl = new Solution();
		int sum = sl.sumNumbers(root);
		assertEquals(4, sum);
	}
	
}
