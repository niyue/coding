package com.niyue.coding.leetcode.recoverbinarytree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class RecoverBinaryTreeTest {

	@Test
	// last node cannot be peak 
	public void test123() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		Solution sl = new Solution();
		sl.recoverTree(root);
		
		assertEquals(2, root.val);
		assertEquals(1, root.left.val);
		assertEquals(3, root.right.val);
	}
	
	@Test
	// didn't handle switching first and last case
	public void testSwitchFirstAndLast() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(4);
		
		Solution sl = new Solution();
		sl.recoverTree(root);
		
		assertEquals(4, root.val);
		assertEquals(3, root.left.val);
		assertEquals(2, root.left.left.val);
		assertEquals(1, root.left.left.left.val);
	}
	
	@Test
	// forget to reset peak and bottom variable because the function may be run multiple times for different test cases 
	public void test1324() {
		TreeNode root = new TreeNode(68);
		root.left = new TreeNode(41);
		root.left.left = new TreeNode(-85);
		root.left.left.left = new TreeNode(-73);
		root.left.left.right = new TreeNode(-49);
		root.left.left.left.left = new TreeNode(-98);
		root.left.left.left.left.left = new TreeNode(-124);
		
		Solution sl = new Solution();
		sl.recoverTree(root);
		
		assertEquals(68, root.val);
		assertEquals(41, root.left.val);
		assertNull(root.right);
		assertEquals(-73, root.left.left.val);
		assertEquals(-85, root.left.left.left.val);
		assertEquals(-49, root.left.left.right.val);
		assertEquals(-98, root.left.left.left.left.val);
		assertEquals(-124, root.left.left.left.left.left.val);
		
	}
}
