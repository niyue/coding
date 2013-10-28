package com.niyue.coding.leetcode.threesum;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ThreeSumTwoTest {

	@Test
	// should output number instead of number's index
	public void testAllZeros() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<ArrayList<Integer>> solutions = 
				sl.threeSum(new int[] {0, 0, 0});
		assertEquals(1, solutions.size());
	}
	
	@Test
	// result contains duplicated result
	public void testMinus101() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<ArrayList<Integer>> solutions = 
				sl.threeSum(new int[] {-1, 0, 1});
		assertEquals(1, solutions.size());
	}
	
	@Test
	// one case that result contains duplicated result
	public void testFourAllZeros() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<ArrayList<Integer>> solutions = 
				sl.threeSum(new int[] {0, 0, 0, 0});
		assertEquals(1, solutions.size());
	}
	
	@Test
	// one case that result contains duplicated result
	public void testTwoZeroes() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<ArrayList<Integer>> solutions = 
				sl.threeSum(new int[] {-1, 0, 1, 0});
		assertEquals(1, solutions.size());
	}
	
	@Test
	public void testSample() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<ArrayList<Integer>> solutions = 
				sl.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
		assertEquals(2, solutions.size());
		assertThat(solutions.get(0), is(Arrays.asList(-1, -1, 2)));
		assertThat(solutions.get(1), is(Arrays.asList(-1, 0, 1)));
	}
}
