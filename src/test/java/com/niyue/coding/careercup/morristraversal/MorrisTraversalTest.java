package com.niyue.coding.careercup.morristraversal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class MorrisTraversalTest {

	@Test
	public void testOneNode() {
		TreeNode root = new TreeNode(1);
		MorrisTraversal traversal = new MorrisTraversal();
		List<Integer> values = traversal.inorder(root);
		assertThat(values, is(Arrays.asList(1)));
	}
	
	@Test
	public void testNodeWithLeftNode() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		MorrisTraversal traversal = new MorrisTraversal();
		List<Integer> values = traversal.inorder(root);
		assertThat(values, is(Arrays.asList(1, 2)));
	}
	
	@Test
	public void testNodeWithRightNode() {
		TreeNode root = new TreeNode(2);
		root.right = new TreeNode(3);
		MorrisTraversal traversal = new MorrisTraversal();
		List<Integer> values = traversal.inorder(root);
		assertThat(values, is(Arrays.asList(2, 3)));
	}
	
	@Test
	public void testNodeWithLeftAndRightNode() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		MorrisTraversal traversal = new MorrisTraversal();
		List<Integer> values = traversal.inorder(root);
		assertThat(values, is(Arrays.asList(1, 2, 3)));
	}
	
	@Test
	public void testNodeWithMultipleNodes() {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		MorrisTraversal traversal = new MorrisTraversal();
		List<Integer> values = traversal.inorder(root);
		assertThat(values, is(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
	}

}
