package com.niyue.coding.leetcode.textjustification;

import java.util.ArrayList;

// http://leetcode.com/onlinejudge#question_68
public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        int start = 0;
        ArrayList<String> lines = new ArrayList<String>();
    	for(int i = 0, length = -1; i < words.length; i++) {
    		if(length + words[i].length() + 1 > L) {
    			String line = justify(words, start, i - 1, length, L);
    			lines.add(line);
    			start = i;
    			length = -1;
    		}
    		if(i == words.length - 1) {
    			String line = justifyLast(words, start, i, length + words[i].length() + 1, L);
    			lines.add(line);    
    		}
    		length += words[i].length() + 1;
    	}        
        return lines;
    }

    private String justify(String[] words, int start, int end, int length, int L) {
        int n = end - start;
        StringBuilder line = new StringBuilder();
        if(n == 0) {
            line.append(words[start]);
            for(int i = L - length; i > 0; i--) {
                line.append(" ");
            }
        } else {
            int small = (L - length) / n;
            int bigNo = L - length - small * n;
            for(int i = 0; i < bigNo; i++) {
                line.append(words[start + i]);
                for(int j = small + 2; j >= 1; j--) {
                    line.append(" ");
                }
            }
            for(int i = 0; i < n - bigNo + 1; i++) {
                line.append(words[start + bigNo + i]);
                if(i != n - bigNo) {
                	for(int j = small + 1; j >= 1; j--) {
                		line.append(" ");
                	}
                }
            }
        }
        return line.toString();
    }

    private String justifyLast(String[] words, int start, int end, int length, int L) {
        StringBuilder line = new StringBuilder();
        for(int i = start; i <= end; i++) {
            line.append(words[i]).append(" ");
        }
        line = line.deleteCharAt(line.length() - 1);
        for(int i = L - length; i >= 1; i--) {
            line.append(" ");
        }
        return line.toString();
    }
}
