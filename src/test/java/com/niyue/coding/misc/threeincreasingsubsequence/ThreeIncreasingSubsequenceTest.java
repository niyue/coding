package com.niyue.coding.misc.threeincreasingsubsequence;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ThreeIncreasingSubsequenceTest {

	@Test
	public void testLessThanThreeElementsList() {
		ThreeIncreasingSubsequence tis = new ThreeIncreasingSubsequence();
		List<Integer> result = tis.find(new int[] {1, 2});
		assertThat(result, is(Collections.<Integer>emptyList()));
	}
	
	@Test
	public void test123() {
		ThreeIncreasingSubsequence tis = new ThreeIncreasingSubsequence();
		List<Integer> result = tis.find(new int[] {1, 2, 3});
		assertThat(result, is(Arrays.asList(0, 1, 2)));
	}
	
	@Test
	public void test4123() {
		ThreeIncreasingSubsequence tis = new ThreeIncreasingSubsequence();
		List<Integer> result = tis.find(new int[] {4, 1, 5, 2, 6, 3});
		assertThat(result, is(Arrays.asList(1, 2, 4)));
	}
}
