package com.niyue.coding.leetcode.trianglesum;

import java.util.ArrayList;
import java.util.List;

// http://leetcode.com/onlinejudge#question_120
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int lastRowIndex = triangle.size() - 1;
		List<Integer> lastRow = triangle.get(lastRowIndex);
		List<Integer> currentSums = new ArrayList<Integer>(lastRow);
		List<Integer> previousSums = new ArrayList<Integer>(lastRow);
		for (int row = lastRowIndex - 1; row >= 0; row--) {
			for (int column = 0; column < row + 1; column++) {
				int sum = Math.min(previousSums.get(column), previousSums.get(column + 1))
						+ triangle.get(row).get(column);
				currentSums.set(column, sum);
			}
			previousSums = currentSums;
		}
		return currentSums.get(0);
	}
}
