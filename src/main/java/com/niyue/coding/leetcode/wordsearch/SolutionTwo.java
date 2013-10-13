package com.niyue.coding.leetcode.wordsearch;

/*
 * http://oj.leetcode.com/problems/word-search/
 * O(M * N * 4^L)
 */
public class SolutionTwo {
    public boolean exist(char[][] board, String word) {
        if(board.length > 0) {
            boolean[][] visited = new boolean[board.length][board[0].length];    
            char[] chars = word.toCharArray();
            for(int y = 0; y < board.length; y++) {
                for(int x = 0; x < board[0].length; x++) {
                    boolean existed = isExisted(board, x, y, visited, chars, 0);
                    if(existed) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean isExisted(char[][] board, int x, int y, boolean[][] visited, char[] chars, int w) {
        boolean existed = false;
        if(w == chars.length) {
            existed = true;
        } else {
            if(y >= 0 && y < board.length && x >= 0 && x < board[0].length && !visited[y][x]) {
                if(board[y][x] == chars[w]) {
                    visited[y][x] = true;
                    existed = 
                        isExisted(board, x + 1, y, visited, chars, w + 1) ||
                        isExisted(board, x - 1, y, visited, chars, w + 1) ||
                        isExisted(board, x, y + 1, visited, chars, w + 1) ||
                        isExisted(board, x, y - 1, visited, chars, w + 1);
                    visited[y][x] = false;
                }
            }    
        }
        return existed;
    }
}
