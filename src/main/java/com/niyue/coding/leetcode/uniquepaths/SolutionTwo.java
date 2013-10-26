package com.niyue.coding.leetcode.uniquepaths;

/*
 * http://oj.leetcode.com/problems/unique-paths/
 * O(mxn) time/space DP solution
 */
public class SolutionTwo {
    public int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];
        count[0][0] = 1;
        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                if(x > 0) {
                    count[y][x] += count[y][x - 1];
                }
                if(y > 0) {
                    count[y][x] += count[y - 1][x];
                }
            }
        }
        return count[m - 1][n - 1];
    }
}
