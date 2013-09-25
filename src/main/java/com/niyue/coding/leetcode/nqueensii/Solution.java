package com.niyue.coding.leetcode.nqueensii;


// http://leetcode.com/onlinejudge#question_52
// use int array to replace Deque to make the program run 30% faster to pass the large date set (count 12 queens)
// use loop instead of recursion to iterate columns to make the program 20% faster
public class Solution {
    private int count;
    private int N;
    public int totalNQueens(int n) {
        count = 0;
        N = n;
        placeQueen(0, new int[n]);
        return count;
    }
    
    private void placeQueen(int row, int[] queens) {
    	for(int col = 0; col < N; col++) {
    		if(isPlaceable(row, col, queens)) {
    			queens[row] = col;
    			if(row == N - 1) {
    				count++;
    			} else {
    				placeQueen(row + 1, queens);
    			}
    		}
    	}
    }

    private boolean isPlaceable(int row, int col, int[] queens) {
        boolean isPlaceable = true;
        int leftDiagnoal = row + col;
        int rightDiagnoal = row - col;
        for(int r = 0; r < row; r++) {
        	int c = queens[r];
        	if(col == c || leftDiagnoal == r + c || rightDiagnoal == r - c) {
                isPlaceable = false;
                break;
            }
        }
        return isPlaceable;
    }
}
