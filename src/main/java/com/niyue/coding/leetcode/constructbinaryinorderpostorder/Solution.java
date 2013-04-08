package com.niyue.coding.leetcode.constructbinaryinorderpostorder;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_106
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);        
    }

    private TreeNode build(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2) {
    	TreeNode parent = null;
    	if(s1 <= e1) {
    		int parentVal = postorder[e2];
    		parent = new TreeNode(parentVal);
    		int parentIndex = search(inorder, s1, e1 + 1, parentVal);
    		TreeNode left = build(inorder, s1, parentIndex - 1, postorder, s2, s2 + parentIndex - s1 - 1);
    		TreeNode right = build(inorder, parentIndex + 1, e1, postorder, s2 + parentIndex - s1, e2 - 1);
    		parent.left = left;
    		parent.right = right;
    	}
    	return parent;
    }

    private int search(int[] inorder, int start, int end, int target) {
    	for(int i = start; i < end; i++) {
    		if(inorder[i] == target) {
    			return i;
    		}
    	}
    	return -1;
    }
}
