package com.niyue.coding.leetcode.twosum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * http://oj.leetcode.com/problems/two-sum/
 * The two sum problem description seems to allow duplicated number in the set
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] solution = null;
        Map<Integer, Set<Integer>> map = map(numbers);
        for(int i = 0; i < numbers.length; i++) {
            int num = target - numbers[i];
            if(map.containsKey(num)) {
                Set<Integer> indices = map.get(num);
                if(!indices.contains(i)) {
                    solution = newSolution(i, indices.iterator().next());
                    break;
                } else if(indices.contains(i) && indices.size() >= 2) {
                    Iterator<Integer> iter = indices.iterator();
                    solution = newSolution(iter.next(), iter.next());
                    break;
                }
            }
        }
        return solution;
    }
    
    private int[] newSolution(int i, int j) {
        return i > j ? new int[] {j + 1, i + 1} : new int[] {i + 1, j + 1};
    }
    
    private Map<Integer, Set<Integer>> map(int[] numbers) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < numbers.length; i++) {
            if(!map.containsKey(numbers[i])) {
                map.put(numbers[i], new HashSet<Integer>());
            }
            map.get(numbers[i]).add(i);
        }
        return map;
    }
}
