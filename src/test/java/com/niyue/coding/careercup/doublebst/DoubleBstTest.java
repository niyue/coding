package com.niyue.coding.careercup.doublebst;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleBstTest {

	@Test
	public void testEmptyNode() {
		DoubleBst bst = new DoubleBst();
		TreeNode root = null;
		TreeNode closest = bst.findClosest(root, 0.1);
		assertThat(closest, nullValue());
	}
	
	@Test
	public void testSingleNode() {
		DoubleBst bst = new DoubleBst();
		TreeNode root = new TreeNode(0.2);
		TreeNode closest = bst.findClosest(root, 0.1);
		assertThat(closest.value, closeTo(0.2, 0.001));
	}
	
	@Test
	public void testTwoNodes() {
		DoubleBst bst = new DoubleBst();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
		TreeNode closest = bst.findClosest(root, -0.9);
		assertThat(closest.value, closeTo(-1, 0.001));
	}
	
	@Test
	public void testThreeNodes() {
		DoubleBst bst = new DoubleBst();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
		root.right = new TreeNode(1);
		TreeNode closest = bst.findClosest(root, 0.9);
		assertThat(closest.value, closeTo(1, 0.001));
	}
	
	@Test
	public void testThreeNodesWithClosestOnLeftSide() {
		DoubleBst bst = new DoubleBst();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
		root.right = new TreeNode(1);
		TreeNode closest = bst.findClosest(root, 0.1);
		assertThat(closest.value, closeTo(0, 0.001));
	}
	
	@Test
	public void testClosestInPreviousNode() {
		DoubleBst bst = new DoubleBst();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
		root.left.right = new TreeNode(-0.5);
		root.right = new TreeNode(1);
		TreeNode closest = bst.findClosest(root, -0.4);
		assertThat(closest.value, closeTo(-0.5, 0.001));
	}
	
	@Test
	public void testClosestInNextNode() {
		DoubleBst bst = new DoubleBst();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0.5);
		TreeNode closest = bst.findClosest(root, 0.4);
		assertThat(closest.value, closeTo(0.5, 0.001));
	}
}
