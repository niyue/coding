package com.niyue.coding.leetcode.subsetsii;

import java.util.ArrayList;


// http://leetcode.com/onlinejudge#question_90
// Given a collection of integers that might contain duplicates, S, return all possible subsets.
// this solution can be used to solve problem #78 (generate subsets for distinct integers) without modification since this is a more general solution
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        java.util.SortedMap<Integer, Integer> count = count(num);        
        return subset(count);
    }

	private java.util.SortedMap<Integer, Integer> count(int[] num) {
		java.util.SortedMap<Integer, Integer> count = new java.util.TreeMap<Integer, Integer>();
        for(int n : num) {
            if(!count.containsKey(n)) {
                count.put(n, 1);
            } else {
                count.put(n, count.get(n) + 1);
            }
        }
		return count;
	}

    private ArrayList<ArrayList<Integer>> subset(java.util.SortedMap<Integer, Integer> count) {
        ArrayList<ArrayList<Integer>> subSets = new ArrayList<ArrayList<Integer>>();
        if(count.isEmpty()) {
        	subSets.add(new ArrayList<Integer>());
        } else {
            int n = count.firstKey();
            int numberCount = count.remove(n);
            ArrayList<ArrayList<Integer>> subSubSets = subset(count);
            // add all subSubSets
            subSets.addAll(subSubSets);
            // add all subSubSets with current number
            for(ArrayList<Integer> subSubSet : subSubSets) {
            	for(int i = 1; i <= numberCount; i++) {
                	ArrayList<Integer> subSet = new ArrayList<Integer>();
                    for(int j = 0; j < i; j++) {
                        subSet.add(n);
                    }
                    subSet.addAll(subSubSet);
                    subSets.add(subSet);
                }
            }
        }
        return subSets;
    }
}
