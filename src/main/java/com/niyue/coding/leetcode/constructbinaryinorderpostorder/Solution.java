package com.niyue.coding.leetcode.constructbinaryinorderpostorder;

import java.util.HashMap;
import java.util.Map;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_106
// The original algorithm uses linear search in the array, which will lead to an O(n^2) algorithm
// the current algorithm uses a Map to store all the indexes for each number, and uses the map for quick look up 
public class Solution {
	private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	indexMap = indexMap(inorder);
    	return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);        
    }

    private TreeNode build(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2) {
    	TreeNode parent = null;
    	if(s1 <= e1) {
    		int parentVal = postorder[e2];
    		parent = new TreeNode(parentVal);
    		int parentIndex = search(indexMap, parentVal);
    		TreeNode left = build(inorder, s1, parentIndex - 1, postorder, s2, s2 + parentIndex - s1 - 1);
    		TreeNode right = build(inorder, parentIndex + 1, e1, postorder, s2 + parentIndex - s1, e2 - 1);
    		parent.left = left;
    		parent.right = right;
    	}
    	return parent;
    }
    
    private Map<Integer, Integer> indexMap(int[] inorder) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < inorder.length; i ++) {
    		map.put(inorder[i], i);
    	}
    	return map;
    }
    
    @SuppressWarnings("unused")
	private int search(int[] inorder, int start, int end, int target) {
    	for(int i = start; i < end; i++) {
    		if(inorder[i] == target) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    private int search(Map<Integer, Integer> indexMap, int target) {
    	return indexMap.get(target);
    }
}
