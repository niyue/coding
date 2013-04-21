package com.niyue.coding.leetcode.permutationsii;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class PermutationsIITest {

	@Test
	// incorrectly implement the finding swap index
	public void test112() {
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> permutations = sl.permuteUnique(new int[] {1, 1, 2});
		assertEquals(3, permutations.size());
		assertThat(permutations.get(0), equalTo(Arrays.asList(1, 1, 2)));
		assertThat(permutations.get(1), equalTo(Arrays.asList(1, 2, 1)));
		assertThat(permutations.get(2), equalTo(Arrays.asList(2, 1, 1)));
	}
	
	@Test
	// forget to reverse the remaining part
	public void test123() {
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> permutations = sl.permuteUnique(new int[] {1, 2, 3});
		assertEquals(6, permutations.size());
	}
}
