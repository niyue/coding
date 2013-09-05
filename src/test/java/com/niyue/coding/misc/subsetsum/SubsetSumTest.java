package com.niyue.coding.misc.subsetsum;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SubsetSumTest {
	@Test
	public void testSingleElementSum() throws Exception {
		SubsetSum sss = new SubsetSum();
		int[] solution = sss.maxSubSet(new int[] {1}, 2, 1);
		assertThat(solution, is(new int[] {1}));
	}
	
	@Test
	public void testTwoElementsSum() throws Exception {
		SubsetSum sss = new SubsetSum();
		int[] solution = sss.maxSubSet(new int[] {1, 5}, 2, 1);
		assertThat(solution, is(new int[] {1}));
	}
	
	@Test
	public void testTwoElementsLargeSum() throws Exception {
		SubsetSum sss = new SubsetSum();
		int[] solution = sss.maxSubSet(new int[] {1, 5}, 7, 1);
		assertThat(solution, is(new int[] {5}));
	}
}
