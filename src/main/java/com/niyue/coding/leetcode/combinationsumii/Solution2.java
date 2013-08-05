package com.niyue.coding.leetcode.combinationsumii;

import java.util.ArrayList;
import java.util.Arrays;

// Another partial solution implemented with DP, but cannot handle duplicated number in the array
public class Solution2 {
	private ArrayList<ArrayList<Integer>>[][] sums;
    @SuppressWarnings("unchecked")
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	sums = new ArrayList[num.length][target + 1];
    	Arrays.sort(num);
    	sums[0][0] = new ArrayList<ArrayList<Integer>>();
    	if(num[0] <= target) {
    		sums[0][num[0]] = new ArrayList<ArrayList<Integer>>();
    		sums[0][num[0]].add(new ArrayList<Integer>(Arrays.asList(num[0])));
    	}
    	for(int i = 1; i < num.length; i++) {
    		for(int t = 1; t <= target; t++) {
    			getSum(num, i, t);
    		}
    	}
    	return sums[num.length - 1][target] == null 
    			? new ArrayList<ArrayList<Integer>>() 
    			: sums[num.length - 1][target];
    }

    private void getSum(int[] num, int i, int target) {
    	if(target > 0) {
    		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    		if(sums[i - 1][target] != null) {
    			result.addAll(sums[i - 1][target]);
    		}
    		if(i == 1 && target == num[i]) {
    			ArrayList<Integer> nextSum = new ArrayList<Integer>();
				nextSum.add(num[i]);
				result.add(nextSum);
    		} else if(target - num[i] >= 0 && sums[i - 1][target - num[i]] != null) {
    			for(ArrayList<Integer> sum : sums[i - 1][target - num[i]]) {
    				ArrayList<Integer> nextSum = new ArrayList<Integer>(sum);
    				nextSum.add(num[i]);
    				result.add(nextSum);
    			}
    		}
    		sums[i][target] = result;
    	}
    }
}
