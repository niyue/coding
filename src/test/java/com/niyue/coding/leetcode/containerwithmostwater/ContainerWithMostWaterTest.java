package com.niyue.coding.leetcode.containerwithmostwater;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContainerWithMostWaterTest {

	@Test
	// have to separate storage for indexes and values
	public void test11() {
		Solution sl = new Solution();
		int max = sl.maxArea(new int[] {1, 1});
		assertEquals(1, max);
	}
	
	@Test
	// have to implement a binary search by myself instead of relying on Collections.binarySearch
	public void test12() {
		Solution sl = new Solution();
		int max = sl.maxArea(new int[] {1, 2});
		assertEquals(1, max);
	}
}
