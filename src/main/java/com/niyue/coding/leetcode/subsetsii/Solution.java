package com.niyue.coding.leetcode.subsetsii;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


// http://leetcode.com/onlinejudge#question_90
// Given a collection of integers that might contain duplicates, S, return all possible subsets.
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Map<Integer, Integer> count = count(num);        
        return subset(count);
    }

	private Map<Integer, Integer> count(int[] num) {
		Map<Integer, Integer> count = new java.util.TreeMap<Integer, Integer>();
        for(int n : num) {
            if(!count.containsKey(n)) {
                count.put(n, 1);
            } else {
                count.put(n, count.get(n) + 1);
            }
        }
		return count;
	}

    private ArrayList<ArrayList<Integer>> subset(Map<Integer, Integer> count) {
        Set<Integer> numbers = count.keySet();
        ArrayList<ArrayList<Integer>> subSets = new ArrayList<ArrayList<Integer>>();
        if(!numbers.isEmpty()) {
            int n = numbers.iterator().next();
            int numberCount = count.remove(n);
            ArrayList<ArrayList<Integer>> subSubSets = subset(count);
            // add all subSubSets
            subSets.addAll(subSubSets);
            // add all subSubSets with current number
            for(int i = 1; i <= numberCount; i++) {
                for(ArrayList<Integer> subSubSet : subSubSets) {
                	ArrayList<Integer> subSet = new ArrayList<Integer>();
                    for(int j = 0; j < i; j++) {
                        subSet.add(n);
                    }
                    subSet.addAll(subSubSet);
                    subSets.add(subSet);
                }
            }
        } else {
        	subSets.add(new ArrayList<Integer>());
        }
        return subSets;
    }
}
