package com.niyue.coding.careercup.inversioncount;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class InversionCountTest {

	@Test
	public void testCount() {
		InversionCount ic = new InversionCount();
		List<Integer> counts = ic.count(Arrays.asList(4, 12, 5, 6, 1, 34, 3, 2));
		assertThat(counts, is(Arrays.asList(3, 5, 3, 3, 0, 2, 1, 0)));
	}
	
	@Test
	public void testCountOneElement() {
		InversionCount ic = new InversionCount();
		List<Integer> counts = ic.count(Arrays.asList(4));
		assertThat(counts, is(Arrays.asList(0)));
	}
	
	@Test
	public void testCountTwoElements() {
		InversionCount ic = new InversionCount();
		List<Integer> counts = ic.count(Arrays.asList(4, 3));
		assertThat(counts, is(Arrays.asList(1, 0)));
	}
}
