package com.niyue.coding.leetcode.minimumwindowsearch;

import java.util.HashMap;
import java.util.Map;

/* 
 * http://oj.leetcode.com/problems/minimum-window-substring/
 * Use a counting map to count the number of appearance of chars in T
 * For each char in S, if it appears in the map, decrease it number of appearance
 * if it reaches zero, this number appears at least the number of times in S, decrease the number of nonZeroCount
 * if nonZeroCount is zero, which means the window contains all chars in T (invariant), we need to move start pointer as far as possible to find the minimum window
 */
public class SolutionTwo {
    public String minWindow(String S, String T) {
        int minStart = -1;
        int minEnd = -1;
        int start = 0;
        Map<Character, Integer> count = count(T);
        int nonZeroCount = count.size();
        for(int i = 0; i < S.length(); i++) {
            char e = S.charAt(i);
            if(count.containsKey(e)) {
                count.put(e, count.get(e) - 1);
                if(count.get(e) == 0) {
                    nonZeroCount--;
                }
                if(nonZeroCount == 0) {
                    while(start <= i) {
                        char s = S.charAt(start);
                        if(count.containsKey(s)) {
                            if(count.get(s) < 0) {
                                start++;
                                count.put(s, count.get(s) + 1);    
                            } else {
                                break;
                            }
                        } else {
                            start++;
                        }
                    }
                    if(minStart == -1 || i - start < minEnd - minStart) {
                        minEnd = i;
                        minStart = start;    
                    }
                }
            }
        }
        return minStart == -1 ? "" : S.substring(minStart, minEnd + 1);
    }
    
    private Map<Character, Integer> count(String T) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for(char c : T.toCharArray()) {
            if(!count.containsKey(c)) {
                count.put(c, 1);
            } else {
                count.put(c, count.get(c) + 1);
            }
        }
        return count;
    }
}
