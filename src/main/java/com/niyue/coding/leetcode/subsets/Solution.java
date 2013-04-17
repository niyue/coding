package com.niyue.coding.leetcode.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// http://leetcode.com/onlinejudge#question_78
// generate a power set for a set
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	Arrays.sort(S);
    	return subsets(S, 0);
    }

    private ArrayList<ArrayList<Integer>> subsets(int[] S, int i) {
    	ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
        if(i == S.length) {
        	set.add(new ArrayList<Integer>());
        } else {
        	ArrayList<ArrayList<Integer>> subsets = subsets(S, i + 1);
        	set.addAll(subsets);
        	for(ArrayList<Integer> subset : subsets) {
        		ArrayList<Integer> oneSet = new ArrayList<Integer>(Collections.singletonList(S[i]));	
        		oneSet.addAll(subset);
        		set.add(oneSet);
        	}
        }   
        return set;     
    }
}
