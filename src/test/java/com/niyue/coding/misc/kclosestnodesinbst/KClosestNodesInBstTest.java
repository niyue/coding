package com.niyue.coding.misc.kclosestnodesinbst;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class KClosestNodesInBstTest {

	@Test
	public void testSingleNode() {
		TreeNode root = new TreeNode(1);
		KClosestNodesInBst kclose = new KClosestNodesInBst();
		List<TreeNode> nodes = kclose.search(root, 2, 1);
		assertThat(nodes.size(), is(1));
		assertThat(nodes.get(0).val, is(1));
	}
	
	@Test
	public void testFind1ClosestIn2() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		KClosestNodesInBst kclose = new KClosestNodesInBst();
		List<TreeNode> nodes = kclose.search(root, 2, 1);
		assertThat(nodes.size(), is(1));
		assertThat(nodes.get(0).val, is(2));
	}
	
	@Test
	public void testFind2ClosestIn3() {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
		root.right = new TreeNode(2);
		KClosestNodesInBst kclose = new KClosestNodesInBst();
		List<TreeNode> nodes = kclose.search(root, 0, 2);
		assertThat(nodes.size(), is(2));
		assertThat(nodes.get(0).val, is(0));
		assertThat(nodes.get(1).val, is(-1));
	}
	
	@Test
	public void testFind3ClosestIn4() {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-3);
		root.left.right = new TreeNode(-1);
		root.right = new TreeNode(2);
		KClosestNodesInBst kclose = new KClosestNodesInBst();
		List<TreeNode> nodes = kclose.search(root, 0, 3);
		assertThat(nodes.size(), is(3));
		assertThat(nodes.get(0).val, is(0));
		assertThat(nodes.get(1).val, is(-1));
		assertThat(nodes.get(2).val, is(2));
	}
	
	@Test
	public void testLeftScrewedTreeFind4Closest() {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
		root.left.left = new TreeNode(-2);
		root.left.left.left = new TreeNode(-3);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(2);
		root.right.right.right = new TreeNode(3);
		KClosestNodesInBst kclose = new KClosestNodesInBst();
		List<TreeNode> nodes = kclose.search(root, 1, 4);
		assertThat(nodes.size(), is(4));
		assertThat(nodes.get(0).val, is(1));
		assertThat(nodes.get(1).val, is(0));
		assertThat(nodes.get(2).val, is(2));
		assertThat(nodes.get(3).val, is(-1));
	}
	
	@Test
	public void testFind4Closest() {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-2);
		root.left.left = new TreeNode(-3);
		root.left.right = new TreeNode(-1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(1);
		root.right.left.right = new TreeNode(2);
		KClosestNodesInBst kclose = new KClosestNodesInBst();
		List<TreeNode> nodes = kclose.search(root, 1, 4);
		assertThat(nodes.size(), is(4));
		assertThat(nodes.get(0).val, is(1));
		assertThat(nodes.get(1).val, is(0));
		assertThat(nodes.get(2).val, is(2));
		assertThat(nodes.get(3).val, is(-1));
	}
}
