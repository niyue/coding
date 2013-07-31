package com.niyue.coding.misc.intersectinterval;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

import com.niyue.coding.careercup.disjointinterval.DisjointInterval.Interval;

public class IntersectIntervalTest {

	@Test
	public void testOneInterval() {
		IntersectInterval ii = new IntersectInterval();
		Interval result = ii.search(Arrays.asList(new Interval(0, 2)), 1);
		assertThat(result, notNullValue());
		assertThat(result.start, is(0));
		assertThat(result.end, is(2));
	}
	
	@Test
	public void testOneIntervalNonIntersectingAtEnd() {
		IntersectInterval ii = new IntersectInterval();
		Interval result = ii.search(Arrays.asList(new Interval(0, 2)), 3);
		assertThat(result, nullValue());
	}

	@Test
	public void testOneIntervalNonIntersectingAtFront() {
		IntersectInterval ii = new IntersectInterval();
		Interval result = ii.search(Arrays.asList(new Interval(0, 2)), -1);
		assertThat(result, nullValue());
	}
	
	@Test
	public void testTwoIntervalsNonIntersectingInMiddle() {
		IntersectInterval ii = new IntersectInterval();
		Interval result = ii.search(Arrays.asList(
				new Interval(0, 2),
				new Interval(5, 9)), 3);
		assertThat(result, nullValue());
	}
	
	@Test
	public void testTwoIntervalsNonIntersectingInTheEnd() {
		IntersectInterval ii = new IntersectInterval();
		Interval result = ii.search(Arrays.asList(
				new Interval(0, 2),
				new Interval(5, 9)), 20);
		assertThat(result, nullValue());
	}
	
	@Test
	public void testTwoNonOverlappedIntervals() {
		IntersectInterval ii = new IntersectInterval();
		Interval result = ii.search(Arrays.asList(
				new Interval(0, 2),
				new Interval(3, 5)), 4);
		assertThat(result, notNullValue());
		assertThat(result.start, is(3));
		assertThat(result.end, is(5));
	}
	
	@Test
	public void testTwoNonOverlappedIntervalsFirstInterval() {
		IntersectInterval ii = new IntersectInterval();
		Interval result = ii.search(Arrays.asList(
				new Interval(0, 2),
				new Interval(3, 5)), 1);
		assertThat(result, notNullValue());
		assertThat(result.start, is(0));
		assertThat(result.end, is(2));
	}
	
	@Test
	public void testTwoOverlappedIntervals() {
		IntersectInterval ii = new IntersectInterval();
		Interval result = ii.search(Arrays.asList(
				new Interval(0, 4),
				new Interval(3, 5)), 4);
		assertThat(result, notNullValue());
		assertThat(result.start, is(0));
		assertThat(result.end, is(4));
	}
	
	@Test
	public void testTwoNestedIntervals() {
		IntersectInterval ii = new IntersectInterval();
		Interval result = ii.search(Arrays.asList(
				new Interval(0, 8),
				new Interval(3, 5)), 4);
		assertThat(result, notNullValue());
		assertThat(result.start, is(0));
		assertThat(result.end, is(8));
	}
}
