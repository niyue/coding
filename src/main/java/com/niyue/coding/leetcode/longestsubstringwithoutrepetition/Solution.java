package com.niyue.coding.leetcode.longestsubstringwithoutrepetition;

import java.util.Map;

// http://leetcode.com/onlinejudge#question_3
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Integer, Integer> charsMap = new java.util.LinkedHashMap<Integer, Integer>();
        int max = 0;
        char[] chars = s.toCharArray();
        for(int i = 0;i < chars.length;i++) {
            int charCode = (int) chars[i];
            if(charsMap.containsKey(charCode)) {
                int previousIndex = charsMap.get(charCode);
                removeEntriesBeforeIndex(charsMap, previousIndex, chars);
                charsMap.put(charCode, i);
            } else {
                charsMap.put(charCode, i);
                if(max < charsMap.size()) {
                    max =  charsMap.size();
                }
            } 
        }
        return max;
    }
    
    private void removeEntriesBeforeIndex(Map<Integer, Integer> charsMap, int endIndex, char[] chars) {
        int firstIndex = charsMap.entrySet().iterator().next().getValue();
        for(int i = firstIndex;i <= endIndex;i++) {
            int removeChar = (int) chars[i];
            charsMap.remove(removeChar);
        }
    }
};
