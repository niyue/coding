package com.niyue.coding.careercup.mergebst;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class MergeBstTest {
	@Test
	public void testMergeEmptyNodeWithEmptyNode() {
		TreeNode t1 = null;
		TreeNode t2 = null;
		MergeBst mb = new MergeBst();
		TreeNode tree = mb.merge(t1, t2);
		assertThat(tree, nullValue());
	}
	
	@Test
	public void testMergeOneNodeWithEmptyNode() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = null;
		MergeBst mb = new MergeBst();
		TreeNode tree = mb.merge(t1, t2);
		assertThat(tree.val, is(1));
		assertThat(tree.left, nullValue());
		assertThat(tree.right, nullValue());
	}
	
	@Test
	public void testMergeOneNodeWithOneNode() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		MergeBst mb = new MergeBst();
		TreeNode tree = mb.merge(t1, t2);
		assertThat(tree.val, is(1));
		assertThat(tree.left, nullValue());
		assertThat(tree.right.val, is(2));
	}
	
	@Test
	public void testMergeTwoNodesWithOneNode() {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(0);
		TreeNode t2 = new TreeNode(2);
		MergeBst mb = new MergeBst();
		TreeNode tree = mb.merge(t1, t2);
		assertThat(tree.val, is(1));
		assertThat(tree.left.val, is(0));
		assertThat(tree.right.val, is(2));
	}
	
	@Test
	public void testMergeTwoNodesWithTwoNodes() {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(0);
		TreeNode t2 = new TreeNode(2);
		t2.right = new TreeNode(3);
		MergeBst mb = new MergeBst();
		TreeNode tree = mb.merge(t1, t2);
		assertThat(tree.val, is(1));
		assertThat(tree.left.val, is(0));
		assertThat(tree.right.val, is(2));
		assertThat(tree.right.right.val, is(3));
	}
	
	@Test
	public void testMergeThreeNodesWithTwoNodes() {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(0);
		t1.right = new TreeNode(2);
		TreeNode t2 = new TreeNode(5);
		t2.right = new TreeNode(6);
		MergeBst mb = new MergeBst();
		TreeNode tree = mb.merge(t1, t2);
		assertThat(tree.val, is(2));
		assertThat(tree.left.val, is(0));
		assertThat(tree.left.right.val, is(1));
		assertThat(tree.right.val, is(5));
		assertThat(tree.right.right.val, is(6));
	}
	
	@Test
	public void testMergeThreeNodesWithThreeNodes() {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(0);
		t1.right = new TreeNode(2);
		TreeNode t2 = new TreeNode(5);
		t2.left = new TreeNode(4);
		t2.right = new TreeNode(6);
		MergeBst mb = new MergeBst();
		TreeNode tree = mb.merge(t1, t2);
		assertThat(tree.val, is(2));
		assertThat(tree.left.val, is(0));
		assertThat(tree.left.right.val, is(1));
		assertThat(tree.right.val, is(5));
		assertThat(tree.right.left.val, is(4));
		assertThat(tree.right.right.val, is(6));
	}
}
