package com.niyue.coding.leetcode.spiralmatrixii;

// http://leetcode.com/onlinejudge#question_59
public class Solution {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if (n > 0) {
			int level = (n + 1) / 2;
			int startNumber = 0;
			for (int i = 0; i < level; i++) {
				startNumber += fillSpiral(matrix, i, startNumber);
			}
		}
		return matrix;
	}

	private int fillSpiral(int[][] matrix, int level, int startNumber) {
		int width = matrix.length;
		int length = getSpiralLength(width, level);
		int x = level;
		int y = level;
		for (int i = 1; i <= length; i++) {
			matrix[y][x] = startNumber + i;
			if (y == level && x != width - 1 - level) {
				x++;
			} else if (x == width - 1 - level && y != width - 1 - level) {
				y++;
			} else if (y == width - 1 - level && x != level) {
				x--;
			} else {
				y--;
			}
		}
		return length;
	}

	private int getSpiralLength(int width, int level) {
		int currentLevelWidth = width - level * 2;
		return currentLevelWidth == 1 ? 1 : (currentLevelWidth - 1) * 4;
	}
}
