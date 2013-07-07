package com.niyue.coding.careercup.quickselect;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QuickSelectTest {

	@Test
	public void testOneSelectFirst() {
		QuickSelect qs = new QuickSelect();
		int kth = qs.select(new int[] {1}, 0);
		assertThat(kth, is(1));
	}
	
	@Test
	public void testTwoSelectFirst() {
		QuickSelect qs = new QuickSelect();
		int kth = qs.select(new int[] {1, 2}, 0);
		assertThat(kth, is(1));
	}
	
	@Test
	public void testTwoSelectSecond() {
		QuickSelect qs = new QuickSelect();
		int kth = qs.select(new int[] {1, 2}, 1);
		assertThat(kth, is(2));
	}
	
	@Test
	public void testThreeSelectSecond() {
		QuickSelect qs = new QuickSelect();
		int kth = qs.select(new int[] {3, 1, 2}, 1);
		assertThat(kth, is(2));
	}
	
	@Test
	public void testSelectNonExistK() {
		QuickSelect qs = new QuickSelect();
		int kth = qs.select(new int[] {3, 1, 2}, 4);
		assertThat(kth, is(-1));
	}
	
	@Test
	public void testComplex() {
		QuickSelect qs = new QuickSelect();
		int kth = qs.select(new int[] {3, 1, 2, 5, 5, 6}, 4);
		assertThat(kth, is(5));
	}
}
