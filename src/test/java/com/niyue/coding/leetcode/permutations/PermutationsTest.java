package com.niyue.coding.leetcode.permutations;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class PermutationsTest {

	@Test
	// order for two parameters of ArrayList.add are reversed
	public void test12() {
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> permutations = sl.permute(new int[] {1, 2});
		assertEquals(2, permutations.size());
	}
}
