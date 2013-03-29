package com.niyue.coding.leetcode.foursum;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class FourSumTest {

	@Test
	// result contains duplicated solution
	public void testAllZero() {
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> solutions = sl.fourSum(new int[] {0, 0, 0, 0}, 0);
		assertEquals(1, solutions.size());
	}
	
	@Test
	// result contains duplicated solution
	public void testDuplicatedSolution() {
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> solutions = sl.fourSum(new int[] {2, 1, 0, -1}, 2);
		assertEquals(1, solutions.size());
	}
}
