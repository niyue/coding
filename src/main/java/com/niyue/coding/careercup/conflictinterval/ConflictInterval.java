package com.niyue.coding.careercup.conflictinterval;

import java.util.Collections;
import java.util.List;

// You are given a list of intervals e.g. [(1, 5), (10, 15), (20, 25), (12, 27)]
// Mark the joint ones as conflict
public class ConflictInterval {
	public List<Interval> markConflict(List<Interval> intervals) {
		Collections.sort(intervals);
		Integer lastEnd = null;
		for(int i = 0; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			if(lastEnd != null && isJoint(current, lastEnd)) {
				Interval prev = intervals.get(i - 1);
				prev.conflict = true;
				current.conflict = true;
			}
			lastEnd = lastEnd == null ? current.end : Math.max(lastEnd, current.end);
		}
		return intervals;
	}
	
	private boolean isJoint(Interval i, int lastEnd) {
		return lastEnd > i.start;
	}
	
	public static class Interval implements Comparable<Interval> {
		public final int start;
		public final int end;
		public boolean conflict = false;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Interval i) {
			return this.start - i.start;
		}
	}
}
