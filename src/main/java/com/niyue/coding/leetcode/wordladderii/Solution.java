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
    	Set<String> startTransformableWords =  new HashSet<String>(transformableWords(start, dict, false));
    	Set<String> startWords = new HashSet<String>(transformableWords(start, dict, true));
    	Set<String> endWords = new HashSet<String>(transformableWords(end, dict, true));
    	
    	ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
    	
    	if(startTransformableWords.contains(end)) {
    		ladders.add(new ArrayList<String>() {{add(start); add(end);}});
    	} else {
    		Map<String, List<String>> dictGraph = makeGraph(dict);
    		List<WordNode> solutions = bfs(startWords, endWords, dictGraph);
    		for(WordNode solution : solutions) {
    			List<String> words = words(solution);
    			ArrayList<String> ladder = new ArrayList<String>();
    			ladder.add(start);
    			ladder.addAll(words);
    			ladder.add(end);
    			ladders.add(ladder);
    		}
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
    	public WordNode(String word, WordNode from) {
    		this.word = word;
    		this.from = from;
    	}
    }
    
    private Set<WordNode> wordNodes(java.util.Collection<String> startWords, WordNode from) {
    	Set<WordNode> wordNodes = new HashSet<WordNode>();
    	for(String word : startWords) {
    		wordNodes.add(new WordNode(word, from));
    	}
    	return wordNodes;
    }
    
    private List<WordNode> dfs(Set<String> startWords, Set<String> endWords, Map<String, List<String>> dictGraph, int maxDepth, int depth) {
    	for(String word : startWords) {
    		List<String> connectedWords = dictGraph.get(word);
    	}
    	return null;
    }
    
    private List<WordNode> bfs(Set<String> startWords, Set<String> endWords, Map<String, List<String>> dictGraph) {
    	List<WordNode> solutions = new ArrayList<WordNode>();
        Queue<WordNode> wordQueue = new LinkedList<WordNode>();
        Set<WordNode> startWordNodes = wordNodes(startWords, null);
        wordQueue.addAll(startWordNodes);
        wordQueue.offer(null);
        boolean found = false;
        Set<String> visitedWords = new HashSet<String>();
        while(!(wordQueue.size() == 1 && wordQueue.peek() == null)) {
            WordNode wordNode = wordQueue.poll();
            if(wordNode == null) {
            	if(found) {
            		break;
            	}
                wordQueue.offer(null);
            } else if(!visitedWords.contains(wordNode.word)) {
            	if(endWords.contains(wordNode.word)) {
            		found = true;
            		solutions.add(wordNode);
            	} else {
            		visitedWords.add(wordNode.word);
            		if(dictGraph.containsKey(wordNode.word)) {
            			List<String> connectedWords = dictGraph.get(wordNode.word);
            			Set<WordNode> childWordNodes = wordNodes(connectedWords, wordNode);
            			wordQueue.addAll(childWordNodes);    
            		}
            	}      
            }
        }
        return solutions;
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
