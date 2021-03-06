package com.niyue.coding.misc.connectedcomponents;

/*
 * Given a matrix with 0 and 1, return the number of connected component  (four directions) with edge 1
 */
public class ConnectedComponents {
	private static final int VISITED = -1;
	private static final int ONE = 1;
	
	public int count(int[][] matrix) {
		int count = 0;
		for(int y = 0; y < matrix.length; y++) {
			for(int x = 0; x < matrix[y].length; x++) {
				if(matrix[y][x] == ONE) {
					visit(matrix, x, y);
					count++;
				}
			}
		}
		return count;
	}
	
	private void visit(int[][] matrix, int x, int y) {
		if(y >= 0 && y < matrix.length && x >= 0 && x < matrix[y].length) {
			if(matrix[y][x] == ONE) {
				matrix[y][x] = VISITED;
				visit(matrix, x - 1, y);
				visit(matrix, x + 1, y);
				visit(matrix, x, y - 1);
				visit(matrix, x, y + 1);
			}
		}
	}
	
}
