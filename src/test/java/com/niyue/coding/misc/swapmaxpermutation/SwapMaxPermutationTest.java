package com.niyue.coding.misc.swapmaxpermutation;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SwapMaxPermutationTest {

	@Test
	public void testSingleDigit() {
		SwapMaxPermutation smp = new SwapMaxPermutation();
		int[] max = smp.find(new int[] {1}, 2);
		assertThat(max, is(new int[] {1}));
	}
	
	@Test
	public void testTwoDigitsNoSwapTimes() {
		SwapMaxPermutation smp = new SwapMaxPermutation();
		int[] max = smp.find(new int[] {1, 2}, 0);
		assertThat(max, is(new int[] {1, 2}));
	}
	
	@Test
	public void testTwoDigits() {
		SwapMaxPermutation smp = new SwapMaxPermutation();
		int[] max = smp.find(new int[] {1, 2}, 2);
		assertThat(max, is(new int[] {2, 1}));
	}
	
	@Test
	public void testThreeDigits() {
		SwapMaxPermutation smp = new SwapMaxPermutation();
		int[] max = smp.find(new int[] {1, 2, 3}, 2);
		assertThat(max, is(new int[] {3, 1, 2}));
	}
	
	@Test
	public void testFourDigits() {
		SwapMaxPermutation smp = new SwapMaxPermutation();
		int[] max = smp.find(new int[] {1, 2, 3, 4}, 2);
		assertThat(max, is(new int[] {3, 1, 2, 4}));
	}
	
	@Test
	public void testFourDigitsThreeTimesSwap() {
		SwapMaxPermutation smp = new SwapMaxPermutation();
		int[] max = smp.find(new int[] {1, 2, 3, 4}, 3);
		assertThat(max, is(new int[] {4, 1, 2, 3}));
	}
	
	@Test
	public void testFourDigitsFourTimesSwap() {
		SwapMaxPermutation smp = new SwapMaxPermutation();
		int[] max = smp.find(new int[] {1, 2, 3, 4}, 4);
		assertThat(max, is(new int[] {4, 2, 1, 3}));
	}
	
	@Test
	public void testMaxDigitInPosition() {
		SwapMaxPermutation smp = new SwapMaxPermutation();
		int[] max = smp.find(new int[] {4, 2, 1, 3}, 1);
		assertThat(max, is(new int[] {4, 2, 3, 1}));
	}

}
