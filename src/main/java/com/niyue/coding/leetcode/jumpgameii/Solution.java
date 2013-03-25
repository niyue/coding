package com.niyue.coding.leetcode.jumpgameii;

// http://leetcode.com/onlinejudge#question_45
public class Solution {
    public int jump(int[] A) {
        int jump = 0;
		for(int i = 0; i < A.length - 1;) {
            if(i + A[i] >= A.length - 1) {
            	jump++;
                break;
            } else if(A[i] == 0) {
            	jump = -1;
            	break;
            } else {
                i = nextPosition(A, i);    
                jump++;
            }
		}      
        return jump;
    }

    private int nextPosition(int[] A, int current) {
    	int maxPosition = current + 1;
    	for(int i = current + 2; i <= current + A[current] && i < A.length; i++) {
    		if(i + A[i] > maxPosition + A[maxPosition]) {
    			maxPosition = i;
    		}
    	}
    	return maxPosition;
    }
}
