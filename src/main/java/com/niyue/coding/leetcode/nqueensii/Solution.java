package com.niyue.coding.leetcode.nqueensii;


// http://leetcode.com/onlinejudge#question_52
// use int array to replace Deque to make the program run 30% faster to pass the large date set (count 12 queens)
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
        int leftDiagnoal = row + col;
        int rightDiagnoal = row - col;
        for(int i = 0; i < row; i++) {
        	if(col == queens[i] || leftDiagnoal == i + queens[i] || rightDiagnoal == i - queens[i]) {
                isPlaceable = false;
                break;
            }
        }
        return isPlaceable;
    }
}
