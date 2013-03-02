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
        int leftPath = 0, leftSum = 0, rightPath = 0, rightSum = 0;
        
        if(node.left != null) {
            int[] left = maxPathAndSum(node.left);
            leftPath = left[0];
            leftSum = left[1];
        }
        if(node.right != null) {
            int[] right = maxPathAndSum(node.right);
            rightPath = right[0];
            rightSum = right[1];
        }
        
        if(node.left != null && node.right != null) {
            pathAndSum[0] = leftPath > 0 || rightPath > 0 ? Math.max(leftPath, rightPath) + node.val : node.val;
            int maxPath = maxPathSum(node.val, leftPath, rightPath);
            pathAndSum[1] = Math.max(Math.max(maxPath, leftSum), rightSum);    
        } else if(node.left != null && node.right == null) {
            pathAndSum[0] = leftPath > 0 ? leftPath + node.val : node.val;
            int maxPath = maxPathSum(node.val, leftPath, null);
            pathAndSum[1] = Math.max(maxPath, leftSum);    
        } else if(node.left == null && node.right != null) {
            pathAndSum[0] = rightPath > 0 ? rightPath + node.val : node.val;
            int maxPath = maxPathSum(node.val, null, rightPath);
            pathAndSum[1] = Math.max(maxPath, rightSum);    
        } else {
            pathAndSum[0] = node.val;
            pathAndSum[1] = node.val;
        }
        
        return pathAndSum;
    }
    
    private int maxPathSum(int nodeVal, Integer leftPath, Integer rightPath) {
        int maxPath = nodeVal;
        if(leftPath != null && leftPath > 0) {
            maxPath += leftPath;
        }
        if(rightPath != null && rightPath > 0) {
            maxPath += rightPath;
        }    
        return maxPath;
    }
}
