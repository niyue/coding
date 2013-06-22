package com.niyue.coding.leetcode.romantointeger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RomanToIntegerTest {

	@Test
	public void testOne() {
		Solution sl = new Solution();
		int number = sl.romanToInt("I");
		assertThat(number, is(1));
	}
}
