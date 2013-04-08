package com.niyue.coding.leetcode.constructbinarytreefrompreorderinorder;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_105
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);        
    }

    private TreeNode build(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
    	TreeNode parent = null;
    	if(s1 <= e1) {
    		int parentVal = preorder[s1];
    		parent = new TreeNode(parentVal);
    		int parentIndex = search(inorder, s2, e2 + 1, parentVal);
    		TreeNode left = build(preorder, s1 + 1, s1 + parentIndex - s2, inorder, s2, parentIndex - 1);
    		TreeNode right = build(preorder, s1 + parentIndex - s2 + 1, e1, inorder, parentIndex + 1, e2);
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
