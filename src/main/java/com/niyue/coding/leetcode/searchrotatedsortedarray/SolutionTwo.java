package com.niyue.coding.leetcode.searchrotatedsortedarray;

/*
 * http://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SolutionTwo {
    public int search(int[] A, int target) {
        return search(A, 0, A.length - 1, target);
    }
    
    private int search(int[] A, int start, int end, int target) {
    	int index = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;    
            if(A[mid] == target) {
                index = mid;
                break;
            } else {
            	if(A[mid] > A[0] && target > A[mid]) {
        			start = mid + 1;
                } else if(A[mid] < A[0] && target < A[mid]) {
                	end = mid - 1;
                } else {
                	index = search(A, start, mid - 1, target);
                	if(index == -1) {
                		index = search(A, mid + 1, end, target);
                	}
                	break;
                }
            }
        }
        return index;
    }
}
