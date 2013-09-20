package com.niyue.coding.leetcode.distinctsubsequences;

/*
 * http://oj.leetcode.com/problems/distinct-subsequences/
 * A much simpler implementation using bottom up DP
 * DP recurrence formula:
 * f(s, t) = S[s] == T[t]
 * 				? f(s - 1, t - 1) + f(s - 1, t)
 *  			: f(s - 1, t)
 */
public class SolutionTwo {
    public int numDistinct(String S, String T) {
        int[][] count = new int[S.length() + 1][T.length() + 1];
        for(int t = 1; t <= T.length(); t++) {
            count[0][t] = 0;
        }
        
        for(int s = 0; s <= S.length(); s++) {
            count[s][0] = 1;
        }
        
        for(int s = 1; s <= S.length(); s++) {
            for(int t = 1; t <= T.length(); t++) {
                count[s][t] = S.charAt(s - 1) == T.charAt(t - 1)
                    ? count[s - 1][t - 1] + count[s - 1][t] 
                    : count[s - 1][t];
            }
        }        
        return count[S.length()][T.length()];   
    }
}
