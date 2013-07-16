package com.niyue.coding.misc.minlargernumber;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MinLargerNumberTest {

	@Test
	public void testOneDigit() {
		MinLargerNumber minl = new MinLargerNumber();
		int result = minl.find(new int[] {2}, 1);
		assertThat(result, is(2));
	}
}
