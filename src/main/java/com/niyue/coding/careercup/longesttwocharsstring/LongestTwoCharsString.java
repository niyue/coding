package com.niyue.coding.careercup.longesttwocharsstring;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string.
 * Find the longest substring in it such that the substring contains only 2 unique characters.
 * Ex- aabbcbbbadef Ans-bbcbbb
 * http://www.careercup.com/question?id=17221689
 */
public class LongestTwoCharsString {
    public String longestTwoCharsString(String s) {
        if(s.length() <= 2) {
            return s;
        }
        Map<Character, Integer> existing = new LinkedHashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for(int i = 0; i < chars.length; i++) {
            if(existing.size() == 2 && !existing.containsKey(chars[i])) {
            	char firstChar = existing.keySet().iterator().next();
                start = existing.remove(firstChar) + 1;
            }
            existing.put(chars[i], i);  
            end++;
            if(end - start > maxEnd - maxStart) {
                maxStart = start;
                maxEnd = end;
            }
        }
        return s.substring(maxStart, maxEnd);
    }
}
