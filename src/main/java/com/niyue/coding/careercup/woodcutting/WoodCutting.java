package com.niyue.coding.careercup.woodcutting;

import java.util.ArrayList;
import java.util.List;

// http://www.careercup.com/question?id=13467664
/*
 * A log of wood has n marks on it. 
 * Cost of cutting wood at a particular mark is proportional to the length of the log. 
 * The log of wood can be cut at all the marks. 
 * Find the optimal order of the marks where the log should be cut in order to minimize the total cost of cutting.
 * O(n^3) solution using DP.
 * Bottom up approach DP, for each cutting point i, calculate the cost (i, i + len)
 * Recurrence formula: 
 * base case: f(i, i + 2) = length of wood (cut from the middle point)
 * f(i, i + len) = max[f(i, i + k) + f(i + k, i + len) + wood length] (for each k from 1...len-1, k is considered as the cutting point)
 */
public class WoodCutting {
	public int cost(List<Integer> marks, int length) {
		List<Integer> extendedMarks = new ArrayList<Integer>(marks.size() + 2);
		extendedMarks.add(0);
		extendedMarks.addAll(marks);
		extendedMarks.add(length);
		int[][] costs = new int[extendedMarks.size() - 1][extendedMarks.size()];
		// int[][] solution = new int[extendedMarks.size() - 1][extendedMarks.size()];
		for(int i = 0; i < extendedMarks.size() - 2; i++) {
			costs[i][i + 2] = extendedMarks.get(i + 2) - extendedMarks.get(i);
			// solution[i][i + 2] = i + 1;
		}
		
		for(int len = 3; len < extendedMarks.size(); len++) {
			for(int i = 0; i < extendedMarks.size() - len; i++) {
				int minCost = Integer.MAX_VALUE;
				int woodLength = extendedMarks.get(i + len) - extendedMarks.get(i);
				for(int k = 1; k < len; k++) {
					int cost = costs[i][i + k] + costs[i + k][i + len] + woodLength;
					if(cost < minCost) {
						minCost = cost;
						// solution[i][i + len] = k;
					}
				}
				costs[i][i + len] = minCost;
			}
		}
		return costs[0][extendedMarks.size() - 1];
	}
}
