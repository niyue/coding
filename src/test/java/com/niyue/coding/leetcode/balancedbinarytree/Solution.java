package com.niyue.coding.leetcode.balancedbinarytree;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_110
// this implementation causes runtime error for large data set, maybe stack overflow for a very deep tree
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return (Boolean) getBalancedAndDepth(root)[0];            
    }

    private Object[] getBalancedAndDepth(TreeNode node) {
        if(node == null) {
            return new Object[] {true, 0};
        } else {
            Object[] leftTree = getBalancedAndDepth(node.left);
            Object[] rightTree = getBalancedAndDepth(node.right);
            boolean isBalanced = (Boolean) leftTree[0] && (Boolean) rightTree[0] &&
                                 Math.abs((Integer) rightTree[1] - (Integer) leftTree[1]) <= 1;
            int depth = 1 + Math.max((Integer)leftTree[1], (Integer)rightTree[1]);
            return new Object[] {isBalanced, depth};
        }
    }
}
