package com.niyue.coding.leetcode.nqueens;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

// http://leetcode.com/onlinejudge#question_51
public class Solution {
    private ArrayList<String[]> solutions;
    public ArrayList<String[]> solveNQueens(int n) {
        solutions = new ArrayList<String[]>();
        boolean[][] board = new boolean[n][n];
        placeQueen(0, 0, board, new LinkedList<int[]>());
        return solutions;
    }

    private void placeQueen(int row, int col, boolean[][] board, Deque<int[]> queens) {
    	if(row < board.length && col < board.length) {
    		if(isPlaceable(row, col, queens)) {
    			board[row][col] = true;
    			queens.addFirst(new int[] {row, col});
    			if(row == board.length - 1) {
    				solutions.add(saveBoard(board));
    			} else {
    				placeQueen(row + 1, 0, board, queens);
    			}
    			board[row][col] = false;
    			queens.removeFirst();
    		}
			placeQueen(row, col + 1, board, queens);
    	}
    }

    private boolean isPlaceable(int row, int col, Deque<int[]> queens) {
        boolean isPlaceable = true;
        for(int[] queen : queens) {
            if(col == queen[1] || 
                row - col == queen[0] - queen[1] || 
                row + col == queen[0] + queen[1]) {
                isPlaceable = false;
                break;
            }
        }
        return isPlaceable;
    }

    private String[] saveBoard(boolean[][] board) {
        String[] result = new String[board.length];
        for(int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for(int j = 0; j < board[i].length; j++) {
                String queenOrDot = board[i][j] ? "Q" : ".";
                row.append(queenOrDot);
            }
            result[i] = row.toString();
        }
        return result;
    }
}
