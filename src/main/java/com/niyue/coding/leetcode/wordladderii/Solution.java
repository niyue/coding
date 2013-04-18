package com.niyue.coding.leetcode.wordladderii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// http://leetcode.com/onlinejudge#question_127
// From start word, compute its connected words (one letter differed words)
// Use BFS to traverse the implicit graph until end word is found
// since we need to find all the possible ladders, instead of stopping BFS traversal immediately when the first minimum is found, we just set a flag and continue finding until this level is searched
// for each word, there may be multiple ladders connected to it, if it is non visited, we need to compute its connected words and do BFS for these words
// if it is visited previously, we only need to add it to the minimum paths list so that we can get all the paths in the end by using combination
public class Solution {
	
	public ArrayList<ArrayList<String>> findLadders(final String start, final String end, HashSet<String> dict) {
    	ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
    	
    	if(isOneDiff(start, end)) {
    		ladders.add(new ArrayList<String>(Arrays.asList(start, end)));
    	} else {
    		Map<String, List<Ladder>> solutions = bfs(start, end, dict);
    		ladders = ladders(solutions, start, end);
    	}
        return ladders;
    }
    
	// recursively to find all combinational paths to the end word
    private ArrayList<ArrayList<String>> ladders(Map<String, List<Ladder>> pathMap, String start, String end) {
    	ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
    	if(end.equals(start)) {
    		ladders.add(new ArrayList<String>(Arrays.asList(start)));
    	} else {
    		if(pathMap.containsKey(end)) {
    			List<Ladder> paths = pathMap.get(end);
    			for(Ladder path : paths) {
    				ArrayList<ArrayList<String>> subLadders = ladders(pathMap, start, path.from.word);
    				for(ArrayList<String> subLadder : subLadders) {
    					subLadder.add(end);
    					ladders.add(subLadder);
    				}
    			}
    		}
    	}
    	return ladders;
    }
    
    private static class Ladder {
    	public final String word;
    	public final Ladder from;
    	private int length = 0;
    	public Ladder(String word, Ladder from) {
    		this.word = word;
    		this.from = from;
    		this.length = from == null ? 1 : 1 + from.length;
    	}
		
    	@Override
		public String toString() {
			return word + " <= " + from;
		}
    }
    
    private Map<String, List<Ladder>> bfs(String start, String end, Set<String> dict) {
    	dict.add(end);
        Queue<Ladder> wordQueue = new LinkedList<Ladder>();
        Map<String, List<Ladder>> minLadderMap = new HashMap<String, List<Ladder>>();
        wordQueue.add(new Ladder(start, null));
        wordQueue.offer(null);
        boolean found = false;
        while(!(wordQueue.size() == 1 && wordQueue.peek() == null)) {
            Ladder ladder = wordQueue.poll();
            if(ladder == null) {
            	if(found) {
            		break;
            	}
                wordQueue.offer(null);
            } else {
        		if(!minLadderMap.containsKey(ladder.word)) {
        			minLadderMap.put(ladder.word, new ArrayList<Ladder>(Arrays.asList(ladder)));
        			if(end.equals(ladder.word)) {
        				found = true; // instead of finding the first qualified minimum path, we need to find all minimum paths under the same level
        			} else {
        				List<Ladder> childWordNodes = transformableWords(ladder, dict, minLadderMap);
        				wordQueue.addAll(childWordNodes);
        			}
        		} else if(ladder.length == minLadderMap.get(ladder.word).get(0).length) {
        			minLadderMap.get(ladder.word).add(ladder);
        		}
            }
        }
        return minLadderMap;
    }
    
    private List<Ladder> transformableWords(Ladder from, Set<String> dict, Map<String, List<Ladder>> pathMap) {
    	List<Ladder> wordNodes = new LinkedList<Ladder>();
        char[] chars = from.word.toCharArray();
        for(int i = 0;i < chars.length;i++) {
            char ch = chars[i];
            for(char letter : alphabet) {
                if(letter != ch) {
                    chars[i] = letter;
                    String newWord = new String(chars);
                	if(dict.contains(newWord)) {
                		wordNodes.add(new Ladder(newWord, from));    
                	}
                    chars[i] = ch;
                }
            }    
        }
        return wordNodes;
    }
    
    // determine if start and end only differ with one character
    private boolean isOneDiff(String start, String end) {
    	int count = 0;
    	boolean isOneDiff = true;
    	for(int i = 0; i < start.length(); i++) {
    		if(start.charAt(i) != end.charAt(i)) {
    			count++;
    			if(count > 1) {
    				isOneDiff = false;
    				break;
    			}
    		}
    	}
    	return isOneDiff;
    }
    
    private static final char[] alphabet = new char[] {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z'};
}
