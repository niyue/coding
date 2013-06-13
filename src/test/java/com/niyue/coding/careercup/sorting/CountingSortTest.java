package com.niyue.coding.careercup.sorting;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CountingSortTest {
	@Test
	// forget to decrease count[i]
	public void testSortOneElement() throws Exception {
		CountingSort sort = new CountingSort();
		int[] order = sort.sort(new int[] {1}, 0, 1);
		assertThat(order, is(new int[] {1}));
	}
	
	@Test
	// sorted value should be i + min instead of count[i] + min
	public void testSortTwoElements() throws Exception {
		CountingSort sort = new CountingSort();
		int[] order = sort.sort(new int[] {1, 0}, 0, 1);
		assertThat(order, is(new int[] {0, 1}));
	}
	
	@Test
	public void testSortDuplicatedElements() throws Exception {
		CountingSort sort = new CountingSort();
		int[] order = sort.sort(new int[] {1, 1, 0}, 0, 1);
		assertThat(order, is(new int[] {0, 1, 1}));
	}
	
	@Test
	public void testSortRangedElements() throws Exception {
		CountingSort sort = new CountingSort();
		int[] order = sort.sort(new int[] {2, 3, 4, 3}, 2, 4);
		assertThat(order, is(new int[] {2, 3, 3, 4}));
	}
}
