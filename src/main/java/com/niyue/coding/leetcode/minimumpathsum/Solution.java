package com.niyue.coding.leetcode.minimumpathsum;

// http://leetcode.com/onlinejudge#question_64
public class Solution {
    public int minPathSum(int[][] grid) {
        int W = grid[0].length - 1;
        int H = grid.length - 1;

        int[][] sum = new int[H + 1][W + 1];        
        sum[H][W] = grid[H][W];

        for(int x = W - 1; x >= 0; x--) {
            sum[H][x] = sum[H][x + 1] + grid[H][x];
        }

        for(int y = H - 1; y >= 0; y--) {
            sum[y][W] = sum[y + 1][W] + grid[y][W];
        }

        for(int y = H - 1; y >= 0; y--) {
            for(int x = W - 1; x >= 0; x--) {
                sum[y][x] = Math.min(sum[y + 1][x], sum[y][x + 1]) + grid[y][x];
            }
        }
        return sum[0][0];
    }
}
