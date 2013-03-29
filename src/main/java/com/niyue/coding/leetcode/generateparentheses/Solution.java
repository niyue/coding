package com.niyue.coding.leetcode.generateparentheses;

import java.util.ArrayList;

// http://leetcode.com/onlinejudge#question_22
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
public class Solution {
    private ArrayList<String> solutions;
    public ArrayList<String> generateParenthesis(int n) {
        solutions = new ArrayList<String>();
        generate("", 0, 0, n);
        return solutions;
    }

    private void generate(String p, int open, int close, int n) {
        if(close == n) {
            solutions.add(p);
        } else {
            if(open < n) {
                generate(p + "(", open + 1, close, n);    
            }
            if(open > close) {
                generate(p + ")", open, close + 1, n);
            }
        }
    }
}
