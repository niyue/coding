package com.niyue.coding.leetcode.jumpgameii;

// http://oj.leetcode.com/problems/jump-game-ii/
// 12 minutes
public class SolutionTwo {
    public int jump(int[] A) {
        int jump = 0;
        for(int i = 0; i < A.length - 1;) {
            jump++;
            int max = 0;
            for(int s = 1; s <= A[i]; s++) {
                int next = i + s;
                if(next >= A.length - 1) {
                    return jump;
                }
                if(next + A[next] > max + A[max]) { 
                    max = next;
                }
            }
            i = max;
        }
        return jump;
    }
}
