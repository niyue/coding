package com.niyue.coding.leetcode.uniquepaths;

//http://leetcode.com/onlinejudge#question_62
// O(n) linear space DP solution
public class LinearSpaceSolution {
    public int uniquePaths(int m, int n) {
    	int[] prev = new int[n];
        for(int i = 0; i < n; i++) {
        	prev[i] = 1;
        }
        int[] current = prev;

        for(int i = 1; i < m; i++) {
        	current[0] = 1;
            for(int j = 1; j < n; j++) {
            	current[j] = current[j - 1] + prev[j];
            }
        }
        return current[n - 1];        
    }
}
