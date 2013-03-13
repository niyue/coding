package com.niyue.coding.leetcode.findmissingpositive;

// http://leetcode.com/onlinejudge#question_41
// use existing array space, 1) mark all non relevant numbers as zero up front 
// 2) mark all positions appeared as negative (use the minus sign as the marker) 
// 3) check if there is minus sign for each position, the first position without minus sign is the answer
public class Solution {
    public int firstMissingPositive(int[] A) {
        markNotInRangeNumbers(A);

    	for(int i = 0; i < A.length; i++) {
            if(A[i] != 0) {
                int number = Math.abs(A[i]);
                markAppearance(A, number);
            }
		}        
		return findMissingNumber(A);
    }

    private void markAppearance(int[] A, int number) {
        if(A[number - 1] == 0) {
            A[number - 1] = - 1 * number;
        } else {
            A[number - 1] = -1 * Math.abs(A[number - 1]);
        }
    }

    private void markNotInRangeNumbers(int[] A) {
        for(int i = 0; i < A.length; i++) {
            if(A[i] < 0 || A[i] > A.length) {
                A[i] = 0;
            }
        }      
    } 

    private int findMissingNumber(int[] A) {
        int i = 0;
    	for(; i < A.length; i++) {
    		if(A[i] >= 0) {
    			break;
    		}
		} 	
    	return i + 1;
    }
}
