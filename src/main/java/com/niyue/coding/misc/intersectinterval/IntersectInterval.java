package com.niyue.coding.misc.intersectinterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.niyue.coding.careercup.disjointinterval.DisjointInterval.Interval;



// Given a set of intervals and a point, find out the interval that intersecting with the given point
// if there are multiple intervals intersecting with the given point, return any one
// 1) sort the intervals according to their ends
// 2) filter sorted intervals to remove nested intervals
// 3) do binary search for sorted intervals's end points for the given point, and find out the closest end, check if its start point if less than given point
public class IntersectInterval {
	public Interval search(List<Interval> intervals, int point) {
		Collections.sort(intervals, new IntervalComparator());
		removeNestedIntervals(intervals);
		return binarySearch(intervals, point);
	}
	
	private Interval binarySearch(List<Interval> intervals, int point) {
		int start = 0;
		int end = intervals.size() - 1;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			int endPoint = intervals.get(mid).end;
			if(point < endPoint) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		Interval closestEndInterval = start == intervals.size() ? null : intervals.get(start);
		if(closestEndInterval != null && closestEndInterval.start >= point) {
			closestEndInterval = null;
		}
		return closestEndInterval;
	}
	
	private List<Interval> removeNestedIntervals(List<Interval> intervals) {
		Interval prev = null;
		Iterator<Interval> iter = intervals.iterator();
		List<Interval> nonNestedIntervals = new ArrayList<Interval>();
		while(iter.hasNext()) {
			Interval current = iter.next();
			if(prev != null) {
				if(current.start < prev.start || current.end > prev.end) {
					nonNestedIntervals.add(current);
				}
			}
			prev = current;
		}
		return intervals;
	}
	
	private static class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
		
	}
}
