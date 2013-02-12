package com.niyue.coding.leetcode.wordladder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// http://leetcode.com/onlinejudge#question_127
public class Solution {
	
    public int ladderLength(String start, String end, HashSet<String> dict) {
    	Set<String> startTransformableWords =  new HashSet<String>(transformableWords(start, dict, false));
    	Set<String> startWords = dict.contains(start) 
    			? new HashSet<String>(Arrays.asList(start))
    			: new HashSet<String>(transformableWords(start, dict, true));
    	Set<String> endWords = dict.contains(end)
    			? new HashSet<String>(Arrays.asList(end))
    			: new HashSet<String>(transformableWords(end, dict, true));
    	int length = 0;
    	if(startTransformableWords.contains(end)) {
    		length = 2;
    	} else {
    		Map<String, List<String>> dictGraph = makeGraph(dict);
    		length = bfs(startWords, endWords, dictGraph);
    		if(length != 0) {
    			if(!dict.contains(start)) {
    				length++;
    			}
    			if(!dict.contains(end)) {
    				length++;
    			}
    		}
    	}
        return length;
    }
    
    private int bfs(Set<String> startWords, Set<String> endWords, Map<String, List<String>> dictGraph) {
        Queue<String> wordQueue = new LinkedList<String>();
        wordQueue.addAll(startWords);
        wordQueue.offer(null);
        int length = 1;
        boolean found = false;
        Set<String> visitedWords = new HashSet<String>();
        while(!(wordQueue.size() == 1 && wordQueue.peek() == null)) {
            String word = wordQueue.poll();
            if(!visitedWords.contains(word)) {
                if(word == null) {
                    wordQueue.offer(null);
                    length++;    
                } else {
                    if(endWords.contains(word)) {
                        found = true;
                        break;        
                    } else {
                        visitedWords.add(word);
                        if(dictGraph.containsKey(word)) {
                            List<String> connectedWords = dictGraph.get(word);
                            wordQueue.addAll(connectedWords);    
                        }
                    }      
                } 
            }
        }
        return found ? length : 0;
    }
    
    Map<String, List<String>> makeGraph(Set<String> dict) {
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        for(String word : dict) {
            List<String> connectedWords = transformableWords(word, dict, true);   
            graph.put(word, connectedWords);
        }
        return graph;
    }
    
    private List<String> transformableWords(String word, Set<String> dict, boolean checkDict) {
        List<String> words = new LinkedList<String>();
        char[] chars = word.toCharArray();
        for(int i = 0;i < chars.length;i++) {
            char ch = chars[i];
            for(char letter : alphabet) {
                if(letter != ch) {
                    chars[i] = letter;
                    String newWord = new String(chars);
                	if(!checkDict || dict.contains(newWord)) {
                		words.add(newWord);    
                	}
                    chars[i] = ch;
                }
            }    
        }
        return words;
    }
    
    private static final char[] alphabet = new char[] {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z'};
}
