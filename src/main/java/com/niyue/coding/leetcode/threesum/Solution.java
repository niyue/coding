package com.niyue.coding.leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// http://leetcode.com/onlinejudge#question_15
// an O(n^2) time and space solution to the three sum problem
public class Solution {
	private Map<Integer, Set<Integer>> existingSolutions;
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	existingSolutions = new HashMap<Integer, Set<Integer>>();
    	Arrays.sort(num);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++) {
            map.put(-1 * num[i], i);
        }

        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < num.length; i++) {
            for(int j = i + 1; j < num.length; j++) {
                int twoSum = num[i] + num[j];
                if(map.containsKey(twoSum)) {
                    int third = map.get(twoSum);
                    if(third > j) {
                        add(solutions, num[i], num[j], num[third]);
                    }
                }
            }
        }
        return solutions;
    }

    private void add(ArrayList<ArrayList<Integer>> solutions, int i, int j, int k) {
    	if(!existingSolutions.containsKey(i)) {
    		existingSolutions.put(i, new HashSet<Integer>());
    	}
    	if(!existingSolutions.get(i).contains(j)) {
    		existingSolutions.get(i).add(j);
    		ArrayList<Integer> solution = new ArrayList<Integer>();
    		solution.add(i);
    		solution.add(j);
    		solution.add(k);
    		solutions.add(solution);
    	}
    }
}
