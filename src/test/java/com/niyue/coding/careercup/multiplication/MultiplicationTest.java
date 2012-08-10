package com.niyue.coding.careercup.multiplication;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplicationTest {

	@Test
	public void testAddition() {
		Solution sl = new Solution();
		int[] sum = sl.add(new int[]{2}, new int[]{3});
		assertArrayEquals(new int[]{5}, sum);
	}
	
	@Test
	public void testMultiplySingleDigit() {
		Solution sl = new Solution();
		int[] product = sl.multiply(new int[]{2, 1}, 3, 0);
		assertArrayEquals(new int[]{0, 6, 3}, product);
	}
	
	@Test
	public void testMultiplySingleDigitWithShift() {
		Solution sl = new Solution();
		int[] product = sl.multiply(new int[]{1, 3}, 3, 1);
		assertArrayEquals(new int[]{0, 3, 9, 0}, product);
	}
	
	@Test
	public void testMultiplySingleDigitWithShiftAndCarry() {
		Solution sl = new Solution();
		int[] product = sl.multiply(new int[]{1, 4}, 3, 1);
		assertArrayEquals(new int[]{0, 4, 2, 0}, product);
	}
	
	@Test
	public void testMultiplySingleDigitWithoutShiftButCarry() {
		Solution sl = new Solution();
		int[] product = sl.multiply(new int[]{3, 4, 5}, 4, 0);
		assertArrayEquals(new int[]{1, 3, 8, 0}, product);
	}
}
