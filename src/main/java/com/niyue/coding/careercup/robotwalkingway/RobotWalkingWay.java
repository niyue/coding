package com.niyue.coding.careercup.robotwalkingway;

// http://www.careercup.com/question?id=3194705
// http://www.careercup.com/question?id=3544061
// http://www.careercup.com/question?id=4539687
// DP solution, O(mxn)
// the answer is expected to be C(m-1+n-1, m-1) 
public class RobotWalkingWay {
	public int numberOfWays(int m, int n) {
		int[][] ways = new int[m][n];
		for(int i = 0; i < m; i++) {
			ways[i][n - 1] = 1;
		}
		
		for(int i = 0; i < n; i++) {
			ways[m - 1][i] = 1;
		}
		
		for(int row = m - 2; row >= 0; row--) {
			for(int col = n - 2; col >= 0; col--) {
				ways[row][col] = ways[row + 1][col] + ways[row][col + 1];
			}
		}
		return ways[0][0];
	}
}
