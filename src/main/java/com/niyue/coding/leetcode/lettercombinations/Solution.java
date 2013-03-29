package com.niyue.coding.leetcode.lettercombinations;

import java.util.ArrayList;
import java.util.List;

// http://leetcode.com/onlinejudge#question_17
public class Solution {
    public ArrayList<String> letterCombinations(String number) {
        List<Integer> digits = digits(number);
        return combinations(digits, 0);
    }

    private ArrayList<String> combinations(List<Integer> digits, int i) {
        ArrayList<String> combinations = new ArrayList<String>();
        if(i == digits.size()) {
        	combinations.add("");
        } else {
            List<String> subCombinations = combinations(digits, i + 1);
            String[] chars = keypad[digits.get(i)];
            for(String c : chars) {
                for(String subCom : subCombinations) {
                    combinations.add(c + subCom);
                }
            }
        }
        return combinations;
    }

    private List<Integer> digits(String number) {
        char[] digitStrings = number.toCharArray();
        List<Integer> digits = new ArrayList<Integer>();
        for(char digit : digitStrings) {
            digits.add(digit - '0');
        }
        return digits;
    }

	private static final String[][] keypad = new String[][] {
    	{},
    	{},
    	{"a", "b", "c"},
    	{"d", "e", "f"},
    	{"g", "h", "i"},
    	{"j", "k", "l"},
    	{"m", "n", "o"},
    	{"p", "q", "r", "s"},
    	{"t", "u", "v"},
    	{"w", "x", "y", "z"}
    };
}
