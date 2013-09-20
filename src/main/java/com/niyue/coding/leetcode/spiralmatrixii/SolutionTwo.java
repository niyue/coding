package com.niyue.coding.leetcode.spiralmatrixii;

/*
 * http://oj.leetcode.com/problems/spiral-matrix-ii/
 * Key observation is we can use matrix[nextY][nextX] == 0 to determine if a cell is visited or not
 * If it is visited, we need to change the direction, otherwise, visit the cell by filling a new number and advance to next cell
 */
public class SolutionTwo {
    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int UP = 3;
    private static final int[] NEXT_DIRECTIONS = new int[] {DOWN, LEFT, UP, RIGHT}; 
    private static final int[][] NEXT_MOVE = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int direction = RIGHT;
        int x = -1;
        int y = 0;
        for(int i = 1; i <= n * n; ) {
        	int nextX = x + NEXT_MOVE[direction][0];
        	int nextY = y + NEXT_MOVE[direction][1];
        	
        	if(nextX < 0  || 
        	   nextX >= n ||
        	   nextY < 0  ||
        	   nextY >= n ||
        	   matrix[nextY][nextX] != 0) {
        		direction = NEXT_DIRECTIONS[direction];
        	} else {
        		x = nextX;
        		y = nextY;
        		matrix[y][x] = i;
        		i++;
        	}
        }
        return matrix;
    }
}
