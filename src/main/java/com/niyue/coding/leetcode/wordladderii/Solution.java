package com.niyue.coding.leetcode.wordladderii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// http://leetcode.com/onlinejudge#question_127
public class Solution {
	
	public ArrayList<ArrayList<String>> findLadders(final String start, final String end, HashSet<String> dict) {
    	ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
    	
    	if(isOneDiff(start, end)) {
    		ladders.add(new ArrayList<String>(Arrays.asList(start, end)));
    	} else {
    		List<WordNode> solutions = bfs(start, end, dict);
    		ladders = ladders(solutions, start, end);
    	}
        return ladders;
    }
    
    private ArrayList<ArrayList<String>> ladders(List<WordNode> solutions, String start, String end) {
    	ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
    	for(WordNode solution : solutions) {
			Deque<String> words = words(solution);
			ladders.add(new ArrayList<String>(words));
		}
    	return ladders;
    }
    
    private Deque<String> words(WordNode wordNode) {
    	Deque<String> words = new LinkedList<String>();
    	WordNode current = wordNode;
    	while(current != null) {
    		words.addFirst(current.word);
    		current = current.from;
    	}
    	return words;
    }
    
    private static class WordNode {
    	public final String word;
    	public final WordNode from;
    	private int path = 0;
    	public WordNode(String word, WordNode from) {
    		this.word = word;
    		this.from = from;
    		this.path = from == null ? 1 : 1 + from.path;
    	}
		
    	@Override
		public String toString() {
			return word + " <= " + from;
		}
    }
    
    private List<WordNode> wordNodes(java.util.Collection<String> startWords, WordNode from, Map<String, Integer> pathMap) {
    	List<WordNode> wordNodes = new LinkedList<WordNode>();
    	for(String word : startWords) {
    		if(!pathMap.containsKey(word) || from.path + 1 <= pathMap.get(word)) {
    			wordNodes.add(new WordNode(word, from));
    		}
    	}
    	return wordNodes;
    }
    
    private List<WordNode> bfs(String start, String end, Set<String> dict) {
    	dict.add(end);
    	List<WordNode> solutions = new ArrayList<WordNode>();
        Queue<WordNode> wordQueue = new LinkedList<WordNode>();
        Map<String, Integer> pathMap = new HashMap<String, Integer>();
        wordQueue.add(new WordNode(start, null));
        wordQueue.offer(null);
        boolean found = false;
        while(!(wordQueue.size() == 1 && wordQueue.peek() == null)) {
            WordNode wordNode = wordQueue.poll();
            if(wordNode == null) {
            	if(found) {
            		break;
            	}
                wordQueue.offer(null);
            } else {
            	if(end.equals(wordNode.word)) {
            		found = true;
            		solutions.add(wordNode);
            	} else {
            		if(!pathMap.containsKey(wordNode.word) || wordNode.path <= pathMap.get(wordNode.word)) {
            			pathMap.put(wordNode.word, wordNode.path);
            			List<String> connectedWords = transformableWords(wordNode.word, dict);
            			List<WordNode> childWordNodes = wordNodes(connectedWords, wordNode, pathMap);
            			wordQueue.addAll(childWordNodes);    
            		}
            	}      
            }
        }
        return solutions;
    }
    
    private List<String> transformableWords(String word, Set<String> dict) {
        List<String> words = new LinkedList<String>();
        char[] chars = word.toCharArray();
        for(int i = 0;i < chars.length;i++) {
            char ch = chars[i];
            for(char letter : alphabet) {
                if(letter != ch) {
                    chars[i] = letter;
                    String newWord = new String(chars);
                	if(dict.contains(newWord)) {
                		words.add(newWord);    
                	}
                    chars[i] = ch;
                }
            }    
        }
        return words;
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
