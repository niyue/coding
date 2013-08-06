package com.niyue.coding.misc.longestequalzeroonesubarray;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class LongestEqualZeroOneSubArrayTest {

	@Test
	public void test01() {
		LongestEqualZeroOneSubArray array = new LongestEqualZeroOneSubArray();
		int[] longest = array.find(new int[] {0, 1});
		assertThat(longest, is(new int[] {0, 1}));
	}

	@Test
	public void test1101() {
		LongestEqualZeroOneSubArray array = new LongestEqualZeroOneSubArray();
		int[] longest = array.find(new int[] {1, 1, 0, 1});
		assertThat(longest, is(new int[] {1, 2}));
	}
	
	@Test
	public void test11001() {
		LongestEqualZeroOneSubArray array = new LongestEqualZeroOneSubArray();
		int[] longest = array.find(new int[] {1, 1, 0, 0, 1});
		assertThat(longest, is(new int[] {0, 3}));
	}
	
}
