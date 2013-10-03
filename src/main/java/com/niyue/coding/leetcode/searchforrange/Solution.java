package com.niyue.coding.leetcode.searchforrange;

/*
 * http://oj.leetcode.com/problems/search-for-a-range/
 * http://leetcode.com/onlinejudge#question_34
 * modified binary search with repeated elements in the sorted array
 * the searching for start of the range and end of the range is symmetric
 */
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = searchStart(A, target);
        int end = searchEnd(A, target);    
        return new int[] {start, end};
    }
    
    private int searchStart(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            // when A[mid] == target, keep searching the left side
            if(A[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start >= 0 && start < A.length && A[start] == target ? start : -1;
    }
    
    private int searchEnd(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            // when A[mid] == target, keep searching the right side
            if(A[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end >= 0 && end < A.length && A[end] == target ? end : -1;
    }
}
