package com.niyue.coding.leetcode.largesthistogram;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargestHistogramTest {

	@Test
	public void test11() {
		Solution sl = new Solution();
		int area = sl.largestRectangleArea(new int[]{1, 1});
		assertEquals(2, area);
	}
	
	@Test
	public void test24() {
		Solution sl = new Solution();
		int area = sl.largestRectangleArea(new int[]{2, 4});
		assertEquals(4, area);
	}
	
	@Test
	public void test202() {
		Solution sl = new Solution();
		int area = sl.largestRectangleArea(new int[]{2, 0, 2});
		assertEquals(2, area);
	}
	
	@Test
	public void test212() {
		Solution sl = new Solution();
		int area = sl.largestRectangleArea(new int[]{2, 1, 2});
		assertEquals(3, area);
	}
}
