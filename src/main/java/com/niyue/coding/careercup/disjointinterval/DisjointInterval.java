package com.niyue.coding.careercup.disjointinterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given a list of intervals e.g. [(1, 5), (10, 15), (20, 25), (12, 27)]
 * Write a function to merge them into a sorted list of disjoint intervals: [(1, 5), (10, 27)].
 *
 */
public class DisjointInterval {
	public List<Interval> merge(Interval... disjoinIntervals) {
		List<Interval> disjointIntervalList = new ArrayList<Interval>();
		for(Interval i : disjoinIntervals) {
			disjointIntervalList.add(i);
		}
		disjointIntervalList.add(new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));
		
		Collections.sort(disjointIntervalList);
		
		List<Interval> mergedIntervals = new ArrayList<Interval>();
		
		Interval current = disjointIntervalList.get(0);
		for(int i=0;i<disjointIntervalList.size()-1;i++) {
			Interval next = disjointIntervalList.get(i+1);
			if(isJoint(current, next)) {
				current = merge(current, next);
			} else {
				mergedIntervals.add(current);
				current = next;
			}
		}
		return mergedIntervals;
	}
	
	private Interval merge(Interval i1, Interval i2) {
		return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
	}
	
	private boolean isJoint(Interval i1, Interval i2) {
		return i1.end >= i2.start;
	}
	
	public static class Interval implements Comparable<Interval> {
		public int start;
		public int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Interval i) {
			return this.start - i.start;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + end;
			result = prime * result + start;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Interval other = (Interval) obj;
			if (end != other.end)
				return false;
			if (start != other.start)
				return false;
			return true;
		}
	}
}
