package com.niyue.coding.leetcode.interleavingstring;

// http://leetcode.com/onlinejudge#question_97
// O(length1 * length2) time and space, use dynamic programming
public class Solution {
    private char[] s1;
    private char[] s2;
    private char[] s3;
    private Boolean[][] result;

    public boolean isInterleave(String string1, String string2, String string3) {
        s1 = string1.toCharArray();
        s2 = string2.toCharArray();
        s3 = string3.toCharArray();       
        result = new Boolean[s1.length + 1][s2.length + 1];
        boolean isInterleave = false;
        if(s1.length + s2.length == s3.length) {
            isInterleave = isInterleave(0, 0, 0);
        } 
        return isInterleave;
    }

    // only length1 * length2 space is required since length3 == length1 + length2 is invariant
    private boolean isInterleave(int i1, int i2, int i3) {
        boolean isInterleave = false;
        if(result[i1][i2] != null) {
            isInterleave = result[i1][i2];
        } else {
            if(i3 < s3.length) {
                boolean isS1Interleave = false;
                if(i1 < s1.length && s3[i3] == s1[i1]) {
                    isS1Interleave = isInterleave(i1 + 1, i2, i3 + 1);
                }
                boolean isS2Interleave = false;
                if(i2 < s2.length && s3[i3] == s2[i2]) {
                    isS2Interleave = isInterleave(i1, i2 + 1, i3 + 1);
                }
                isInterleave = isS1Interleave || isS2Interleave;
            } else {
                isInterleave = i1 == s1.length && i2 == s2.length;
            }
            result[i1][i2] = isInterleave;
        }
        return isInterleave;
    }
}
