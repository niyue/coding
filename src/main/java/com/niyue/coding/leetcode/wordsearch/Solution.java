package com.niyue.coding.leetcode.wordsearch;


// http://leetcode.com/onlinejudge#question_79
// time complexity: O(M * N * 4^L) where M, N is the size of the board and L is the length of the word
public class Solution {
	private boolean[][] visited;
	
    public boolean exist(char[][] board, String word) {
        boolean exist = false;
        char[] chars = word.toCharArray();
        visited = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
        		exist = dfs(board, i, j, chars, 0);
        		if(exist) {
        			return exist;
        		}
            }
        }

        return exist;
    }

    private boolean dfs(char[][] board, int x, int y, char[] chars, int index) {
        boolean exist = board[x][y] == chars[index] && !visited[x][y];
        if(exist && index < chars.length - 1) {
        	visited[x][y] = true;
            exist = x > 0 && dfs(board, x - 1, y, chars, index + 1) || 
                    y > 0 && dfs(board, x, y - 1, chars, index + 1) ||
                    x < board.length - 1 && dfs(board, x + 1, y, chars, index + 1) ||
                    y < board[0].length - 1 && dfs(board, x, y + 1, chars, index + 1);
            visited[x][y] = false;
        }
        return exist;
    }
}
