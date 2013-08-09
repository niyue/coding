package com.niyue.coding.misc.matrixuniqueways;

/*
 * http://www.mitbbs.com/article_t/JobHunting/32173227.html
 * Given a 4x4 matrix, a person moves from top left corner to bottom right corner. 
 * If a cell is visited, it cannot be visited again.
 * How many unique ways there are for this?
 * O(4^N) solution using backtrack, where N is the size of the matrix
 */
public class MatrixUniqueWays {
	private int count;
	private int N;
	private boolean[][] visited;
	/*
	 * n is the size of the matrix
	 */
	public int count(int n) {
		count = 0;
		N = n;
		visited = new boolean[N][N];
		
		visit(0, 0);
		return count;
	}
	
	private void visit(int x, int y) {
		if(!visited[y][x]) {
			visited[y][x] = true;
			if(x == N - 1 && y == N - 1) {
				count++;
			} else {
				if(x > 0) {
					visit(x - 1, y);
				}
				if(y > 0) {
					visit(x, y - 1);
				}
				if(x < N - 1) {
					visit(x + 1, y);
				}
				if(y < N - 1) {
					visit(x, y + 1);
				}
			}
			visited[y][x] = false;
		}
	}
}
