package com.niyue.coding.leetcode.haspathsum;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_112
public class Solution {
    public boolean hasPathSum(TreeNode node, int sum) {
        boolean hasPathSum = false;
        if(node != null) {
        	if(node.left != null && node.right == null) {
        		hasPathSum = hasPathSum(node.left, sum - node.val);                
        	} else if(node.left == null && node.right != null) {
        		hasPathSum = hasPathSum(node.right, sum - node.val);
        	} else if(node.left != null && node.right != null) {
        		hasPathSum = hasPathSum(node.left, sum - node.val) ||
        				hasPathSum(node.right, sum - node.val);
        	} else {
        		hasPathSum = node.val == sum;   
        	}
        }
        return hasPathSum;
    }
}
