package com.niyue.coding.leetcode.insertinterval;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.niyue.coding.leetcode.insertinterval.SolutionTwo.Interval;

public class InsertIntervalTwoTest {

	@Test
	// do not consider empty set
	public void testEmptySet() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Interval> intervals = sl.insert(
				intervals(), 
				new Interval(5, 7));
		assertEquals(1, intervals.size());
		assertEquals(5, intervals.get(0).start);
		assertEquals(7, intervals.get(0).end);
	}
	
	@Test
	// the definition for binary search is not clear
	public void testOverlap() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Interval> intervals = sl.insert(
				intervals(new Interval(1, 5)), 
				new Interval(2, 3));
		assertEquals(1, intervals.size());
		assertEquals(1, intervals.get(0).start);
		assertEquals(5, intervals.get(0).end);
	}
	
	@Test
	// binary search has a incorrect index assignment
	public void testInsertOverlap() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Interval> intervals = sl.insert(
				intervals(new Interval(1, 5)), 
				new Interval(1, 7));
		assertEquals(1, intervals.size());
		assertEquals(1, intervals.get(0).start);
		assertEquals(7, intervals.get(0).end);
	}
	
	@Test
	// forget to add previous interval to merged intervals in this case
	public void testInsertDisjoint() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Interval> intervals = sl.insert(
				intervals(new Interval(1, 5)), 
				new Interval(6, 8));
		assertEquals(2, intervals.size());
		assertEquals(1, intervals.get(0).start);
		assertEquals(5, intervals.get(0).end);
		assertEquals(6, intervals.get(1).start);
		assertEquals(8, intervals.get(1).end);
	}
	
	@Test
	// forget to add previous interval to merged intervals in this case
	public void testInsertDisjointBefore() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Interval> intervals = sl.insert(
				intervals(new Interval(1, 5)), 
				new Interval(0, 0));
		assertEquals(2, intervals.size());
		assertEquals(0, intervals.get(0).start);
		assertEquals(0, intervals.get(0).end);
		assertEquals(1, intervals.get(1).start);
		assertEquals(5, intervals.get(1).end);
	}
	
	@Test
	// do not consider insertion point is the same with second search
	public void testInsertBefore() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Interval> intervals = sl.insert(
				intervals(new Interval(1, 5)), 
				new Interval(0, 3));
		assertEquals(1, intervals.size());
		assertEquals(0, intervals.get(0).start);
		assertEquals(5, intervals.get(0).end);
	}
	
	@Test
	public void testConnectThree() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Interval> intervals = sl.insert(
				intervals(new Interval(1, 5), new Interval(6, 8)), 
				new Interval(5, 6));
		assertEquals(1, intervals.size());
		assertEquals(1, intervals.get(0).start);
		assertEquals(8, intervals.get(0).end);
	}
	
	@Test
	public void testOverlapAll() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Interval> intervals = sl.insert(
				intervals(new Interval(1, 5), new Interval(6, 8)), 
				new Interval(0, 9));
		assertEquals(1, intervals.size());
		assertEquals(0, intervals.get(0).start);
		assertEquals(9, intervals.get(0).end);
	}
	
	@Test
	// binary search is not implemented correctly
	public void testOverlapAllThree() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Interval> intervals = sl.insert(
				intervals(new Interval(2, 5), new Interval(6, 7), new Interval(8, 9)), 
				new Interval(0, 10));
		assertEquals(1, intervals.size());
		assertEquals(0, intervals.get(0).start);
		assertEquals(10, intervals.get(0).end);
	}
	
	@Test
	// binary search is not implemented correctly
	public void testOverlapOne() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Interval> intervals = sl.insert(
				intervals(new Interval(0, 5), new Interval(9, 12)), 
				new Interval(7, 16));
		assertEquals(2, intervals.size());
		assertEquals(0, intervals.get(0).start);
		assertEquals(5, intervals.get(0).end);
		assertEquals(7, intervals.get(1).start);
		assertEquals(16, intervals.get(1).end);
	}
	
	@Test
	// binary search is not implemented correctly
	public void testComplex() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Interval> intervals = sl.insert(
				intervals(new Interval(0, 2), new Interval(3, 5), new Interval(6, 8), new Interval(10, 12), new Interval(13, 15)), 
				new Interval(4, 7));
		assertEquals(4, intervals.size());
		assertEquals(0, intervals.get(0).start);
		assertEquals(2, intervals.get(0).end);
		assertEquals(3, intervals.get(1).start);
		assertEquals(8, intervals.get(1).end);
		assertEquals(10, intervals.get(2).start);
		assertEquals(12, intervals.get(2).end);
		assertEquals(13, intervals.get(3).start);
		assertEquals(15, intervals.get(3).end);
	}
	
	private ArrayList<Interval> intervals(Interval... intervalArray) {
		return new ArrayList<Interval>(Arrays.asList(intervalArray));
	}
}
