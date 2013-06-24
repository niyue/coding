package com.niyue.coding.leetcode.sudokusolver;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

// http://leetcode.com/onlinejudge#question_37
// Solve a sukodu puzzle using back tracking
// use a heap to order the cell to be filled according to the possible numbers allowed in a cell initially
// try each number allowed in a cell and verifies the result, if the number can be used, move on to next cell, otherwise, restore the board to previous status and backtrack
// This version is too slow to pass even the small data set in leetcode, two tests can pass in my machine with 200ms but it is considered too slow in leetcode online judge
public class Solution {

    public void solveSudoku(char[][] board) {
        Cell[][] grids = new Cell[board.length][];
        Queue<Cell> fillingOrder = cellQueue(board, grids);
        Deque<Cell> stack = new ArrayDeque<Cell>(fillingOrder);
        Deque<Cell> solution = new ArrayDeque<Cell>(stack.size());
        while(!stack.isEmpty()) {
            Cell c = stack.peekFirst();
            int nextAllow = c.nextAllow();
            if(nextAllow == 10) {
                if(!solution.isEmpty()) {
                    // no solution can be found, backtrack
                    Cell prev = solution.removeFirst(); 
  
                    for(Cell uc : prev.lastUpdatedCells) {
                        uc.allow(prev.value);
                    }
                    prev.reset();
                    c.clearLastTry();
                    stack.addFirst(prev);
                } else {
                    // no solution can be found for this layout
                    break;
                }
            } else {
                c = stack.removeFirst();
                c.value = nextAllow;
                c.step = solution.size();
                solution.addFirst(c);

                updateDisallows(grids, c);
            }        
        }

        for(Cell c : solution) {
            board[c.x][c.y] = (char) (c.value + '0');
        }
    }
    
    private Queue<Cell> cellQueue(char[][] board, Cell[][] grids) {
    	Queue<Cell> queue = new PriorityQueue<Cell>(81, new CellComparator());
        for(int i = 0; i < board.length; i++) {
            grids[i] = new Cell[board[i].length];
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.') {
                    grids[i][j] = new Cell(i, j);
                } else {
                    grids[i][j] = new Cell(i, j, board[i][j] - '0');   
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(grids[i][j].needsFilling()) {
                    List<Cell> affectedCells = affectedCells(grids, i, j, true);
                    grids[i][j].disallow(affectedCells);
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(grids[i][j].needsFilling()) {
                    queue.offer(grids[i][j]);
                }
            }
        }
        return queue;
    }

    private List<Cell> affectedCells(Cell[][] grids, int i, int j, boolean includePredefined) {
        List<Cell> affectedCells = new ArrayList<Cell>(27);
        for(int x = 0; x < grids.length; x++) {
            if((includePredefined || grids[x][j].needsFilling()) && x != i) {
                affectedCells.add(grids[x][j]);
            }
        }
        
        for(int y = 0; y < grids[0].length; y++) {
            if((includePredefined || grids[i][y].needsFilling()) && y != j) {
                affectedCells.add(grids[i][y]);
            }
        }

        int xShift = i % 3;
        int yShift = j % 3;
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if(x != xShift && y != yShift) {
                    Cell c = grids[i + x - xShift][j + y - yShift];
                    if(includePredefined || c.needsFilling()) {
                        affectedCells.add(c);
                    }
                }
            }
        }
        return affectedCells;    
    }

    private void updateDisallows(Cell[][] grids, Cell c) {
        List<Cell> affectedCells = affectedCells(grids, c.x, c.y, false);

        for(Cell affectedCell : affectedCells) {
            affectedCell.disallow(c.value);
            c.lastUpdatedCells.add(affectedCell);
        }
    }

    private static class Cell {
        private static final Integer PREDEFINED = -1;
        public final int x;
        public final int y;
        public Integer value = null;
        public Integer step = null;
        public int lastTry = 0;
        public Set<Cell> lastUpdatedCells = new HashSet<Cell>();
        public int[] disallows = new int[11];
        public int disallowSize = 0;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Cell(int x, int y, int value) {
            this(x, y);
            this.value = value;
            this.step = PREDEFINED;
        }

        public boolean needsFilling() {
            return step != PREDEFINED;
        }

        public int nextAllow() {
            while(lastTry < 10) {
                lastTry++;
                if(disallows[lastTry] == 0) {
                    break;
                }
            }
            return lastTry;
        }
        
        public void clearLastTry() {
        	this.lastTry = 0;
        }

        public void disallow(int v) {
        	if(disallows[v] == 0) {
        		disallowSize++;
        	}
        	disallows[v]++;
        }

        public void disallow(List<Cell> affectedCells) {
            for(Cell ac : affectedCells) {
            	if(ac.value != null) {
            		this.disallow(ac.value);
            	}
            }
        }

        public void allow(int v) {
        	disallows[v]--;
        }

        public void reset() {
            this.step = null;
            this.value = null;
            this.lastUpdatedCells.clear();
        }

		@Override
		public String toString() {
			return "Cell [x=" + x + ", y=" + y + ", value=" + value
					+ ", lastTry=" + lastTry + ", disallows=" + disallows + "]";
		}
    }

    private static class CellComparator implements Comparator<Cell> {
       
        @Override
        public int compare(Cell c1, Cell c2) {
        	return c2.disallowSize - c1.disallowSize;
        }
    }
}
