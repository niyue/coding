package com.niyue.coding.leetcode.jumpgame;

// http://leetcode.com/onlinejudge#question_55
// greedy strategy, always jump to the position with maximum (i + A[i]) for all positions that can jump right now
public class Solution {
    public boolean canJump(int[] A) {
        boolean reachable = false;
		for(int i = 0; i < A.length;) {
            if(i + A[i] >= A.length - 1) {
                reachable = true;
                break;
            } else if(A[i] == 0) {
            	break;
            } else {
                i = nextPosition(A, i);    
            }
		}      
        return reachable;
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
