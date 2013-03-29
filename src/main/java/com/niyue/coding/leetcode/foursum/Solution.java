package com.niyue.coding.leetcode.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_18
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        Map<Integer, List<List<Integer>>> twoSums = new HashMap<Integer, List<List<Integer>>>();
        for(int i = 0; i < num.length; i++) {
            for(int j = i + 1; j < num.length; j++) {
                int twoSum = num[i] + num[j];
                if(!twoSums.containsKey(twoSum)) {
                    twoSums.put(twoSum, new LinkedList<List<Integer>>());                    
                }
                twoSums.get(twoSum).add(Arrays.asList(num[i], num[j]));
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
        return solutions;
    }

    private ArrayList<ArrayList<Integer>> twoEqualSums(List<List<Integer>> twoSumList) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < twoSumList.size(); i++) {
            for(int j = i + 1; j < twoSumList.size(); j++) {
                if(isAllDifferent(twoSumList.get(i), twoSumList.get(j))) {    
                    solutions.add(newSolution(twoSumList.get(i), twoSumList.get(j)));
                }
            }
        }
        return solutions;
    }

    private ArrayList<ArrayList<Integer>> twoSums(List<List<Integer>> twoSumList, List<List<Integer>> anotherTwoSumList) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        for(List<Integer> twoSum : twoSumList) {
            for(List<Integer> anotherTwoSum : anotherTwoSumList) {
                if(isAllDifferent(twoSum, anotherTwoSum)) {
                    solutions.add(newSolution(twoSum, anotherTwoSum));   
                }
            }
        }
        return solutions;
    }

    private boolean isAllDifferent(List<Integer> twoSum, List<Integer> anotherTwoSum) {
        return twoSum.get(0) != anotherTwoSum.get(0) &&
               twoSum.get(1) != anotherTwoSum.get(1) &&
               twoSum.get(0) != anotherTwoSum.get(1) &&
               twoSum.get(1) != anotherTwoSum.get(0);
    }

    private ArrayList<Integer> newSolution(List<Integer> twoSum, List<Integer> anotherTwoSum) {
        ArrayList<Integer> solution = new ArrayList<Integer>();
        solution.add(twoSum.get(0));   
        solution.add(twoSum.get(1));
        solution.add(anotherTwoSum.get(0));
        solution.add(anotherTwoSum.get(1));
        Collections.sort(solution);    
        return solution;
    }
}
