package com.niyue.coding.leetcode.permutationsequence;

import java.util.ArrayList;
import java.util.List;

/*
 * http://oj.leetcode.com/problems/permutation-sequence/
 * http://leetcode.com/onlinejudge#question_60
 */
public class Solution {

    public String getPermutation(int n, int k) {
        int[] factorials = factorials(n);
        StringBuilder permutation = new StringBuilder();
        List<Integer> numbers = numbers(n);
        k--; // change k to be zero based
        for(int i = n; i >= 1; i--) {
            int factorial = factorials[i - 1];
            int pi = k / factorial;
            int p = numbers.remove(pi);
            permutation.append(p);
            k = k - pi * factorial;
        } 
        return permutation.toString();
    }

    private int[] factorials(int n) {
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        for(int i = 1; i <= n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        return factorials;
    }

    private List<Integer> numbers(int n) {
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}


