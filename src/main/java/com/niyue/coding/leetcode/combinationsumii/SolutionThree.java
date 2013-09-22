package com.niyue.coding.leetcode.combinationsumii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * http://oj.leetcode.com/problems/combination-sum-ii/
 */
public class SolutionThree {
    private ArrayList<ArrayList<Integer>> combinations;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Map<Integer, Integer> count = count(num);
        List<Integer> numbers = nonDuplicated(count.keySet());
        combinations = new ArrayList<ArrayList<Integer>>();
        combinate(numbers, 0, target, new ArrayList<Integer>(), count);
        return combinations;
    }
    
    private List<Integer> nonDuplicated(Set<Integer> num) {
        List<Integer> numbers = new ArrayList<Integer>(num);
        Collections.sort(numbers);
        return numbers;
    }
    
    private Map<Integer, Integer> count(int[] num) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int n : num) {
            if(count.containsKey(n)) {
                count.put(n, count.get(n) + 1);
            } else {
                count.put(n, 1);
            }
        }
        return count;
    }
    
    private void combinate(List<Integer> num, int i, int target, List<Integer> combination, Map<Integer, Integer> count) {
        if(target == 0) {
            combinations.add(new ArrayList<Integer>(combination));
        } else if(i < num.size()) {
            int number = num.get(i);
            int max = Math.min(target / number, count.get(number));
            for(int c = 0; c <= max; c++) {
                for(int j = 0; j < c; j++) {
                    combination.add(number);
                }
                combinate(num, i + 1, target - number * c, combination, count);
                for(int j = 0; j < c; j++) {
                    combination.remove(combination.size() - 1);
                }
            }
        }
    }
}
