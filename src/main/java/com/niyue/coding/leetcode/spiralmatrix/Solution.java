package com.niyue.coding.leetcode.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

// http://leetcode.com/onlinejudge#question_54
// two loops, the first loop counts the number of levels of spirals, and the second loops counts the number of elements in each spiral
public class Solution {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> elements = new ArrayList<Integer>();
		if (matrix.length > 0) {
			int level = (Math.min(matrix.length, matrix[0].length) + 1) / 2;
			for (int i = 0; i < level; i++) {
				List<Integer> spiral = spiral(matrix, i);
				elements.addAll(spiral);
			}
		}
		return elements;
	}

	private List<Integer> spiral(int[][] matrix, int level) {
		int width = matrix[0].length;
		int height = matrix.length;
		int length = getSpiralLength(width, height, level);
		List<Integer> elements = new ArrayList<Integer>();
		int x = level;
		int y = level;
		for (int i = 0; i < length; i++) {
			elements.add(matrix[y][x]);
			if (y == level && x != width - 1 - level) {
				x++;
			} else if (x == width - 1 - level && y != height - 1 - level) {
				y++;
			} else if (y == height - 1 - level && x != level) {
				x--;
			} else {
				y--;
			}
		}
		return elements;
	}
	
	private int getSpiralLength(int width, int height, int level) {
		int currentLevelWidth = width - level * 2;
		int currentLevelHeight = height - level * 2;
		int length = 0;
		if(currentLevelHeight == 1) {
			length = currentLevelWidth;
		} else if(currentLevelWidth == 1) {
			length = currentLevelHeight;
		} else {
			length = currentLevelWidth * 2 + (currentLevelHeight - 2) * 2;
		}
		return length;
	}
}
