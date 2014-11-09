package com.niyue.coding.leetcode.reversewordsinastring;

// https://oj.leetcode.com/problems/reverse-words-in-a-string/
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        for(int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
        }
        String result = join(words);
        return reverse(result);
    }
    
    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    private String join(String[] words) {
        StringBuilder s = new StringBuilder();
        if(words.length > 0) {
            s.append(words[0]);
        }
        for(int i = 1; i < words.length; i++) {
            s.append(" ");
            s.append(words[i]);
        }
        return s.toString();
    }
}