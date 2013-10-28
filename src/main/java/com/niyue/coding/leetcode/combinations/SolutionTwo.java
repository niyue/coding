package com.niyue.coding.leetcode.combinations;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * http://oj.leetcode.com/problems/combinations/
 */
public class SolutionTwo {
    private ArrayList<ArrayList<Integer>> combinations;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        combinations = new ArrayList<ArrayList<Integer>>();
        generate(n, k, new LinkedList<Integer>());
        return combinations;
    }
    
    private void generate(int n, int k, LinkedList<Integer> combination) {
        if(k == 0) {
            combinations.add(new ArrayList<Integer>(combination));
        } else {
            if(n > k) {
                generate(n - 1, k, combination);    
            }
            combination.offerFirst(n);
            generate(n - 1, k - 1, combination);
            combination.pollFirst();
        }
    }
}
