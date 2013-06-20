package com.niyue.coding.careercup.nwaymerge;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NWayMergeTest {

	@Test
	public void testTwoWaysMerge() {
		NWayMerge merge = new NWayMerge();
		@SuppressWarnings("unchecked")
		List<Integer> numbers = merge.merge(Arrays.asList(
				Arrays.asList(1, 2), 
				Arrays.asList(2, 3) 
		));
		assertThat(numbers, is(Arrays.asList(1, 2, 2, 3)));
	}
	
	@Test
	public void testThreeWaysMerge() {
		NWayMerge merge = new NWayMerge();
		@SuppressWarnings("unchecked")
		List<Integer> numbers = merge.merge(Arrays.asList(
				Arrays.asList(1, 2), 
				Arrays.asList(2, 3),
				Arrays.asList(-1, 0) 
		));
		assertThat(numbers, is(Arrays.asList(-1, 0, 1, 2, 2, 3)));
	}
	
	@Test
	public void testOneWaysMerge() {
		NWayMerge merge = new NWayMerge();
		@SuppressWarnings("unchecked")
		List<Integer> numbers = merge.merge(Arrays.asList(
				Arrays.asList(1, 2) 
		));
		assertThat(numbers, is(Arrays.asList(1, 2)));
	}
}
