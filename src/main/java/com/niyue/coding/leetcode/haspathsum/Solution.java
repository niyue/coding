package com.niyue.coding.leetcode.haspathsum;

import com.niyue.coding.leetcode.common.TreeNode;

/*
 *  http://leetcode.com/onlinejudge#question_112
 *  http://oj.leetcode.com/problems/path-sum/
 */

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return sum == 0;
        } else {
            return hasPathSum(root.left, sum - root.val) || 
            	   hasPathSum(root.right, sum - root.val);
        }
    }
}
