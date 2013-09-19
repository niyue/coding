package com.niyue.coding.leetcode.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 *  http://leetcode.com/onlinejudge#question_18
 * O(n^2) solution to the four sum problem
 * UPDATE: this is a O(n^4) solution at the worst case, for example, for an array with all values as 0, and target is 0
 * because we need to find all possible solutions instead of only one
 * http://discuss.leetcode.com/questions/199/4sum/990, this is a O(n^3) solution that can be easily understood
 * basically:
 * 1) sort the array
 * 2) two level of loops, using variable i and j, where i stands for the first number index in a solution and j stands for the fourth
 * 	2.1) here the key observation is: since i is the first index, and we don't allow duplicated solution, if num[i - 1] == num[i], we can ignore i because (i - 1) is already be tested as the first index
 * 	2.2) it is the similar idea to ignore j if num[j] == num[j + 1]  
 * 3) once we have decided the first and fourth index, we need to figure out the second (called L) and the third (called R)
 * 	3.1) the key observation is: if L != i + 1 and num[L] == num[L - 1], it can be ignored because (L - 1) is already be tested as the second index
 * 	3.2) it is the similar idea to ignore R if R != j - 1 and num[R] == num[R + 1]
 * 	3.3) if sum > target, R--
 * 	3.4) if sum < target, L++
 * 	3.5) if sum == target, a non duplicated solution is found, L++, R-- 
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Set<ArrayList<Integer>> solutions = new HashSet<ArrayList<Integer>>();
        Map<Integer, List<List<Integer>>> sums = new HashMap<Integer, List<List<Integer>>>();
        for(int i = 0; i < num.length - 3; i++) {
            for(int j = i + 1; j < num.length - 2; j++) {
                int twoSum = num[i] + num[j];
                if(!sums.containsKey(twoSum)) {
                    sums.put(twoSum, new ArrayList<List<Integer>>());
                }
                sums.get(twoSum).add(Arrays.asList(i, j));
            }
        }
        for(int i = 2; i < num.length - 1; i++) {
            for(int j = i + 1; j < num.length; j++) {
                int twoSum = num[i] + num[j];
                if(sums.containsKey(target - twoSum)) {
                    List<List<Integer>> firstSeconds = sums.get(target - twoSum);
                    for(List<Integer> firstSecond : firstSeconds) {
                        if(firstSecond.get(1) < i) {
                            List<Integer> solution = Arrays.asList(num[firstSecond.get(0)], num[firstSecond.get(1)], num[i], num[j]);
                            Collections.sort(solution);
                            solutions.add(new ArrayList<Integer>(solution));
                        }
                    }
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(solutions);
    }
}
