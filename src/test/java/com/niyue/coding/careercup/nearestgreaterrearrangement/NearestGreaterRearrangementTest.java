package com.niyue.coding.careercup.nearestgreaterrearrangement;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NearestGreaterRearrangementTest {

	@Test
	public void testOneElement() {
		NearestGreaterRearrangement ngr = new NearestGreaterRearrangement();
		List<Integer> arragement = ngr.rearrange(Arrays.asList(2), Arrays.asList(1));
		assertThat(arragement, is(Arrays.asList(2)));
	}
	
	@Test
	public void testOneElementNoLarger() {
		NearestGreaterRearrangement ngr = new NearestGreaterRearrangement();
		List<Integer> arragement = ngr.rearrange(Arrays.asList(2), Arrays.asList(3));
		assertThat(arragement, nullValue());
	}
	
	@Test
	public void testTwoElements() {
		NearestGreaterRearrangement ngr = new NearestGreaterRearrangement();
		List<Integer> arragement = ngr.rearrange(Arrays.asList(1, 2), Arrays.asList(1, 3));
		assertThat(arragement, is(Arrays.asList(2, 1)));
	}
	
	@Test
	public void testTwoElementsNoLarger() {
		NearestGreaterRearrangement ngr = new NearestGreaterRearrangement();
		List<Integer> arragement = ngr.rearrange(Arrays.asList(1, 1), Arrays.asList(1, 3));
		assertThat(arragement, nullValue());
	}
	
	@Test
	public void testThreeElements() {
		NearestGreaterRearrangement ngr = new NearestGreaterRearrangement();
		List<Integer> arragement = ngr.rearrange(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 3));
		assertThat(arragement, is(Arrays.asList(2, 1, 3)));
	}
	
	@Test
	public void testDuplicatedElements() {
		NearestGreaterRearrangement ngr = new NearestGreaterRearrangement();
		List<Integer> arragement = ngr.rearrange(Arrays.asList(1, 3, 3), Arrays.asList(3, 2, 3));
		assertThat(arragement, is(Arrays.asList(3, 3, 1)));
	}
	
	@Test
	public void testNine() {
		NearestGreaterRearrangement ngr = new NearestGreaterRearrangement();
		List<Integer> arragement = ngr.rearrange(Arrays.asList(0, 2, 1), Arrays.asList(1, 9, 9));
		assertThat(arragement, is(Arrays.asList(2, 0, 1)));
	}

}
