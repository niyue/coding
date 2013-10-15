package com.niyue.coding.leetcode.insertinterval;

import java.util.ArrayList;

/*
 * http://oj.leetcode.com/problems/insert-interval/
 * An straight forward O(n) solution:
 * 1) add all non joint intervals before the new interval
 * 2) merge all following intervals until the first disjoint interval is found, which means the remaining all intervals are all disjoint intervals
 * 3) add all remaining intervals from the first disjoint interval
 */
public class SolutionTwo {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals.size() > 0) {
        	int i = 0;
            for(;i < intervals.size(); i++) {
            	Interval current = intervals.get(i);
            	if(current.start < newInterval.start && !isJoint(current, newInterval)) {
            		result.add(current);
            	} else {
            		break;
            	}
            }
            
            Interval prev = newInterval;
            for(;i < intervals.size(); i++) {
            	Interval current = intervals.get(i);
        		if(isJoint(prev, current)) {
        			prev = merge(prev, current);
        		} else {
        			break;
        		}
            }
            result.add(prev);
            
        	for(; i < intervals.size(); i++) {
        		result.add(intervals.get(i));
        	}
        } else {
        	result.add(newInterval);
        }
        
        return result;
    }
    
    private boolean isJoint(Interval i1, Interval i2) {
        return i1.start <= i2.start && i1.end >= i2.start || i2.start <= i1.start && i2.end >= i1.start;
    }
    
    private Interval merge(Interval i1, Interval i2) {
        return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
    }
    
    public static final class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
	}
}
