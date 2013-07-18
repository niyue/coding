package com.niyue.coding.misc.longestcontinuoussubarray;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class LongestContinuousSubarrayTest {
	@Test
	public void testEmptyElement() {
		LongestContinuousSubarray lcs = new LongestContinuousSubarray();
		List<Integer> subarray = lcs.find(Collections.<Integer>emptyList());
		assertThat(subarray, is(Collections.<Integer>emptyList()));
	}
	
	@Test
	public void testSingleElement() {
		LongestContinuousSubarray lcs = new LongestContinuousSubarray();
		List<Integer> subarray = lcs.find(Arrays.asList(1));
		assertThat(subarray, is(Arrays.asList(1)));
	}
	
	@Test
	public void testTwoContinousElements() {
		LongestContinuousSubarray lcs = new LongestContinuousSubarray();
		List<Integer> subarray = lcs.find(Arrays.asList(1, 2));
		assertThat(subarray, is(Arrays.asList(1, 2)));
	}
	
	@Test
	public void testTwoNonContinousElements() {
		LongestContinuousSubarray lcs = new LongestContinuousSubarray();
		List<Integer> subarray = lcs.find(Arrays.asList(1, 3));
		assertThat(subarray, is(Arrays.asList(1)));
	}
	
	@Test
	public void testTwoContinousElementsInThree() {
		LongestContinuousSubarray lcs = new LongestContinuousSubarray();
		List<Integer> subarray = lcs.find(Arrays.asList(1, 4, 3));
		assertThat(subarray, is(Arrays.asList(4, 3)));
	}
	
	@Test
	public void testComplex() {
		LongestContinuousSubarray lcs = new LongestContinuousSubarray();
		List<Integer> subarray = lcs.find(Arrays.asList(4, 5, 1, 5, 7, 6, 8, 4, 1));
		assertThat(subarray, is(Arrays.asList(5, 7, 6, 8, 4)));
	}
}
