package com.niyue.coding.misc.swapsort;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SwapSortTest {

	@Test
	public void testOneElement() {
		SwapSort ss = new SwapSort();
		int count = ss.count(new int[]{1});
		assertThat(count, is(0));
	}
	
	@Test
	public void testTwoIncreasingElement() {
		SwapSort ss = new SwapSort();
		int count = ss.count(new int[]{1, 2});
		assertThat(count, is(0));
	}
	
	@Test
	public void testTwodecreasingElement() {
		SwapSort ss = new SwapSort();
		int count = ss.count(new int[]{2, 1});
		assertThat(count, is(1));
	}
	
	@Test
	public void testNonDuplicateMix() {
		SwapSort ss = new SwapSort();
		int count = ss.count(new int[]{3, 1, 2, 4});
		assertThat(count, is(2));
	}
	
	@Test
	public void testDuplicates() {
		SwapSort ss = new SwapSort();
		int count = ss.count(new int[]{1, 2, 1, 2});
		assertThat(count, is(1));
	}
}
