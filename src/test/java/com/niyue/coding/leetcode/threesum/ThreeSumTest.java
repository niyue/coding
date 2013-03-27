package com.niyue.coding.leetcode.threesum;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ThreeSumTest {

	@Test
	// should output number instead of number's index
	public void testAllZeros() {
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> solutions = 
				sl.threeSum(new int[] {0, 0, 0});
		assertEquals(1, solutions.size());
	}
	
	@Test
	// result contains duplicated result
	public void testMinus101() {
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> solutions = 
				sl.threeSum(new int[] {-1, 0, 1});
		assertEquals(1, solutions.size());
	}
	
	@Test
	// one case that result contains duplicated result
	public void testFourAllZeros() {
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> solutions = 
				sl.threeSum(new int[] {0, 0, 0, 0});
		assertEquals(1, solutions.size());
	}
	
	@Test
	// one case that result contains duplicated result
	public void testTwoZeroes() {
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> solutions = 
				sl.threeSum(new int[] {-1, 0, 1, 0});
		assertEquals(1, solutions.size());
	}
}
