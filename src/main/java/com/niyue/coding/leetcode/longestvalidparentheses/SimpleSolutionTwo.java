package com.niyue.coding.leetcode.longestvalidparentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * http://oj.leetcode.com/problems/longest-valid-parentheses/
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 */
public class SimpleSolutionTwo {
    public int longestValidParentheses(String s) {
        boolean[] valid = new boolean[s.length()];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.offerFirst(i);
            } else {
                if(!stack.isEmpty()) {
                    valid[stack.pollFirst()] = true;
                    valid[i] = true;
                }                
            }
        }
        int max = 0;
        for(int i = 0; i < valid.length; i++) {
            int l = 0;
            while(i < valid.length && valid[i]) {
                l++;       
                i++;
            }
            if(l > max) {
                max = l;
            }
        }
        return max;
    }
}
