package com.niyue.coding.leetcode.minimumpathsum;

/*
 * http://oj.leetcode.com/problems/minimum-path-sum/
 */
public class SolutionTwo {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[m - 1][n - 1] = grid[m - 1][n - 1];
        for(int y = m - 1; y >= 0; y--) {
            for(int x = n - 1; x >= 0; x--) {
                if(x < n - 1 || y < m - 1) {
                    int xSum = x < n - 1 ? sum[y][x + 1] + grid[y][x] : Integer.MAX_VALUE;
                    int ySum = y < m - 1 ? sum[y + 1][x] + grid[y][x] : Integer.MAX_VALUE;
                    sum[y][x] = Math.min(xSum, ySum);    
                }
            }
        }
        return sum[0][0];
    }
}
