package com.niyue.coding.leetcode.wordbreakii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/*
 * http://oj.leetcode.com/problems/word-break-ii/
 * This problem can be solved similiar with word break i problem.
 * 1) Use DP to calculate the segmentable positions
 * 2) Calculate all solutions according to segmentable positions
 */
public class Solution {
    private ArrayList<String> solutions;
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        solutions = new ArrayList<String>();
        @SuppressWarnings("unchecked")
		List<Integer>[] segmentable = new List[s.length() + 1];        
        segmentable[s.length()] = Collections.emptyList();
        
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int k = i; k < s.length(); k++) {
                String word = s.substring(i, k + 1);    
                if(segmentable[k + 1] != null && dict.contains(word)) {
                    if(segmentable[i] == null) {
                        segmentable[i] = new ArrayList<Integer>();
                    }
                    segmentable[i].add(k);
                }    
            }
        }
        solutions(segmentable, 0, new ArrayList<String>(), s);
        return solutions;
    }
    
    private void solutions(List<Integer>[] segmentable, int i, List<String> words, String s) {
        if(i == s.length()) {
            solutions.add(toString(words));    
        } else {
        	if(segmentable[i] != null) {
        		for(int k : segmentable[i]) {
        			words.add(s.substring(i, k + 1));
        			solutions(segmentable, k + 1, words, s);
        			words.remove(words.size() - 1);
        		}
        	}
        }
    }
    
    private String toString(List<String> words) {
        StringBuilder sentence = new StringBuilder();
        for(int i = 0; i < words.size(); i++) {
            sentence.append(words.get(i));
            if(i < words.size() - 1) {
                sentence.append(" ");
            }
        }
        return sentence.toString();
    }
}