package com.niyue.coding.leetcode.symmetrictree;

import static org.junit.Assert.*;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class SymmetricTreeTest {

	@Test 
	// make a mistake on setting level values for root node 
	public void test122() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		
		Solution sl = new Solution();
		boolean isSymmertric = sl.isSymmetric(root);
		assertTrue(isSymmertric);
	}
	
	@Test
	public void test12() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		Solution sl = new Solution();
		boolean isSymmertric = sl.isSymmetric(root);
		assertFalse(isSymmertric);
	}
}
