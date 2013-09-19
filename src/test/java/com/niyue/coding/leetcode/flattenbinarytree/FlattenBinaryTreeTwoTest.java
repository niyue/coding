package com.niyue.coding.leetcode.flattenbinarytree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class FlattenBinaryTreeTwoTest {

	@Test
	public void testSimpleTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		SolutionTwo sl = new SolutionTwo();
		
		sl.flatten(root);
		assertEquals(1, root.val);
		assertNull(root.left);
		assertNotNull(root.right);
		
		assertEquals(2, root.right.val);
		assertNull(root.right.right);
	}
	
	@Test
	public void testSimpleTreeRight() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		SolutionTwo sl = new SolutionTwo();
		
		sl.flatten(root);
		assertEquals(1, root.val);
		assertNull(root.left);
		assertNotNull(root.right);
		
		assertEquals(2, root.right.val);
		assertNull(root.right.right);
	}
}
