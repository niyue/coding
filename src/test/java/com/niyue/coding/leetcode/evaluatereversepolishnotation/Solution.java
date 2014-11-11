package com.niyue.coding.leetcode.evaluatereversepolishnotation;

import java.util.Arrays;
import java.util.Set;

public class Solution {
    private final Set<String> opSet = new java.util.HashSet<String>(Arrays.asList("+", "-", "*", "/"));
    private java.util.Deque<Integer> stack = new java.util.ArrayDeque<Integer>();
    
    public int evalRPN(String[] tokens) {
        for(int i = 0; i < tokens.length; i++) {
            if(isOperator(tokens[i])) {
                int b = stack.removeFirst();
                int a = stack.removeFirst();
                int value = calculate(a, b, tokens[i]);
                stack.addFirst(value);
            } else {
                stack.addFirst(Integer.parseInt(tokens[i]));
            }
        }    
        return stack.peekFirst();
    }
    
    private boolean isOperator(String s) {
        return opSet.contains(s);
    }
    
    private int calculate(int a, int b, String op) {
        int val = 0;
        if(op.equals("+")) {
            val = a + b;
        } else if(op.equals("-")) {
            val = a - b;
        } else if(op.equals("*")) {
            val = a * b;
        } else {
            val = a / b;
        }
        return val;
    }
}