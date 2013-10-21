package com.niyue.coding.leetcode.validatebst;

import com.niyue.coding.leetcode.common.TreeNode;

/*
 * http://oj.leetcode.com/problems/validate-binary-search-tree/
 */
public class InOrderTraversalSolutionTwo {
	private int prev;
    public boolean isValidBST(TreeNode root) {
        prev = Integer.MIN_VALUE;
        return isValid(root);
    }
    
    private boolean isValid(TreeNode node) {
        boolean isValid = node == null;
        if(node != null) {
            if(isValid(node.left)) {
                if(node.val > prev) {
                    prev = node.val;
                    isValid = isValid(node.right);
                }
            }
        }
        return isValid;
    }
}
