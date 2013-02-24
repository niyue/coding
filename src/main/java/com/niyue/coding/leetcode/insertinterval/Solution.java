package com.niyue.coding.leetcode.insertinterval;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> mergedIntervals = new ArrayList<Interval>();
        int startPoint = binarySearch(intervals, newInterval.start, 0, intervals.size() - 1);
        int endPoint = binarySearch(intervals, newInterval.end, 0, intervals.size() - 1) + 1; // endpoint should use the bigger index hence +1
        
        for(int i = 0; i < startPoint; i++) {
            mergedIntervals.add(intervals.get(i));    
        }
        
        // process the first possible joint interval
        if(startPoint >= 0) {
        	Interval startInterval = intervals.get(startPoint); 
        	if(newInterval.start >= startInterval.start) {
        		if(isJoint(newInterval, startInterval)) {
        			newInterval = merge(startInterval, newInterval);
        		} else {
        			mergedIntervals.add(startInterval);
        			startPoint++;
        		}
        	}
        }
        
        // merge all possible joint intervals from start point to end point, these are all possible intervals that needs to be merged
        Interval mergedInterval = newInterval;
        int currentIntervalIndex = Math.max(0, startPoint);
        int lastIntervalIndex = Math.min(intervals.size() - 1, endPoint); 
        while(currentIntervalIndex <= lastIntervalIndex) {
        	Interval current = intervals.get(currentIntervalIndex);
        	if(isJoint(mergedInterval, current)) {
        		mergedInterval = merge(mergedInterval, current);
        	} else {
        		break;
        	}
        	currentIntervalIndex++;
        }
        
        mergedIntervals.add(mergedInterval);
        
        // add the remaining intervals that don't need to be merged
        while(currentIntervalIndex < intervals.size()) {
        	mergedIntervals.add(intervals.get(currentIntervalIndex));     
        	currentIntervalIndex++;
        }
        
        return mergedIntervals;
    }
    
    // find a position whose value is the greatest one that is less or equal to key
    private int binarySearch(ArrayList<Interval> intervals, int key, int start, int end) {
    	int position = start;
    	if(intervals.size() > start && intervals.get(start).start <= key) {
    		while(start <= end) {
    			int mid = start + (end - start) / 2;
    			int midStart = intervals.get(mid).start;
    			if(midStart < key) {
    				start = mid + 1;
    			} else {
    				end = mid - 1;
    			}
    		}
    		position = start;
    	}
        return position - 1;
    }
    
    private boolean isJoint(Interval v1, Interval v2) {
        return v1.start <= v2.start && v2.start <= v1.end || v2.start <= v1.start && v1.start <= v2.end;
    }
    
    private Interval merge(Interval v1, Interval v2) {
        return new Interval(Math.min(v1.start, v2.start), Math.max(v1.end, v2.end));    
    }
    
    public static final class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
	}
}
