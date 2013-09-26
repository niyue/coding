package com.niyue.coding.leetcode.haspathsum;

import com.niyue.coding.leetcode.common.TreeNode;

/*
 *  http://leetcode.com/onlinejudge#question_112
 *  http://oj.leetcode.com/problems/path-sum/
 */

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(isLeaf(root)) {
            return sum == root.val;
        } else {
            if(root == null) {
                return false;
            } else {
                return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
            }
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
