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
	
	@Test
	public void testTwoDigits() {
		MinLargerNumber minl = new MinLargerNumber();
		int result = minl.find(new int[] {2}, 12);
		assertThat(result, is(22));
	}
	
	@Test
	public void testTwoDifferentDigits() {
		MinLargerNumber minl = new MinLargerNumber();
		int result = minl.find(new int[] {2, 3}, 12);
		assertThat(result, is(22));
	}
	
	@Test
	public void testOneMoreDigitLarger() {
		MinLargerNumber minl = new MinLargerNumber();
		int result = minl.find(new int[] {1}, 12);
		assertThat(result, is(111));
	}
	
	@Test
	public void testThreeDigits() {
		MinLargerNumber minl = new MinLargerNumber();
		int result = minl.find(new int[] {1, 5, 7}, 56);
		assertThat(result, is(57));
	}
	
	@Test
	public void testTwoDigitsNoLarger() {
		MinLargerNumber minl = new MinLargerNumber();
		int result = minl.find(new int[] {1}, 56);
		assertThat(result, is(111));
	}
	
	@Test
	public void testOneDigitsNoLarger() {
		MinLargerNumber minl = new MinLargerNumber();
		int result = minl.find(new int[] {1}, 5);
		assertThat(result, is(11));
	}
	
	@Test
	public void testBacktrackDigits() {
		MinLargerNumber minl = new MinLargerNumber();
		int result = minl.find(new int[] {5, 7}, 58);
		assertThat(result, is(75));
	}
}
