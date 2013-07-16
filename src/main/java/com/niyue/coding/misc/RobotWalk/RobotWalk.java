package com.niyue.coding.misc.RobotWalk;

// http://www.mitbbs.com/article_t/JobHunting/32279127.html
// A robot walks from origin point, and it can move to either left or right one step each time, what is the possibility it will return to the origin point if it moves n steps? 
// Two solutions to the robot walk problem
// Bottom up DP O(n^2), and a recursive solution, which can be turned into top down DP easily
public class RobotWalk {
	public double calc(int n) {
		return possibility(n);
	}
	
	// assume current position is always 0
	private double possibility(int n) {
		double[][] possibility = new double[n + 1][n + 1];
		for(int p = 0; p <= n; p++) {
			possibility[0][p] = p == 0 ? 1 : 0;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int p = 0; p <= i; p++) {
				int leftPosition = Math.abs(p - 1);
				int rightPosition = p + 1;
				
				possibility[i][p] = 
						possibility[i - 1][leftPosition] * 0.5 + 
						(rightPosition > n ? 0 : possibility[i - 1][rightPosition]) * 0.5;
			}
		}
		return possibility[n][0];
	}
	
	
	// recursive solution
	@SuppressWarnings("unused")
	private double possibility(int n, int position) {
		if(position < 0) {
			return possibility(n, -1 * position);
		}
		if(n == 0) {
			return position == 0 ? 1 : 0;
		} else {
			return 
				possibility(n - 1, position - 1) * 0.5 +
				possibility(n - 1, position + 1) * 0.5;
		}
	}
}
