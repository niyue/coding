package com.niyue.coding.leetcode.medianoftwosortedarrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class MedianOfTwoSortedArraysTest {

	@Test
	// should use a + b / 2.0 instead of a + b / 2
	public void testEmptyAndTwo() {
		Solution sl = new Solution();
		double median = sl.findMedianSortedArrays(new int[] {}, new int[] {2, 3});
		assertEquals(2.5, median, 0.0001);
	}
	
	@Test
	public void testTwoAndTwo() {
		Solution sl = new Solution();
		double median = sl.findMedianSortedArrays(new int[] {1, 2}, new int[] {1, 2});
		assertEquals(1.5, median, 0.0001);
	}
}
