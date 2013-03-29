package com.niyue.coding.leetcode.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// http://leetcode.com/onlinejudge#question_18
// O(n^2) solution to the four sum problem
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Set<ArrayList<Integer>> solutions = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        Map<Integer, List<List<Integer>>> twoSums = new HashMap<Integer, List<List<Integer>>>();
        for(int i = 0; i < num.length; i++) {
            for(int j = i + 1; j < num.length; j++) {
                int twoSum = num[i] + num[j];
                if(!twoSums.containsKey(twoSum)) {
                    twoSums.put(twoSum, new LinkedList<List<Integer>>());                    
                }
                twoSums.get(twoSum).add(Arrays.asList(i, j));
            }
        }        

        for(int first = 0; first < num.length - 3; first++) {
        	for(int fourth = first + 3; fourth < num.length; fourth++) {
        		int twoSum = num[first] + num[fourth];
        		int anotherTwoSum = target - twoSum;
        		if(twoSums.containsKey(anotherTwoSum)) {
        			List<List<Integer>> anotherTwoSumList = twoSums.get(anotherTwoSum);
        			for(List<Integer> secondAndThird : anotherTwoSumList) {
        				if(first < secondAndThird.get(0) && secondAndThird.get(1) < fourth) {
        					solutions.add(new ArrayList<Integer>(Arrays.asList(num[first], num[secondAndThird.get(0)], num[secondAndThird.get(1)], num[fourth])));
        				}
        			}
        		}
        	}
        }

        return new ArrayList<ArrayList<Integer>>(solutions);
    }
}
