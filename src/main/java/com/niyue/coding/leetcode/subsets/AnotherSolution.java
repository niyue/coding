package com.niyue.coding.leetcode.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// a slightly different solution with the original one using back track
public class AnotherSolution {
	private ArrayList<ArrayList<Integer>> subsets;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	Arrays.sort(S);
    	subsets = new ArrayList<ArrayList<Integer>>();
    	visit(S, 0, new ArrayList<Integer>());
    	return subsets;
    }

    private void visit(int[] S, int start, List<Integer> elements) {
    	if(start == S.length) {
    		subsets.add(new ArrayList<Integer>(elements));
    	} else {
    		visit(S, start + 1, elements);
    		elements.add(S[start]);
    		visit(S, start + 1, elements);
    		elements.remove(elements.size() - 1);
    	}
    }
}
