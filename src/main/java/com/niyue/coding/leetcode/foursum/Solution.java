package com.niyue.coding.leetcode.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// http://leetcode.com/onlinejudge#question_18
// O(n^2) solution to the four sum problem
public class Solution {
	private int[] num;
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        Set<ArrayList<Integer>> solutions = new HashSet<ArrayList<Integer>>();
        num = numbers;
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

        java.util.Iterator<Map.Entry<Integer, List<List<Integer>>>> iter = twoSums.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<Integer, List<List<Integer>>> twoSum = iter.next();
            int anotherTwoSum = target - twoSum.getKey();
            List<List<Integer>> twoSumList = twoSum.getValue();
            if(anotherTwoSum == twoSum.getKey() && twoSumList.size() > 1) {
                solutions.addAll(twoEqualSums(twoSumList));
            } else if(twoSums.containsKey(anotherTwoSum)) {
                List<List<Integer>> anotherTwoSumList = twoSums.get(anotherTwoSum);
                solutions.addAll(twoSums(twoSumList, anotherTwoSumList));
            }    
            iter.remove();
        }
        return new ArrayList<ArrayList<Integer>>(solutions);
    }

    private Set<ArrayList<Integer>> twoEqualSums(List<List<Integer>> twoSumList) {
        Set<ArrayList<Integer>> solutionSet = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < twoSumList.size(); i++) {
            for(int j = i + 1; j < twoSumList.size(); j++) {
            	solutionSet.add(newSolution(twoSumList.get(i), twoSumList.get(j)));
            }
        }
        return solutionSet;
    }

    private Set<ArrayList<Integer>> twoSums(List<List<Integer>> twoSumList, List<List<Integer>> anotherTwoSumList) {
        Set<ArrayList<Integer>> solutionSet = new HashSet<ArrayList<Integer>>();
        for(List<Integer> twoSum : twoSumList) {
            for(List<Integer> anotherTwoSum : anotherTwoSumList) {
        		solutionSet.add(newSolution(twoSum, anotherTwoSum));   
            }
        }
        return solutionSet;
    }

    private ArrayList<Integer> newSolution(List<Integer> twoSum, List<Integer> anotherTwoSum) {
        ArrayList<Integer> solution = new ArrayList<Integer>();
        solution.add(num[twoSum.get(0)]);   
        solution.add(num[twoSum.get(1)]);
        solution.add(num[anotherTwoSum.get(0)]);
        solution.add(num[anotherTwoSum.get(1)]);
        Collections.sort(solution);    
        return solution;
    }
}
