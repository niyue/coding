package com.niyue.coding.leetcode.removeduplicate;

// http://leetcode.com/onlinejudge#question_26
// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
public class Solution {
    public int removeDuplicates(int[] A) {
        int s = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] != A[s]) {
				s++;
				A[s] = A[i];
			}
		}
		return A.length == 0 ? 0 : s + 1;
    }
}
