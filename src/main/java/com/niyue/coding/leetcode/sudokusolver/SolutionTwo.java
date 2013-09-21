package com.niyue.coding.leetcode.sudokusolver;

/*
 *  http://oj.leetcode.com/problems/sudoku-solver/
 *  Brute force solution
 */
public class SolutionTwo {
    private static final int N = 9;
    private boolean solved = false;
    public void solveSudoku(char[][] board) {
    	solved = false;
        solve(board, 0, 0);
    }
    
    private void solve(char[][] board, int y, int x) {
    	if(y == N && x == 0) {
            solved = true;
            return;
        } 
        if(board[y][x] == '.') {
            for(int i = 1; i <= N; i++) {
                char c = (char) ('0' + i);
                if(isPlaceable(board, y, x, c)) {
                    board[y][x] = c;
                    solve(board, nextY(y, x), nextX(y, x));
                    if(solved) {
                        return;
                    } else {
                        board[y][x] = '.';
                    }
                }
            }
        } else {
            solve(board, nextY(y, x), nextX(y, x));
        }
    }
    
    private int nextY(int y, int x) {
        return x == N - 1 ? y + 1 : y;
    }
    
    private int nextX(int y, int x) {
        return x == N - 1 ? 0 : x + 1;
    }
    
    private boolean isPlaceable(char[][] board, int y, int x, char i) {
        return checkRow(board, y, i) && checkColumn(board, x, i) && checkSubMatrix(board, y, x, i);     
    }
    
    private boolean checkRow(char[][] board, int y, char i) {
        for(int x = 0; x < N; x++) {
            if(board[y][x] == i) {
                return false;                
            }
        }
        return true;
    }
    
    private boolean checkColumn(char[][] board, int x, char i) {
        for(int y = 0; y < N; y++) {
            if(board[y][x] == i) {
                return false;                
            }
        }
        return true;
    }
    
    private boolean checkSubMatrix(char[][] board, int y, int x, char c) {
        int oy = y / 3 * 3;
        int ox = x / 3 * 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[oy + i][ox + j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
