package com.niyue.coding.leetcode.lengthoflastword;

// http://leetcode.com/onlinejudge#question_58
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int length = words.length == 0 ? 0 : words[words.length - 1].length();
        return length;
    }
}
