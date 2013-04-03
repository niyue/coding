package com.niyue.coding.leetcode.permutations;

import java.util.ArrayList;

// http://leetcode.com/onlinejudge#question_46
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        return permute(num, num.length - 1);
    }

    private ArrayList<ArrayList<Integer>> permute(int[] num, int i) {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
        if(i == 0) {
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            permutation.add(num[i]);
            permutations.add(permutation);
        } else {
            ArrayList<ArrayList<Integer>> subPermutations = permute(num, i - 1);
            for(ArrayList<Integer> subPermutation : subPermutations) {
                for(int j = 0; j <= subPermutation.size(); j++) {
                    ArrayList<Integer> permutation = new ArrayList<Integer>(subPermutation);
                    permutation.add(j, num[i]);
                    permutations.add(permutation);
                }
            }       
        }
        
        return permutations;
    }
}
