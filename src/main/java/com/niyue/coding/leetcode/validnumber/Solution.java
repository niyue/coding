package com.niyue.coding.leetcode.validnumber;

// http://leetcode.com/onlinejudge#question_65
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean isNumber = false;
        try {
        	if(!s.contains("f") && !s.contains("D")) {
        		Double.valueOf(s);
        		isNumber = true;
        	}
        } catch(Exception e) {
            if(!s.contains("f") && !s.contains("D") && !s.contains(" ") && s.replaceAll("e", "").length() == s.length() - 1) {
                String[] numbers = s.split("e");
                try {
                    Double.valueOf(numbers[0]);
                    Integer.valueOf(numbers[1]);
                    isNumber = true;
                } catch (Exception ex) {
                }   
            }
        }
        return isNumber;
    }
}
