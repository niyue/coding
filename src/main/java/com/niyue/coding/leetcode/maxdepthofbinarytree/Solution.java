package com.niyue.coding.leetcode.maxdepthofbinarytree;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_104
public class Solution {
    public int maxDepth(TreeNode node) {
        if(node == null) {
    		return 0;
    	} else {
    		int leftMaxDepth = maxDepth(node.left);
    		int rightMaxDepth = maxDepth(node.right);
    		return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    	}
    }
}
