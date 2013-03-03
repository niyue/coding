package com.niyue.coding.leetcode.surroundedregions;


// http://leetcode.com/onlinejudge#question_130
// O(n^2) time and O(1) space complexity solution. 
// flood fill from cells in border
public class Solution {
	private char[][] board;
	private int height;
	private int width;

    public void solve(char[][] inputBoard) {
    	board = inputBoard;
    	if(inputBoard.length > 1 && inputBoard[0].length > 1) {
    		width = board.length;
    		height = board[0].length;
	    	
    		for(int y = 0; y < height; y++) {
    			markUnsurrounded(0, y);
    		}
    		
    		for(int y = 0; y < height; y++) {
    			markUnsurrounded(width - 1, y);
    		}
    		
    		for(int x = 0; x < width; x++) {
    			markUnsurrounded(x, 0);
    		}
    		
    		for(int x = 0; x < width; x++) {
    			markUnsurrounded(x, height - 1);
    		}
    		
	    	for(int x = 0; x < board.length; x++) {
	    		for(int y = 0; y < board[x].length; y++) {
	    			if(isO(x, y)) {
	    				flip(x, y, 'X');
	    			} else if(isU(x, y)) {
	    				flip(x, y, 'O');
	    			}
	    		}
	    	}
    	}
    }
    
    private void markUnsurrounded(int x, int y) {
    	if(isO(x, y)) {
    		setUnsurrounded(x, y);
    		if(x + 1 < width) {
    			if(isO(x + 1, y)) {
    				markUnsurrounded(x + 1, y);
    			}
    		}
    		if(x - 1 >= 0) {
    			if(isO(x - 1, y)) {
    				markUnsurrounded(x - 1, y);
    			}
    		}
    		if(y + 1 < height) {
    			if(isO(x, y + 1)) {
    				markUnsurrounded(x, y + 1);
    			}
    		}
    		if(y - 1 >= 0) {
    			if(isO(x, y - 1)) {
    				markUnsurrounded(x, y - 1);
    			}
    		}
    	}
    }
    
    private void setUnsurrounded(int x, int y) {
    	board[x][y] = 'U';
    }

    private boolean isO(int x, int y) {
    	return board[x][y] == 'O';
    }
    
    private boolean isU(int x, int y) {
    	return board[x][y] == 'U';
    }
    
    private void flip(int x, int y, char c) {
    	board[x][y] = c;
    }
}
