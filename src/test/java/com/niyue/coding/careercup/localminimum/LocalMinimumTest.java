package com.niyue.coding.careercup.localminimum;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class LocalMinimumTest {

	@Test
	public void testThreeNumbers() {
		LocalMinimum lm = new LocalMinimum();
		int min = lm.search(new int[] {2, 1, 3});
		assertThat(min, is(1));
	}
	
	@Test
	public void testEqualNumbers() {
		LocalMinimum lm = new LocalMinimum();
		int min = lm.search(new int[] {2, 2, 3});
		assertThat(min, is(1));
	}
	
	@Test
	public void testFourNumbers() {
		LocalMinimum lm = new LocalMinimum();
		int min = lm.search(new int[] {2, 2, 3, 3});
		assertThat(min, is(1));
	}
	
	@Test
	public void testFiveNumbers() {
		LocalMinimum lm = new LocalMinimum();
		int min = lm.search(new int[] {2, 1, 0, 2, 3});
		assertThat(min, is(2));
	}
	
	@Test
	public void testDeepLocalMin() {
		LocalMinimum lm = new LocalMinimum();
		int min = lm.search(new int[] {2, 1, 0, -1, 2, 3});
		assertThat(min, is(3));
	}
}
