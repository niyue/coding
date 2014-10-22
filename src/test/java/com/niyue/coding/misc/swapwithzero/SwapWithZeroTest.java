package com.niyue.coding.misc.swapwithzero;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.niyue.coding.misc.swapzero.Solution;

public class SwapWithZeroTest {

	@Test
	public void test() {
		Solution sl = new Solution();
		int[] array = { 3, 8, 2, 4, 5, 0, 1, 7, 9, 6 };
		sl.sort(array, array.length);
		int[] result = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertArrayEquals(result, array);
	}

}
