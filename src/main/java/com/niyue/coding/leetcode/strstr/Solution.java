package com.niyue.coding.leetcode.strstr;

// http://leetcode.com/onlinejudge#question_28
public class Solution {
    public String strStr(String haystack, String needle) {
        char[] pattern = needle.toCharArray();
        char[] text = haystack.toCharArray();
        int[] b = preProcess(pattern);
        int first = search(text, pattern, b);
        return first == -1 ? null : haystack.substring(first - pattern.length);
    }

    private int[] preProcess(char[] pattern) {
        int[] b = new int[pattern.length + 1];
        b[0] = -1;
        int i = 0;
        int j = b[0];
        while(i < pattern.length) {
            while(j >= 0 && pattern[i] != pattern[j]) {
                j = b[j];
            }
            i++;
            j++;
            b[i] = j;
        }
        return b;
    }

    private int search(char[] text, char[] pattern, int[] b) {
        int i = -1;
        int j = -1;
        while(i < text.length) {
            while(j >= 0 && text[i] != pattern[j]) {
                j = b[j];
            }
            i++;
            j++;
            if(j == pattern.length) {
                return i;
            }
        }
        return -1;
    }
}
