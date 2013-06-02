package com.niyue.coding.careercup.bsttwosum;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class ReverseInorderIteratorTest {

	@Test
	public void testReverseInorderIterator() {
		TreeNode root = new TreeNode(1);
		Iterator<TreeNode> iter = new ReverseInorderIterator(root);
		assertIteration(iter, Arrays.asList(1));
	}
	
	@Test
	public void testReverseInorderIterator12() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		Iterator<TreeNode> iter = new ReverseInorderIterator(root);
		assertIteration(iter, Arrays.asList(2, 1));
	}
	
	@Test
	public void testReverseInorderIterator123() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		Iterator<TreeNode> iter = new ReverseInorderIterator(root);
		assertIteration(iter, Arrays.asList(3, 2, 1));
	}
	
	private void assertIteration(Iterator<TreeNode> iter, List<Integer> values) {
		List<Integer> actualValues = new ArrayList<Integer>();
		while(iter.hasNext()) {
			actualValues.add(iter.next().val);
		}
		assertThat(actualValues, equalTo(values));
	}
}
