package com.niyue.coding.leetcode.validatebst;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_98
// Validate if a tree is binary search tree
public class Solution {
    public boolean isValidBST(TreeNode root) {
        boolean valid = true;
        if(root != null) {
            valid = isBst(root.left, Integer.MIN_VALUE, root.val)
                 && isBst(root.right, root.val, Integer.MAX_VALUE);
        }
        return valid;
    }
    
    private boolean isBst(TreeNode node, int min, int max) {
        boolean isBst = true;
        if(node != null) {
            if(node.val > min && node.val < max) {
                isBst = isBst(node.left, min, node.val) && isBst(node.right, node.val, max);    
            } else {
                isBst = false;
            }
        }
        return isBst;
    }
}
