package com.niyue.coding.leetcode.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// http://leetcode.com/onlinejudge#question_56
// sort the interval array and for each interval, merge joint interval into larger one
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        
    	ArrayList<Interval> mergedIntervals = new ArrayList<Interval>();
		
		if(intervals.size() > 0) {
			Interval current = intervals.get(0);
			for(int i=0;i<intervals.size();i++) {
				if(isLastInterval(i, intervals.size())) {
					mergedIntervals.add(current);
				} else {
					Interval next = intervals.get(i+1);
					if(isJoint(current, next)) {
						current = merge(current, next);
					} else {
						mergedIntervals.add(current);
						current = next;
					}
				}
			}
		}
		return mergedIntervals;
    }
    
    private boolean isLastInterval(int current, int length) {
    	return current == length - 1;
	}
	
	private Interval merge(Interval i1, Interval i2) {
		return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
	}
	
	private boolean isJoint(Interval i1, Interval i2) {
		return i1.end >= i2.start;
	}
    
    public static class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
    }
    
    public class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
    }
}
