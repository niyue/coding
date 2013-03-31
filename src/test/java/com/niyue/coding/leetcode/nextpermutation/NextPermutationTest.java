package com.niyue.coding.leetcode.nextpermutation;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NextPermutationTest {

	@Test
	// should return the smaller index
	public void test12() {
		Solution sl = new Solution();
		int[] num = new int[] {1, 2};
		sl.nextPermutation(num);
		assertThat(num, equalTo(new int[]{2, 1}));
	}
	
	@Test
	// Arrays.sort toIndex is exclusive
	public void test132() {
		Solution sl = new Solution();
		int[] num = new int[] {1, 3, 2};
		sl.nextPermutation(num);
		assertThat(num, equalTo(new int[]{2, 1, 3}));
	}
}
