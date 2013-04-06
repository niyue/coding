package com.niyue.coding.leetcode.wordsearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// http://leetcode.com/onlinejudge#question_79
public class Solution {
	private boolean[][] visited;
	
    public boolean exist(char[][] board, String word) {
        boolean exist = false;
        Map<Integer, Set<int[]>> positions = charPositions(board);
        char[] chars = word.toCharArray();
        visited = new boolean[board.length][board[0].length];
        Set<int[]> startingPoints = 
        		chars.length > 0 && positions.containsKey((int) chars[0]) 
        			? positions.get((int) chars[0]) 
        			: new HashSet<int[]>();
        for(int[] startingPoint : startingPoints) {
            exist = dfs(board, startingPoint[0], startingPoint[1], chars, 0);
            if(exist) {
                break;
            }
        }

        return exist;
    }

    private boolean dfs(char[][] board, int x, int y, char[] chars, int index) {
        boolean exist = isInBoard(board, x, y) && !visited[x][y] && board[x][y] == chars[index];
        if(exist && index < chars.length - 1) {
        	visited[x][y] = true;
            exist = dfs(board, x - 1, y, chars, index + 1) || 
                    dfs(board, x, y - 1, chars, index + 1) ||
                    dfs(board, x + 1, y, chars, index + 1) ||
                    dfs(board, x, y + 1, chars, index + 1);
            visited[x][y] = false;
        }
        return exist;
    }

    private boolean isInBoard(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >=0 && y < board[0].length;
    }

    private Map<Integer, Set<int[]>> charPositions(char[][] board) {
        Map<Integer, Set<int[]>> positions = new HashMap<Integer, Set<int[]>>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                int ch = board[i][j];
                if(!positions.containsKey(ch)) {
                    positions.put(ch, new HashSet<int[]>());
                }
                positions.get(ch).add(new int[] {i, j});
            }
        }
        return positions;
    }
}
