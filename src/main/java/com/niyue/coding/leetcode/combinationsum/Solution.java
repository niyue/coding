package com.niyue.coding.leetcode.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;

// http://leetcode.com/onlinejudge#question_39
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, candidates.length - 1, target);
    }

    private ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int i, int target) {
        int n = target / candidates[i];
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(i == 0) {
            if(candidates[i] * n == target) {
                ArrayList<Integer> combinationSum = new ArrayList<Integer>();
                for(int j = 0; j < n; j++) {
                    combinationSum.add(candidates[i]);
                }
                result.add(combinationSum);
            }
        } else {
            for(int k = 0; k <= n; k++) {
                ArrayList<ArrayList<Integer>> subComabinations = combinationSum(candidates, i - 1, target - candidates[i] * k);
                for(ArrayList<Integer> subCombinationSum : subComabinations) {
                    ArrayList<Integer> combinationSum = new ArrayList<Integer>(subCombinationSum);
                    for(int j = 0; j < k; j++) {
                        combinationSum.add(candidates[i]);
                    }
                    result.add(combinationSum);
                }
            }
        }
        return result;
    }
}
