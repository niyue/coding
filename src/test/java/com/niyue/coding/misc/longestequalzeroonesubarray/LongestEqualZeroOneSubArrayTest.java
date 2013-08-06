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

}
