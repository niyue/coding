package com.niyue.coding.leetcode.validparentheses;

import java.util.ArrayDeque;
import java.util.Deque;

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// http://leetcode.com/onlinejudge#question_20
// http://oj.leetcode.com/problems/valid-parentheses/
public class Solution {
    public boolean isValid(String s) {
        boolean isValid = true;
        Deque<Character> stack = new ArrayDeque<Character>();
        for(int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            if(isOpen(si)) {
                stack.offerFirst(si);
            } else {
                if(stack.isEmpty()) {
                    isValid = false;
                    break;
                } else {
                    char top = stack.pollFirst();   
                    if(!isExpectedClose(top, si)) {
                        isValid = false;
                        break;
                    }
                }
            }
        }
        return isValid && stack.isEmpty();
    }
    
    private boolean isOpen(char c) {
        return c == '(' || c == '{' || c == '[';
    }
    
    private boolean isExpectedClose(char open, char close) {
        return open == '(' && close == ')' ||
               open == '{' && close == '}' ||
               open == '[' && close == ']';
    }
}
