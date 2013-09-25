package com.niyue.coding.leetcode.nqueens;

import java.util.ArrayList;

public class SolutionTwo {
    private boolean[][] board;
    private ArrayList<String[]> solutions;
    private int[] queens;
    
    public ArrayList<String[]> solveNQueens(int n) {
        board = new boolean[n][n];
        solutions = new ArrayList<String[]>();
        queens = new int[n];
        solve(0);
        return solutions;
    }
    
    private void solve(int row) {
        for(int i = 0; i < board[row].length; i++) {
            if(isPlaceable(row, i)) {
                board[row][i] = true;
                queens[row] = i;
                if(row == board.length - 1) {
                    solutions.add(toSolution(board));
                } else {
                    solve(row + 1);
                }
                queens[row] = -1;
                board[row][i] = false;
            }
        }   
    }
    
    private String[] toSolution(boolean[][] board) {
        String[] solution = new String[board.length];
        
        for(int i = 0; i < board.length; i++) {
            boolean[] row = board[i];
            StringBuilder s = new StringBuilder();
            for(boolean b : row) {
                s.append(b ? 'Q' : '.');
            }
            solution[i] = s.toString();
        }
        return solution;
    }
    
    // NOTE: how to determine if a queen is placeable? 
    // Instead of checking the board, we save all existing queens in an array and check against all queens
    private boolean isPlaceable(int row, int col) {
        boolean isPlaceable = true;
        for(int r = 0; r < row; r++) {
            int c = queens[r];
            if(col == c || 
                row - col == r - c || 
                row + col == r + c) {
                isPlaceable = false;
                break;
            }
        }
        return isPlaceable;
    }
}
