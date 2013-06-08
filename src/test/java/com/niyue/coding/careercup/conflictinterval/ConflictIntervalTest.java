package com.niyue.coding.careercup.conflictinterval;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.niyue.coding.careercup.conflictinterval.ConflictInterval.Interval;

public class ConflictIntervalTest {

	@Test
	public void testOneInterval() {
		ConflictInterval ci = new ConflictInterval();
		List<Interval> intervals = ci.markConflict(Arrays.asList(new Interval(0, 1)));
		assertConflict(intervals, false);
	}
	
	@Test
	public void testTwoNonConflictIntervals() {
		ConflictInterval ci = new ConflictInterval();
		List<Interval> intervals = ci.markConflict(Arrays.asList(
				new Interval(0, 1), 
				new Interval(2, 3)));
		assertConflict(intervals, false, false);
	}
	
	@Test
	public void testTwoConflictIntervals() {
		ConflictInterval ci = new ConflictInterval();
		List<Interval> intervals = ci.markConflict(Arrays.asList(
				new Interval(0, 1), 
				new Interval(0, 3)));
		assertConflict(intervals, true, true);
	}
	
	@Test
	public void testThreeNonConflictIntervalsWithNeiboughs() {
		ConflictInterval ci = new ConflictInterval();
		List<Interval> intervals = ci.markConflict(Arrays.asList(
				new Interval(0, 1), 
				new Interval(2, 3),
				new Interval(3, 4)));
		assertConflict(intervals, false, false, false);
	}
	
	@Test
	public void testThreeConflictIntervals() {
		ConflictInterval ci = new ConflictInterval();
		List<Interval> intervals = ci.markConflict(Arrays.asList(
				new Interval(0, 1), 
				new Interval(2, 3),
				new Interval(2, 4)));
		assertConflict(intervals, false, true, true);
	}
	
	@Test
	public void testNestedConflictIntervals() {
		ConflictInterval ci = new ConflictInterval();
		List<Interval> intervals = ci.markConflict(Arrays.asList(
				new Interval(0, 10), 
				new Interval(2, 3),
				new Interval(5, 6)));
		assertConflict(intervals, true, true, true);
	}
	
	private void assertConflict(List<Interval> intervals, boolean... conflicts) {
		assertThat(intervals.size(), is(conflicts.length));
		for(int i = 0; i < intervals.size(); i++) {
			assertThat(intervals.get(i).conflict, is(conflicts[i]));
		}
	}
}
