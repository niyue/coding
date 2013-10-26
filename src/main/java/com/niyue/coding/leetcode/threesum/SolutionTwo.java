package com.niyue.coding.leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * http://oj.leetcode.com/problems/3sum/
 * O(n^2) solution to three sum problem without using HashSet
 * 1) sort the num array
 * 2) i is the index for the first number, for each num[i], search other two numbers with sum of -num[i]
 * 3) j is the index for the second number, and k is the index for the third number, for each i, search num[i..end] from two ends using pinter j and k
 * 4) key observation for handling duplicated value is, for each i, j, and k, instead of i++,j++,k--, move the pointer to a non duplicated value each time 
 */
public class SolutionTwo {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> sums = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < num.length - 2; i = nextNonDuplicate(num, i)) {
            int target = -num[i];
            int j = i + 1;
            int k = num.length - 1;
            while(j < k) {
                int sum = num[j] + num[k];
                if(sum == target) {
                    sums.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k])));   
                    j = nextNonDuplicate(num, j);
                    k = prevNonDuplicate(num, k);
                } else if(sum < target) {
                	j = nextNonDuplicate(num, j);
                } else {
                    k = prevNonDuplicate(num, k);
                }
            }
        }
        return sums;
    }
    
    private int nextNonDuplicate(int[] num, int i) {
    	return nextNonDuplicate(num, i, 1);
    }
    
    private int prevNonDuplicate(int[] num, int i) {
    	return nextNonDuplicate(num, i, -1);
    }
    
    private int nextNonDuplicate(int[] num, int i, int diff) {
    	int x = i;
        while(x >= 0 && x < num.length && num[i] == num[x]) {
        	x += diff;
        }
        return x;
    }
}
