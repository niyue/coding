package com.niyue.coding.leetcode.minimumwindowsearch;

import java.util.Map;

public class Solution {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        Map<Integer, Integer> count = charCount(t);
        int end = firstEnd(s, count);
        String minWindow = "";

        if(end != -1) {
        	Map<Integer, Integer> runningCount = count(s, 0, end, count);
            int minWindowStart = moveStart(runningCount, count, s, 0, end);
            int minWindowEnd = end;
            int start = minWindowStart;
            for(int i = end + 1; i < s.length; i++) {
            	int charVal = (int) s[i];
            	if(count.containsKey(charVal)) {
            		runningCount.put(charVal, runningCount.get(charVal) + 1);
            	}
                if(s[i] == s[start]) {
                    end = i;
                    start = moveStart(runningCount, count, s, start, end);
                    if(end - start < minWindowEnd - minWindowStart) {
                        minWindowStart = start;
                        minWindowEnd = end;
                    }
                }    
            }
            minWindow = S.substring(minWindowStart, minWindowEnd + 1);
        } 
        return minWindow;
    }
    
    private int firstEnd(char[] s, Map<Integer, Integer> count) {
    	Map<Integer, Integer> runningCount = new java.util.LinkedHashMap<Integer, Integer>(count);
        int end = -1;
        for(int i = 0; i < s.length; i++) {
            int charVal = (int) s[i];
            if(runningCount.containsKey(charVal)) {
                int decreasedCount = runningCount.get(charVal) - 1;
                if(decreasedCount == 0) {
                    runningCount.remove(charVal);
                } else {
                    runningCount.put(charVal, decreasedCount);
                }
            }
            if(runningCount.isEmpty()) {
                end = i;
                break;
            }
        }
        return end;
    }

    private Map<Integer, Integer> count(char[] s, int start, int end, Map<Integer, Integer> count) {
        Map<Integer, Integer> runningCount = new java.util.LinkedHashMap<Integer, Integer>();
        for(int i = start; i <= end; i++) {
            int charVal = (int) s[i];
            if(count.containsKey(charVal)) {
                if(!runningCount.containsKey(charVal)) {
                    runningCount.put(charVal, 0);
                }
                runningCount.put(charVal, runningCount.get(charVal) + 1);
            }
        }
        return runningCount;
    }

    private int moveStart(Map<Integer, Integer> runningCount, Map<Integer, Integer> charCount, char[] s, int currentStart, int currentEnd) {
        for(int i = currentStart; i <= currentEnd; i++) {
            int charVal = (int) s[i];
            if(charCount.containsKey(charVal)) {
                if(runningCount.get(charVal) > charCount.get(charVal)) {
                    runningCount.put(charVal, runningCount.get(charVal) - 1);    
                } else {
                    currentStart = i;
                    break;
                }
            }
        }
        return currentStart;
    }

    private Map<Integer, Integer> charCount(char[] t) {
        Map<Integer, Integer> count = new java.util.LinkedHashMap<Integer, Integer>();
        for(char c : t) {
            int charVal = (int) c;
            if(!count.containsKey(charVal)) {
                count.put(charVal, 0);
            }
            count.put(charVal, count.get(charVal) + 1);
        }
        return count;
    }
}
