package com.niyue.coding.leetcode.permutationsequence;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermutationSequenceTest {

	@Test
	// handle 1-based pi and 0-based k 
	public void test21() {
		Solution sl = new Solution();
		String permutation = sl.getPermutation(2, 1);
		assertEquals("12", permutation);
	}
	
	@Test
	// handle 1-based pi and 0-based k
	public void test31() {
		Solution sl = new Solution();
		String permutation = sl.getPermutation(3, 1);
		assertEquals("123", permutation);
	}
}
