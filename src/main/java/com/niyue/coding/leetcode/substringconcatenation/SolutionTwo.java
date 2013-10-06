package com.niyue.coding.leetcode.substringconcatenation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/*
 * http://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 
 * 1) Count the words in L
 * 2) For each starting position, use a HashMap to hold the word count and use a Queue to keep the order of words in the window, 
 * 	  and use an integer (matchCount) to keep the number of words with expected count in the map as it is in L
 * 2.1) For each word, if it is in L and the count for it is less than the count in L
 * 	2.1.1) add the word into queue
 * 	2.1.2) increase count in map
 * 	2.1.3) if its count reaches the count in L, increase matchCount
 * 	2.1.4) if matchCount reaches the size of count in L, all words in L found, store the starting position, and remove the first word in queue accordingly
 * 2.2) if a word is in L but its count is larger or equal to its count in L, remove the first word in queue accordingly
 * 2.3) if a word is not in L, reset everything to its initial state and count from scratch
 *  
 * O(S * wordLenth) solution, space complexity is O(L * wordLength)
 */
public class SolutionTwo {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        int len = L[0].length();
        Map<String, Integer> count = count(L);
        ArrayList<Integer> indices = new ArrayList<Integer>();
        for(int i = 0; i < len; i++) {
        	Map<String, Integer> map = new HashMap<String, Integer>();
        	Queue<String> words = new ArrayDeque<String>();
        	int matchCount = 0;
            for(int j = i; j < S.length() - len + 1; j += len) {
                String w = S.substring(j, j + len);
                if(count.containsKey(w) && (!map.containsKey(w) || map.get(w) < count.get(w))) {
                	words.offer(w);
                    if(map.containsKey(w)) {
                        map.put(w, map.get(w) + 1);
                    } else {
                        map.put(w, 1);
                    }
                    if(map.get(w) == count.get(w)) {
                        matchCount++;
                    } 
                    if(matchCount == count.size()) {
                        indices.add(j - len * (L.length - 1));
                        String firstWord = words.poll();
                        map.put(firstWord, map.get(firstWord) - 1);
                        if(map.get(firstWord) == 0) {
                        	map.remove(firstWord);
                        }
                        matchCount--;
                    }
                } else if(count.containsKey(w) && !words.isEmpty() && words.peek().equals(w)) {
                	words.offer(words.poll());
                } else {
                	map = new HashMap<String, Integer>();    
                	words = new ArrayDeque<String>();
                	matchCount = 0;
                }
            }
        }
        return indices;
    }
    
    private Map<String, Integer> count(String[] L) {
        Map<String, Integer> map = new HashMap<String, Integer>();    
        for(String w : L) {
            if(map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 1);
            }
        }
        return map;
    }
}
