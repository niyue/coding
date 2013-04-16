package com.niyue.coding.leetcode.stringtointeger;

import java.util.LinkedList;
import java.util.List;

// http://leetcode.com/onlinejudge#question_8
public class Solution {
    public int atoi(String str) {
    	str = str.trim();
    	if(str.length() > 0) {
    		boolean positive = str.charAt(0) != '-';
    		if(str.charAt(0) == '+' || str.charAt(0) == '-') {
    			str = str.substring(1);
    		}
    		char[] chars = str.toCharArray();
    		List<Character> digits = new LinkedList<Character>();
    		for(char c : chars) {
    			if(isDigit(c)) {
    				digits.add(c);    
    			} else {
    				break;
    			}
    		}        
    		try {
    			return digits.isEmpty() ? 0 : (positive ? 1 : -1) * Integer.valueOf(number(digits));
    		} catch(Exception e) {
    			return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    		}
    	} else {
    		return 0;
    	}
    }

    private boolean isDigit(char c) {
        return c - '0' >= 0 && '9' - c >= 0;
    }

    private String number(List<Character> digits) {
        StringBuffer number = new StringBuffer();
        for(char c : digits) {
            number.append(c);
        }
        return number.toString();
    }
}
