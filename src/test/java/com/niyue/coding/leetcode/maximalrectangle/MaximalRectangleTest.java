package com.niyue.coding.leetcode.maximalrectangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximalRectangleTest {

	@Test
	// nested loop count is incorrect
	public void test01() {
		Solution sl = new Solution();
		int maxArea = sl.maximalRectangle(new char[][] {{'0', '1'}});
		assertEquals(1, maxArea);
	}
	
	@Test
	// did not understand the problem and solved a wrong problem
	public void test111101() {
		Solution sl = new Solution();
		int maxArea = sl.maximalRectangle(new char[][] {{'1', '1'}, {'1', '1'}, {'0', '1'}});
		assertEquals(4, maxArea);
	}
	
	@Test
	// continuous count should start from zero once a zero is found
	public void testSixInARow() {
		Solution sl = new Solution();
		int maxArea = sl.maximalRectangle(new char[][] {{'0', '1', '1', '1', '1', '1', '1', '0', '1'}});
		assertEquals(6, maxArea);
	}
}
