package com.niyue.coding.leetcode.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// http://leetcode.com/onlinejudge#question_56
// sort the interval array and for each interval, merge joint interval into larger one
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        List<ComparableInterval> comparableIntervals = new ArrayList<ComparableInterval>();
        for(Interval interval : intervals) {
            comparableIntervals.add(new ComparableInterval(interval));
        }
        
        Collections.sort(comparableIntervals);
        ArrayList<Interval> sortedIntervals = new ArrayList<Interval>();
        for(ComparableInterval ci : comparableIntervals) {
            sortedIntervals.add(ci.interval);    
        }
        
    	ArrayList<Interval> mergedIntervals = new ArrayList<Interval>();
		
		if(sortedIntervals.size() > 0) {
			Interval current = sortedIntervals.get(0);
			for(int i=0;i<sortedIntervals.size();i++) {
				if(isLastInterval(i, sortedIntervals.size())) {
					mergedIntervals.add(current);
				} else {
					Interval next = sortedIntervals.get(i+1);
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
    
    public static class ComparableInterval implements Comparable<ComparableInterval> {
    	public Interval interval;
		
		public ComparableInterval(Interval interval) {
			this.interval = interval;
		}

		@Override
		public int compareTo(ComparableInterval ci) {
			return this.interval.start - ci.interval.start;
		}
    }
    
    public class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
    }
}
