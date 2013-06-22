package com.niyue.coding.leetcode.romantointeger;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_13
public class Solution {
    private static final Map<String, Integer> notationMap = romanNotations();
    
    private static Map<String, Integer> romanNotations() {
    	final List<String> notations = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
    	final List<Integer> values = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
    	
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < notations.size(); i++) {
            map.put(notations.get(i), values.get(i));
        }
        return Collections.unmodifiableMap(map);
    }

    public int romanToInt(String s) {
        int value = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i + 1 < s.length()) {
                String nextTwo = s.substring(i, i + 2);
                if(notationMap.containsKey(nextTwo)) {
                    value += notationMap.get(nextTwo);
                    i++;
                } else {
                    String nextOne = s.substring(i, i + 1);
                    value += notationMap.get(nextOne);
                }
            } else {
                String nextOne = s.substring(i, i + 1);
                value += notationMap.get(nextOne);
            }
        }
        return value;
    }
}
