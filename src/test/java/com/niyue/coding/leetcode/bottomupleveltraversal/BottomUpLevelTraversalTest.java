package com.niyue.coding.leetcode.bottomupleveltraversal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class BottomUpLevelTraversalTest {

	@Test
	// fail to handle null root and cause out of memory in this case 
	public void testNullRoot() {
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> levels = sl.levelOrderBottom(null);
		assertEquals(0, levels.size());
	}
	
	@Test
	public void testRootOnlyTree() {
		TreeNode root = new TreeNode(1);
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> levels = sl.levelOrderBottom(root);
		assertEquals(1, levels.size());
	}
	
	@Test
	public void testSimpleTree() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> levels = sl.levelOrderBottom(root);
		assertEquals(2, levels.size());
		assertEquals(1, (int) levels.get(0).get(0));
		assertEquals(3, (int) levels.get(0).get(1));
		
		assertEquals(1, levels.get(1).size());
		assertEquals(2, (int) levels.get(1).get(0));
	}
	
	@Test
	public void testThreeLevelsTree() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> levels = sl.levelOrderBottom(root);
		assertEquals(3, levels.size());
		
		assertEquals(4, (int) levels.get(0).get(0));
		
		assertEquals(1, (int) levels.get(1).get(0));
		assertEquals(3, (int) levels.get(1).get(1));
		
		assertEquals(1, levels.get(2).size());
		assertEquals(2, (int) levels.get(2).get(0));
	}
}
