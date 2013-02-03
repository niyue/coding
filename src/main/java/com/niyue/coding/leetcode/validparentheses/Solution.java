package com.niyue.coding.leetcode.validparentheses;

import java.util.Deque;
import java.util.LinkedList;

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// http://leetcode.com/onlinejudge#question_20
public class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new LinkedList<Integer>();
        boolean isValid = true;
        for(char c : chars) {
            if(isOpenChar(c)) {
                stack.push((int) c);
            } else {
                if(stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                int openChar = stack.pop();
                char expectedOpenChar = findOpenChar(c);
                if(openChar != (int) expectedOpenChar) {
                    isValid = false;
                    break;
                }
            }
        }
        if(!stack.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }
    
    private boolean isOpenChar(char c) {
        return c == '(' || c == '{' || c == '[';
    }
    
    private char findOpenChar(char c) {
        if(c == ')') {
            return '(';
        } else if(c == ']') {
            return '[';
        } else {
            return '{';
        }
    }
}
