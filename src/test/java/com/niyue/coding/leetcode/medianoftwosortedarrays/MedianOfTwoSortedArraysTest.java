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
	// isEven is not correctly calculated
	public void testTwoSameArrays() {
		Solution sl = new Solution();
		double median = sl.findMedianSortedArrays(new int[] {1, 2}, new int[] {1, 2});
		assertEquals(1.5, median, 0.0001);
	}
	
	@Test
	// if both A and B has even length, when A[mid] == B[mid], this case is not handled correctly
	public void testTwoDifferentArrays() {
		Solution sl = new Solution();
		double median = sl.findMedianSortedArrays(new int[] {1, 1}, new int[] {1, 2});
		assertEquals(1, median, 0.0001);
	}
	
	@Test
	public void testTwoMedianInSameArray() {
		Solution sl = new Solution();
		double median = sl.findMedianSortedArrays(new int[] {5, 6}, new int[] {3, 7});
		assertEquals(5.5, median, 0.0001);
	}
	

	@Test
	public void testLargerThanFour() {
		Solution sl = new Solution();
		double median = sl.findMedianSortedArrays(new int[] {1, 2}, new int[] {1, 2, 3});
		assertEquals(2, median, 0.0001);
	}
	
	@Test
	public void testEvenLengthAndOddLength() {
		Solution sl = new Solution();
		double median = sl.findMedianSortedArrays(new int[] {6, 7}, new int[] {1, 2, 3, 4, 5, 8, 9});
		assertEquals(5, median, 0.0001);
	}
}
