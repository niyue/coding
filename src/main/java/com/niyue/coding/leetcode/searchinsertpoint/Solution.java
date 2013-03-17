package com.niyue.coding.leetcode.searchinsertpoint;

// http://leetcode.com/onlinejudge#question_35
// binary search implementation
public class Solution {
    public int searchInsert(int[] A, int target) {
		return binarySearch(A, 0, A.length - 1, target);        
    }

    private int binarySearch(int[] A, int start, int end, int target) {
    	while(start <= end) {
    		int mid = start + (end - start) / 2;
    		if(A[mid] == target) {
    			return mid;
    		} else if(A[mid] < target) {
    			start = mid + 1;
    		} else {
    			end = mid - 1;
    		}
    	}
    	return start;
    }
}
