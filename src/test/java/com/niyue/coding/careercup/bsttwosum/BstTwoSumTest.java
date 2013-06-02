package com.niyue.coding.careercup.bsttwosum;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class BstTwoSumTest {

	@Test
	public void testOnePair() {
		BstTwoSum sum = new BstTwoSum();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		List<List<Integer>> sums = sum.twoSum(root, 6);
		assertThat(sums.size(), is(1));
		assertThat(sums, is(Collections.singletonList(Arrays.asList(2, 4))));
	}
	
	@Test
	public void testNoPair() {
		BstTwoSum sum = new BstTwoSum();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		List<List<Integer>> sums = sum.twoSum(root, 8);
		assertTrue(sums.isEmpty());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testTwoPair() {
		BstTwoSum sum = new BstTwoSum();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(5);
		List<List<Integer>> sums = sum.twoSum(root, 6);
		assertThat(sums.size(), is(2));
		assertThat(sums, is(Arrays.asList(
				Arrays.asList(1, 5), 
				Arrays.asList(2, 4))));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testTwoPairWithHalfValue() {
		BstTwoSum sum = new BstTwoSum();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);	
		root.right = new TreeNode(5);
		List<List<Integer>> sums = sum.twoSum(root, 6);
		assertThat(sums.size(), is(2));
		assertThat(sums, is(Arrays.asList(
				Arrays.asList(1, 5), 
				Arrays.asList(2, 4))));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAnotherTwoPair() {
		BstTwoSum sum = new BstTwoSum();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);	
		root.right = new TreeNode(5);
		List<List<Integer>> sums = sum.twoSum(root, 7);
		assertThat(sums.size(), is(2));
		assertThat(sums, is(Arrays.asList(
				Arrays.asList(2, 5), 
				Arrays.asList(3, 4))));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSixNodes() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		BstTwoSum sum = new BstTwoSum();
		List<List<Integer>> sums = sum.twoSum(root, 9);
		assertThat(sums.size(), is(2));
		assertThat(sums, is(Arrays.asList(
				Arrays.asList(2, 7), 
				Arrays.asList(3, 6))));
		
		sums = sum.twoSum(root, 11);
		assertThat(sums.size(), is(1));
		assertThat(sums, is(Arrays.asList(
				Arrays.asList(4, 7))));
		
		sums = sum.twoSum(root, 13);
		assertThat(sums.size(), is(1));
		assertThat(sums, is(Arrays.asList(
				Arrays.asList(6, 7))));
		
		sums = sum.twoSum(root, 3);
		assertThat(sums.size(), is(1));
		assertThat(sums, is(Arrays.asList(
				Arrays.asList(1, 2))));
	}
}
