package com.niyue.coding.leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * http://oj.leetcode.com/problems/3sum/
 * Initial solution for three sum problem, this solution doesn't handle duplicated value correctly
 */
public class SolutionTwo {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> sums = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < num.length - 2; i++) {
            int target = -num[i];
            int j = i + 1;
            int k = num.length - 1;
            while(j < k) {
                int sum = num[j] + num[k];
                if(sum == target) {
                    sums.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k])));   
                    j++;
                    k--;
                } else if(sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sums;
    }
}
