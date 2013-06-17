package com.niyue.coding.careercup.dutchflag;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class DutchFlagTest {

	@Test
	public void testOneElement() {
		DutchFlag sort = new DutchFlag();
		int[] sorted = sort.sort(new int[] {0}, 0, 0);
		assertThat(sorted, is(new int[] {0}));
	}
	
	@Test
	public void testTwoElements() {
		DutchFlag sort = new DutchFlag();
		int[] sorted = sort.sort(new int[] {1, 0}, 0, 0);
		assertThat(sorted, is(new int[] {0, 1}));
	}
	
	@Test
	public void testThreeElements() {
		DutchFlag sort = new DutchFlag();
		int[] sorted = sort.sort(new int[] {2, 1, 0}, 1, 1);
		assertThat(sorted, is(new int[] {0, 1, 2}));
	}
}
