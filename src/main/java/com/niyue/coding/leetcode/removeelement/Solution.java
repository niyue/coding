package com.niyue.coding.leetcode.removeelement;

// http://leetcode.com/onlinejudge#question_27
// scan from two ends of the array, when encountering a target element in the front, swap it with one non target element found in the end
public class Solution {
    public int removeElement(int[] A, int elem) {
        int length = A.length;
        int end = A.length - 1;
        for(int i = 0; i <= end; i++) {
        	if(A[i] == elem) {
        		length--;
        		for(int j = end; j > i; j--, end = j) {
        			if(A[j] == elem) {
        				length--;
        			} else {
        				A[i] = A[j];
        				end = j - 1;
        				break;
        			}
        		}
        	}
        }
        return length;
    }
}
