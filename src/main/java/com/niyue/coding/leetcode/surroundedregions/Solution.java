package com.niyue.coding.leetcode.surroundedregions;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

// http://leetcode.com/onlinejudge#question_130
// O(n^2) time and O(n^2) space complexity solution. flood fill to detect if a region is surrounded
// this solution needs to traverse the board only once
public class Solution {
	private boolean[][] visited;
	private char[][] board;
	private int height;
	private int width;

    public void solve(char[][] inputBoard) {
    	board = inputBoard;
    	if(inputBoard.length > 1 && inputBoard[0].length > 1) {
    		visited = new boolean[board.length][board[0].length];
	    	width = board.length;
	    	height = board[0].length;
	    	
	    	for(int x = 0; x < board.length; x++) {
	    		for(int y = 0; y < board[x].length; y++) {
	    			if(isO(x, y) && isUnvisited(x, y)) {
	    				Collection<Cell> surroundedCells = surroundedCells(x, y);
	    				for(Cell cell : surroundedCells) {
	    					flip(cell);
	    				}
	    			}
	    		}
	    	}
    	}
    }

    private Collection<Cell> surroundedCells(int x, int y) {
    	Collection<Cell> surroundedCells = new LinkedList<Cell>();
    	surroundedCells.add(new Cell(x, y));
    	visit(x, y);
    	if(isBorder(x, y)) {
    		surroundedCells = Collections.emptyList();
    	}
		else {
			if(isO(x + 1, y)) {
				surroundedCells = addSurroundedCells(x + 1, y, surroundedCells);
			}
			if(!surroundedCells.isEmpty() && isO(x, y + 1)) {
				surroundedCells = addSurroundedCells(x, y + 1, surroundedCells);
			}
		}
    	return surroundedCells;
    }

    private Collection<Cell> addSurroundedCells(int x, int y, Collection<Cell> surroundedCells) {
    	Collection<Cell> rightSurroundedCells = surroundedCells(x, y);
		if(rightSurroundedCells.isEmpty()) {
			surroundedCells = Collections.emptyList();
		} else {
			surroundedCells.addAll(rightSurroundedCells);
		}
		return surroundedCells;
    }
    private void flip(Cell c) {
    	board[c.x][c.y] = 'X';
    }
	
	private boolean isBorder(int x, int y) {
    	return x == 0 || y == 0 || x == width - 1 || y == height - 1;
    }

    private boolean isO(int x, int y) {
    	return board[x][y] == 'O';
    }

    private boolean isUnvisited(int x, int y) {
    	return !visited[x][y];
    }

    private void visit(int x, int y) {
    	visited[x][y] = true;
    }
    
    private static class Cell {
    	public int x;
    	public int y;
    	public Cell(int x, int y) {
    		this.x = x; 
    		this.y = y;
    	}
    	
    	public boolean equals(Object c) {
    		if(c == null) {
    			return false;
    		}
    		if(!(c instanceof Cell)) {
    			return false;
    		}
    		Cell that = (Cell) c;
    		return this.x == that.x && this.y == that.y;
    	}
    	
    	public int hashCode() {
    		return String.format("%s,%s", x, y).hashCode();
    	}
    }
}
