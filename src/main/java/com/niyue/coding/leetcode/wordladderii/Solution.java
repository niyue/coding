package com.niyue.coding.leetcode.wordladderii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// http://leetcode.com/onlinejudge#question_127
public class Solution {
	
    @SuppressWarnings("serial")
    // leetcode's online judge method signature forces me to use ArrayList<ArrayList<String>>
	public ArrayList<ArrayList<String>> findLadders(final String start, final String end, HashSet<String> dict) {
    	Set<String> startTransformableWords =  transformableWords(start, dict, false);
    	Set<String> startWords = transformableWords(start, dict, true);
    	Set<String> endWords = transformableWords(end, dict, true);
    	
    	ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
    	
    	if(startTransformableWords.contains(end)) {
    		ladders.add(new ArrayList<String>() {{add(start); add(end);}});
    	} else {
    		Map<String, Set<String>> dictGraph = makeGraph(dict);
    		List<WordNode> solutions = bfs(startWords, endWords, dictGraph);
    		ladders = ladders(solutions, start, end);
    	}
        return ladders;
    }
    
    private ArrayList<ArrayList<String>> ladders(List<WordNode> solutions, String start, String end) {
    	ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
    	for(WordNode solution : solutions) {
			List<String> words = words(solution);
			ArrayList<String> ladder = new ArrayList<String>();
			ladder.add(start);
			ladder.addAll(words);
			ladder.add(end);
			ladders.add(ladder);
		}
    	return ladders;
    }
    
    private List<String> words(WordNode wordNode) {
    	List<String> words = new ArrayList<String>();
    	WordNode current = wordNode;
    	while(current != null) {
    		words.add(current.word);
    		current = current.from;
    	}
    	Collections.reverse(words);
    	return words;
    }
    
    private static class WordNode {
    	public final String word;
    	public final WordNode from;
    	private int path = 0;
    	public WordNode(String word, WordNode from) {
    		this.word = word;
    		this.from = from;
    		this.path = 1;
    		if(from != null) {
    			this.path += from.path;
    		}
    	}
		
    	@Override
		public String toString() {
			return word + " <= " + from;
		}
    }
    
    private Set<WordNode> wordNodes(java.util.Collection<String> startWords, WordNode from, Map<String, Integer> pathMap) {
    	Set<WordNode> wordNodes = new HashSet<WordNode>();
    	for(String word : startWords) {
    		if(from == null || (!pathMap.containsKey(word) || from.path + 1 <= pathMap.get(word))) {
    			wordNodes.add(new WordNode(word, from));
    		}
    	}
    	return wordNodes;
    }
    
    private List<WordNode> bfs(Set<String> startWords, Set<String> endWords, Map<String, Set<String>> dictGraph) {
    	List<WordNode> solutions = new ArrayList<WordNode>();
        Queue<WordNode> wordQueue = new LinkedList<WordNode>();
        Map<String, Integer> pathMap = new HashMap<String, Integer>();
        Set<WordNode> startWordNodes = wordNodes(startWords, null, pathMap);
        wordQueue.addAll(startWordNodes);
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
            	if(endWords.contains(wordNode.word)) {
            		found = true;
            		solutions.add(wordNode);
            	} else {
            		if(dictGraph.containsKey(wordNode.word) && (!pathMap.containsKey(wordNode.word) || wordNode.path <= pathMap.get(wordNode.word))) {
            			Set<String> connectedWords = dictGraph.get(wordNode.word);
            			Set<WordNode> childWordNodes = wordNodes(connectedWords, wordNode, pathMap);
            			wordQueue.addAll(childWordNodes);    
            			pathMap.put(wordNode.word, wordNode.path);
            		}
            	}      
            }
        }
        return solutions;
    }
    
    Map<String, Set<String>> makeGraph(Set<String> dict) {
        Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
        for(String word : dict) {
            Set<String> connectedWords = transformableWords(word, dict, true);   
            graph.put(word, connectedWords);
        }
        return graph;
    }
    
    private Set<String> transformableWords(String word, Set<String> dict, boolean checkDict) {
        Set<String> words = new HashSet<String>();
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
