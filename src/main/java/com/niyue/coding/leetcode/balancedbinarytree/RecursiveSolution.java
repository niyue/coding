package com.niyue.coding.leetcode.balancedbinarytree;

import com.niyue.coding.careercup.commonancestor.TreeNode;

/*
 * http://oj.leetcode.com/problems/balanced-binary-tree/
 * TODO: The recursive solution will cause a stack overflow because the tree has a very big height? Failed for a test case in large data set
 */
public class RecursiveSolution {
	public boolean isBalanced(TreeNode root) {
        return (Boolean) getBalancedAndHeight(root)[0];
    }
    
    private Object[] getBalancedAndHeight(TreeNode node) {
        Object[] balancedAndHeight = new Object[] {true, 0};
        if(node != null) {
            Object[] left = getBalancedAndHeight(node.left);
            Object[] right = getBalancedAndHeight(node.right);
            balancedAndHeight[0] = ((Boolean) left[0]) && ((Boolean) right[0]) && Math.abs((Integer) left[1] - (Integer) right[1]) <= 1;
            balancedAndHeight[1] = Math.max((Integer) left[1], (Integer) right[1]) + 1;
        }
        return balancedAndHeight;
    }
}
