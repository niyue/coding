package com.niyue.coding.leetcode.combinationsumii;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_40
// solve the problem similarly with combination sum problem
// the key observation here is we could count the total number of times for the input number array
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Map<Integer, Integer> count = numberCount(num);
        List<Integer> numbers = new ArrayList<Integer>(count.keySet());
        return combinationSum(numbers, numbers.size() - 1, target, count);
    }

    private ArrayList<ArrayList<Integer>> combinationSum(List<Integer> numbers, int i, int target, Map<Integer, Integer> count) {
        int n = target / numbers.get(i);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(i == 0) {
            if(numbers.get(i) * n == target && n <= count.get(numbers.get(i))) {
                ArrayList<Integer> combinationSum = new ArrayList<Integer>();
                for(int j = 0; j < n; j++) {
                    combinationSum.add(numbers.get(i));
                }
                result.add(combinationSum);
            }
        } else {
            int maxTimes = Math.min(n, count.get(numbers.get(i))); // the key difference with the 'combination sum I' problem
            for(int k = 0; k <= maxTimes; k++) {
                ArrayList<ArrayList<Integer>> subComabinations = combinationSum(numbers, i - 1, target - numbers.get(i) * k, count);
                for(ArrayList<Integer> subCombinationSum : subComabinations) {
                    ArrayList<Integer> combinationSum = new ArrayList<Integer>(subCombinationSum);
                    for(int j = 0; j < k; j++) {
                        combinationSum.add(numbers.get(i));
                    }
                    result.add(combinationSum);
                }
            }
        }
        return result;
    }

    private Map<Integer, Integer> numberCount(int[] num) {
        Map<Integer, Integer> count = new java.util.TreeMap<Integer, Integer>();
        for(int n : num) {
            if(!count.containsKey(n)) {
                count.put(n, 0);
            }
            count.put(n, count.get(n) + 1);
        }
        return count;
    }
}
