package com.niyue.coding.leetcode.generateparentheses;

import java.util.ArrayList;

/*
 * http://oj.leetcode.com/problems/generate-parentheses/
 */
public class SolutionTwo {
    private ArrayList<String> solutions;
    private int N;
    private char[] solution;
    
    public ArrayList<String> generateParenthesis(int n) {
        N = n;
        solutions = new ArrayList<String>();
        solution = new char[n * 2];
        generate(0, 0);
        return solutions;
    }
    
    private void generate(int open, int close) {
        if(close == N) {
            solutions.add(new String(solution));
        } else {
            if(open > close) {
                solution[open + close] = ')';
                generate(open, close + 1);
            }
            if(open < N) {
                solution[open + close] = '(';
                generate(open + 1, close);
            }
        }
    }
}
