package com.niyue.coding.leetcode.treemaxpathsum;

import com.niyue.coding.leetcode.common.TreeNode;

// Given a binary tree, find the maximum path sum.
// The path may start and end at any node in the tree.
// http://leetcode.com/onlinejudge#question_124
public class Solution {
    public int maxPathSum(TreeNode root) {
        return maxPathAndSum(root)[1];    
    }
    
    private int[] maxPathAndSum(TreeNode node) {
        int[] pathAndSum = new int[2];
        if(node == null) {
        	pathAndSum[0] = 0;
            pathAndSum[1] = Integer.MIN_VALUE;
        } else {
    		int[] left = maxPathAndSum(node.left);
    		int[] right = maxPathAndSum(node.right);
        	
    		pathAndSum[0] = Math.max(node.val, node.val + Math.max(left[0], right[0]));
    		int maxPath = Math.max(node.val + left[0] + right[0], pathAndSum[0]);
    		
    		pathAndSum[1] = Math.max(Math.max(maxPath, left[1]), right[1]);    
        }
        
        return pathAndSum;
    }
}
