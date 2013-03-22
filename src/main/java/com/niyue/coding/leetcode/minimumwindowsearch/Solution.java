package com.niyue.coding.leetcode.minimumwindowsearch;

import java.util.HashMap;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_76
public class Solution {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        CharCountingMap count = charCount(t);
        int end = firstEnd(s, count);
        String minWindow = "";

        if(end != -1) {
        	CharCountingMap runningCount = count(s, 0, end, count);
            int minWindowStart = moveStart(runningCount, count, s, 0, end);
            int minWindowEnd = end;
            int start = minWindowStart;
            for(int i = end + 1; i < s.length; i++) {
            	if(count.contains(s[i])) {
            		runningCount.increase(s[i]);
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
    
    private int firstEnd(char[] s, CharCountingMap count) {
    	CharCountingMap runningCount = new CharCountingMap(count);
        int end = -1;
        for(int i = 0; i < s.length; i++) {
        	runningCount.decrease(s[i]);
            if(runningCount.isAllZero()) {
                end = i;
                break;
            }
        }
        return end;
    }

    private CharCountingMap count(char[] s, int start, int end, CharCountingMap count) {
    	CharCountingMap runningCount = new CharCountingMap();
        for(int i = start; i <= end; i++) {
            if(count.contains(s[i])) {
            	runningCount.increase(s[i]);
            }
        }
        return runningCount;
    }

    private int moveStart(CharCountingMap runningCount, CharCountingMap charCount, char[] s, int currentStart, int currentEnd) {
        for(int i = currentStart; i <= currentEnd; i++) {
            if(charCount.contains(s[i])) {
                if(runningCount.getCount(s[i]) > charCount.getCount(s[i])) {
                	runningCount.decrease(s[i]);
                } else {
                    currentStart = i;
                    break;
                }
            }
        }
        return currentStart;
    }

    private CharCountingMap charCount(char[] t) {
        CharCountingMap charCount = new CharCountingMap();
        for(char c : t) {
            charCount.increase(c);
        }
        return charCount;
    }
    
    private static class CharCountingMap {
    	private Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
    	private int zeroCount = 0;
    	
    	public CharCountingMap() {}
    	
    	public CharCountingMap(CharCountingMap that) {
    		this.countMap = new HashMap<Integer, Integer>(that.countMap);
    	}
    	
    	public void increase(char c) {
    		int charVal = (int) c;
    		if(!countMap.containsKey(charVal)) {
    			countMap.put(charVal, 0);
    		}
    		countMap.put(charVal, countMap.get(charVal) + 1);
    	}
    	
    	public void decrease(char c) {
    		int charVal = (int) c;
    		if(countMap.containsKey(charVal)) {
    			int count = countMap.get(charVal) - 1;
    			if(count == 0) {
    				zeroCount++;
    			}
    			countMap.put(charVal, count);
    		}
    	}
    	
    	public boolean contains(char c) {
    		int charVal = (int) c;
    		return countMap.containsKey(charVal);
    	}
    	
    	public int getCount(char c) {
    		int charVal = (int) c;
    		return countMap.get(charVal);
    	}
    	
    	public boolean isAllZero() {
    		return zeroCount == countMap.size();
    	}
    }
}
