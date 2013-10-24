package com.niyue.coding.leetcode.uniquebst;

/*
 * http://oj.leetcode.com/problems/unique-binary-search-trees/
 * DP O(n^2) solution
 */
public class SolutionTwo {
    public int numTrees(int n) {
        int[] counts = new int[n + 1];        
        counts[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int r = 0; r < i; r++) {
                counts[i] += counts[r] * counts[i - r - 1];
            }
        }
        return counts[n];
    }
}
