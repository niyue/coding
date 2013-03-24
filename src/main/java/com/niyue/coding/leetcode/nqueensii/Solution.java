package com.niyue.coding.leetcode.nqueensii;


// http://leetcode.com/onlinejudge#question_52
// a direct variant from n queens problem, too slow to pass the large data set (count solutions for 12 queens)
public class Solution {
    private int count;
    private int N;
    public int totalNQueens(int n) {
        count = 0;
        N = n;
        placeQueen(0, 0, new int[n]);
        return count;
    }
    
    private void placeQueen(int row, int col, int[] queens) {
        if(row < N && col < N) {
            if(isPlaceable(row, col, queens)) {
            	queens[row] = col;
                if(row == N - 1) {
                    count++;
                } else {
                    placeQueen(row + 1, 0, queens);
                }
            }
            placeQueen(row, col + 1, queens);
        }
    }

    private boolean isPlaceable(int row, int col, int[] queens) {
        boolean isPlaceable = true;
        for(int i = 0; i < row; i++) {
        	if(col == queens[i] || row + col == i + queens[i] || row - col == i - queens[i]) {
                isPlaceable = false;
                break;
            }
        }
        return isPlaceable;
    }
}
