package com.niyue.coding.leetcode.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// http://oj.leetcode.com/problems/combination-sum/
public class SolutionTwo {
    private ArrayList<ArrayList<Integer>> sums;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        sums = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);        
        generate(candidates, target, 0, new ArrayList<Integer>());
        return sums;
    }
    
    private void generate(int[] candidates, int target, int i, List<Integer> sum) {
        if(target == 0) {
            sums.add(new ArrayList<Integer>(sum));
        } else if(target > 0 && i < candidates.length) {
            for(int x = 0; x <= target / candidates[i]; x++) {
            	// NOTE: add the same copy of elements multiple times in one line
            	sum.addAll(Collections.nCopies(x, candidates[i]));
                generate(candidates, target - candidates[i] * x, i + 1, sum);
                // NOTE: remove the last x elements from a list in one line
                sum.subList(sum.size() - x, sum.size()).clear();
            }
        }
    }
}
