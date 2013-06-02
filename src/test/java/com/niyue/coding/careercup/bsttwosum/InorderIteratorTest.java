package com.niyue.coding.careercup.bsttwosum;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class InorderIteratorTest {

	@Test(expected = NoSuchElementException.class)
	public void testNull() {
		TreeNode root = null;
		InorderIterator iter = new InorderIterator(root);
		assertFalse(iter.hasNext());
		iter.next();
	}
	
	@Test
	public void testSingleRoot() {
		TreeNode root = new TreeNode(4);
		InorderIterator iter = new InorderIterator(root);
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(4));
		assertFalse(iter.hasNext());
	}
	
	@Test
	public void testTwoNodes() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		InorderIterator iter = new InorderIterator(root);
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(2));
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(4));
		assertFalse(iter.hasNext());
	}
	
	@Test
	public void testThreeNodes() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		InorderIterator iter = new InorderIterator(root);
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(2));
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(4));
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(6));
		assertFalse(iter.hasNext());
	}
	
	@Test
	public void testSkewNodes() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		InorderIterator iter = new InorderIterator(root);
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(1));
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(2));
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(4));
		assertFalse(iter.hasNext());
	}
	
	@Test
	public void testSixNodes() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		InorderIterator iter = new InorderIterator(root);
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(1));
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(2));
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(3));
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(4));
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(6));
		assertTrue(iter.hasNext());
		assertThat(iter.next().val, is(7));
		assertFalse(iter.hasNext());
	}
}
