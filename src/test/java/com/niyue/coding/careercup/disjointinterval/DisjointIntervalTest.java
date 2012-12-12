package com.niyue.coding.careercup.disjointinterval;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.niyue.coding.careercup.disjointinterval.DisjointInterval.Interval;

public class DisjointIntervalTest {

	@Test
	public void testSingleInterval() {
		DisjointInterval di = new DisjointInterval();
		List<Interval> intervals = di.merge(new Interval(1, 2));
		assertThat(intervals.size(), equalTo(1));
	}
	
	@Test
	public void testTwoDisjointIntervals() {
		DisjointInterval di = new DisjointInterval();
		List<Interval> intervals = di.merge(
				new Interval(1, 2),
				new Interval(3, 4)
		);
		assertThat(intervals.size(), equalTo(2));
		assertThat(intervals, equalTo(Arrays.asList(
				new Interval(1, 2),
				new Interval(3, 4))));
	}
	
	@Test
	public void testTwoJointIntervals() {
		DisjointInterval di = new DisjointInterval();
		List<Interval> intervals = di.merge(
				new Interval(1, 5),
				new Interval(3, 6)
		);
		assertThat(intervals.size(), equalTo(1));
		assertThat(intervals, equalTo(Arrays.asList(
				new Interval(1, 6))));
	}
	
	@Test
	public void testTwoJointIntervalsWithSameStartEnd() {
		DisjointInterval di = new DisjointInterval();
		List<Interval> intervals = di.merge(
				new Interval(1, 3),
				new Interval(3, 6)
		);
		assertThat(intervals.size(), equalTo(1));
		assertThat(intervals, equalTo(Arrays.asList(
				new Interval(1, 6))));
	}
	
	@Test
	public void testMultipleJointIntervals() {
		DisjointInterval di = new DisjointInterval();
		List<Interval> intervals = di.merge(
				new Interval(1, 5),
				new Interval(10, 15),
				new Interval(20, 25),
				new Interval(12, 27)
		);
		assertThat(intervals.size(), equalTo(2));
		assertThat(intervals, equalTo(Arrays.asList(
				new Interval(1, 5),
				new Interval(10, 27))));
	}

}
