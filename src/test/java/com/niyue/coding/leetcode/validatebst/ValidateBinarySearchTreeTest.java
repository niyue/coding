package com.niyue.coding.leetcode.validatebst;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class ValidateBinarySearchTreeTest {

	@Test
	// again, forget to reset class variable in the beginning of the function 
	public void testInOrderTraversalSolution() {
		TreeNode root = new TreeNode(0);
		root.right = new TreeNode(1);
		InOrderTraversalSolution sl = new InOrderTraversalSolution();
		boolean isBst = sl.isValidBST(root);
		assertTrue(isBst);
	}
	
	@Test
	// didn't consider the case non bst may be set after visiting left sub tree
	public void testInOrderComplexTree() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(20);
		InOrderTraversalSolution sl = new InOrderTraversalSolution();
		boolean isBst = sl.isValidBST(root);
		assertFalse(isBst);
	}
	
	@Test
	// current should not be null in while
	public void testIterativeSolution() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		IterativeSolution sl = new IterativeSolution();
		boolean isBst = sl.isValidBST(root);
		assertFalse(isBst);
	}
}

