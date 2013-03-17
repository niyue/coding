package com.niyue.coding.leetcode.searchforrange;

// http://leetcode.com/onlinejudge#question_34
// modified binary search with repeated elements in the sorted array
public class Solution {
    public int[] searchRange(int[] A, int target) {
       int start = binarySearchStart(A, 0, A.length - 1, target);
       int end = binarySearchEnd(A, 0, A.length - 1, target); 
       return new int[] {start, end};
    }

    private int binarySearchStart(int[] A, int start, int end, int target) {
        while(start < end) {
    		int mid = start + (end - start) / 2;
    		if(A[mid] < target) {
    			start = mid + 1;
    		} else {
    			end = mid;
    		}
    	}
    	return start == end && A[start] == target ? start : -1;
    }

    private int binarySearchEnd(int[] A, int start, int end, int target) {
    	while(start <= end) {
    		int mid = start + (end - start) / 2;
    		if(A[mid] <= target) {
    			start = mid + 1;
    		} else {
    			end = mid - 1;
    		}
    	}
    	return start - 1 >= 0 && A[start - 1] == target ? start - 1 : -1;
    }
}
