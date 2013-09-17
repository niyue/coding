package com.niyue.coding.leetcode.subsetsii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * http://oj.leetcode.com/problems/subsets-ii/
 * Implement subset problem once again for the new online judge.
 */
public class SolutionTwo {
    private ArrayList<ArrayList<Integer>> subsets;
    private Map<Integer, Integer> count;
    private List<Integer> numbers;
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        count = count(num);
        numbers = new ArrayList<Integer>(count.keySet());
        Collections.sort(numbers);
        subsets = new ArrayList<ArrayList<Integer>>();
        subsets(0, new ArrayList<Integer>());
        return subsets;
    }
    
    private void subsets(int i, ArrayList<Integer> subset) {
        if(i == numbers.size()) {
            subsets.add(new ArrayList<Integer>(subset));
        } else {
            int n = numbers.get(i);
            int nCount = count.get(n);
            for(int c = 0; c <= nCount; c++) {
                for(int k = 0; k < c; k++) {
                    subset.add(n);
                }
                subsets(i + 1, subset);
                for(int k = 0; k < c; k++) {
                    subset.remove(subset.size() - 1);
                }
            }
        }
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
}
