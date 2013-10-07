package com.niyue.coding.leetcode.treemaxpathsum;

import com.niyue.coding.leetcode.common.TreeNode;

// Given a binary tree, find the maximum path sum.
// The path may start and end at any node in the tree.
// http://leetcode.com/onlinejudge#question_124
// maxPathAndSum returns an array, array[0] is the sum starting from root node to any of its child node, array[1] is the max path sum for root node
public class Solution {
    public int maxPathSum(TreeNode root) {
        return (int) maxPathAndSum(root)[1];    
    }
    
    // use long instead of int because of possible overflow for addition/subtraction
    private long[] maxPathAndSum(TreeNode node) {
    	long[] pathAndSum = new long[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        if(node != null) {
        	long[] left = maxPathAndSum(node.left);
        	long[] right = maxPathAndSum(node.right);
	    	
			pathAndSum[0] = max(node.val, node.val + left[0], node.val + right[0]);
			
			pathAndSum[1] = max(pathAndSum[0], node.val + left[0] + right[0], left[1], right[1]);    
        }
        return pathAndSum;
    }
    
    // for some unknown reason, leetcode's online judge will reject Collections.max(Arrays.asList(...)) to find max by reporting a runtime error
    private long max(long... numbers) {
    	long max = Integer.MIN_VALUE;
    	for(long n : numbers) {
    		if(n > max) {
    			max = n;
    		}
    	}
    	return max;
    }
}
