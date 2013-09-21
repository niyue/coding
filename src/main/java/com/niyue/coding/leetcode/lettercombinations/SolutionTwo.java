package com.niyue.coding.leetcode.lettercombinations;

import java.util.ArrayList;
import java.util.List;

public class SolutionTwo {
    private ArrayList<String> combinations = null;
    private static final Character[][] keypad = new Character[][] {
    	{},
    	{},
    	{'a', 'b', 'c'},
    	{'d', 'e', 'f'},
    	{'g', 'h', 'i'},
    	{'j', 'k', 'l'},
    	{'m', 'n', 'o'},
    	{'p', 'q', 'r', 's'},
    	{'t', 'u', 'v'},
    	{'w', 'x', 'y', 'z'}
    };
    
    public ArrayList<String> letterCombinations(String digits) {
        combinations = new ArrayList<String>();
        solve(digits, 0, new ArrayList<Character>());
        return combinations;
    }
    
    private void solve(String digits, int i, List<Character> letters) {
        if(i == digits.length()) {
            combinations.add(toString(letters));   
        } else {
            for(Character c : keypad[digits.charAt(i) - '0']) {
                letters.add(c);
                solve(digits, i + 1, letters);
                letters.remove(letters.size() - 1);
            }
        }
    }
    
    private String toString(List<Character> letters) {
        StringBuilder s = new StringBuilder();
        for(Character c : letters) {
            s.append(c);
        }
        return s.toString();
    }
}
