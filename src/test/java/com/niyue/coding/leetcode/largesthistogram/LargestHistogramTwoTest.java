package com.niyue.coding.leetcode.largesthistogram;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargestHistogramTwoTest {

	@Test
	public void test2() {
		SolutionTwo sl = new SolutionTwo();
		int area = sl.largestRectangleArea(new int[]{2});
		assertEquals(2, area);
	}
	
	@Test
	public void test11() {
		SolutionTwo sl = new SolutionTwo();
		int area = sl.largestRectangleArea(new int[]{1, 1});
		assertEquals(2, area);
	}
	
	@Test
	public void test24() {
		SolutionTwo sl = new SolutionTwo();
		int area = sl.largestRectangleArea(new int[]{2, 4});
		assertEquals(4, area);
	}
	
	@Test
	public void test202() {
		SolutionTwo sl = new SolutionTwo();
		int area = sl.largestRectangleArea(new int[]{2, 0, 2});
		assertEquals(2, area);
	}
	
	@Test
	public void test212() {
		SolutionTwo sl = new SolutionTwo();
		int area = sl.largestRectangleArea(new int[]{2, 1, 2});
		assertEquals(3, area);
	}
}
