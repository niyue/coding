package com.niyue.coding.leetcode.nqueensii;

import java.util.Deque;
import java.util.LinkedList;

// http://leetcode.com/onlinejudge#question_52
// a direct variant from n queens problem, too slow to pass the large data set (count solutions for 12 queens)
public class Solution {
    private int count;
    private int N;
    public int totalNQueens(int n) {
        count = 0;
        N = n;
        placeQueen(0, 0, new LinkedList<int[]>());
        return count;
    }
    
    private void placeQueen(int row, int col, Deque<int[]> queens) {
        if(row < N && col < N) {
            if(isPlaceable(row, col, queens)) {
                queens.addFirst(new int[] {row, col});
                if(row == N - 1) {
                    count++;
                } else {
                    placeQueen(row + 1, 0, queens);
                }
                queens.removeFirst();
            }
            placeQueen(row, col + 1, queens);
        }
    }

    private boolean isPlaceable(int row, int col, Deque<int[]> queens) {
        boolean isPlaceable = true;
        int diagnoalOne = row + col;
        int diagnoalTwo = row - col;
        for(int[] queen : queens) {
            if(col == queen[1] || diagnoalOne == queen[0] + queen[1] || diagnoalTwo == queen[0] - queen[1]) {
                isPlaceable = false;
                break;
            }
        }
        return isPlaceable;
    }
}
