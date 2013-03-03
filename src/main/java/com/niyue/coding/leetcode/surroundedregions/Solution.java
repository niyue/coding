package com.niyue.coding.leetcode.surroundedregions;

// http://leetcode.com/onlinejudge#question_130
// O(n^2) time and O(n^2) space complexity solution. flood fill to detect if a region is surrounded
// this solution needs to traverse the board twice and is too slow to pass large data set in leetcode online judge
public class Solution {
	private boolean[][] visited;
	private boolean[][] surrounded;
	private char[][] board;
	private int height;
	private int width;

    public void solve(char[][] inputBoard) {
    	board = inputBoard;
    	if(inputBoard.length > 1 && inputBoard[0].length > 1) {
    		visited = new boolean[board.length][board[0].length];
	    	width = board.length;
	    	height = board[0].length;
	    	surrounded = new boolean[board.length][board[0].length];
	    	
	    	for(int i = 0; i < board.length; i++) {
	    		for(int j = 0; j < board[i].length; j++) {
	    			if(isO(i, j) && isUnvisited(i, j)) {
	    				if(isSurrounded(i, j)) {
	    					surrounded[i][j] = true;
	    				}	
	    			}
	    		}
	    	}

	    	for(int i = 0; i < board.length; i++) {
	    		for(int j = 0; j < board[i].length; j++) {
	    			if(surrounded[i][j]) {
	    				flip(i, j);
	    			}
	    		}
	    	}
    	}
    }

    private boolean isSurrounded(int i, int j) {
    	boolean isSurrounded = true;
    	visit(i, j);
    	if(isBorder(i, j)) {
    		isSurrounded = false;
    	} else {
    		isSurrounded = 	
    			(isX(i + 1, j) || isSurrounded(i + 1, j)) &&
    			(isX(i, j + 1) || isSurrounded(i, j + 1));
    	}
    	return isSurrounded;
    }

    private void flip(int i, int j) {
    	board[i][j] = 'X';
    	if(isO(i + 1, j)) {
    		flip(i + 1, j);
    	}
    	if(isO(i, j + 1)) {
    		flip(i, j + 1);
    	}
    }
	
	private boolean isBorder(int i, int j) {
    	return i == 0 || j == 0 || i == width - 1 || j == height - 1;
    }

    private boolean isO(int i, int j) {
    	return board[i][j] == 'O';
    }

    private boolean isX(int i, int j) {
    	return board[i][j] == 'X';
    }

    private boolean isUnvisited(int i, int j) {
    	return !visited[i][j];
    }

    private void visit(int i, int j) {
    	visited[i][j] = true;
    }
}
