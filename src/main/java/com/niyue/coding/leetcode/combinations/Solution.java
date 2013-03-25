package com.niyue.coding.leetcode.combinations;

import java.util.ArrayList;

// http://leetcode.com/onlinejudge#question_77
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        return combine(1, n, k);
    }

    private ArrayList<ArrayList<Integer>> combine(int start, int end, int k) {
    	ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
    	if(end - start + 1 >= k) {
    		if(k == 1) {
    			for(int i = start; i <= end; i++) {
    				ArrayList<Integer> combination = new ArrayList<Integer>();
    				combination.add(i);
    				combinations.add(combination);	
    			}
    		} else {
	    		ArrayList<ArrayList<Integer>> subCombinationsWithStart = combine(start + 1, end, k - 1);
				for(ArrayList<Integer> subCombinationWithStart : subCombinationsWithStart) {
					subCombinationWithStart.add(0, start);
				}
		    	ArrayList<ArrayList<Integer>> subCombinationsWithoutStart = combine(start + 1, end, k);
		    	combinations.addAll(subCombinationsWithStart);
		    	combinations.addAll(subCombinationsWithoutStart);	
    		}
    	}
    	return combinations;
    }
}
