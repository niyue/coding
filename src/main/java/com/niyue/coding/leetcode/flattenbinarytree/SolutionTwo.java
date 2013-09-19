package com.niyue.coding.leetcode.flattenbinarytree;

import com.niyue.coding.leetcode.common.TreeNode;

// http://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class SolutionTwo {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    
    private TreeNode[] flattenTree(TreeNode node) {
        TreeNode head = node;
        TreeNode tail = node;
        if(node != null) {
        	// NOTE: we need to copy the reference of node.right because it may get modified before determining if(right != null)
        	TreeNode left = node.left;
        	TreeNode right = node.right;
            TreeNode[] leftList = flattenTree(left);
            TreeNode[] rightList = flattenTree(right);
            if(left != null) {
                tail.right = leftList[0];
                tail = leftList[1];
            }
            if(right != null) {
                tail.right = rightList[0];
                tail = rightList[1];    
            }            
            head.left = null;
        	tail.right = null;
        }
        return new TreeNode[] {head, tail};
    }
}
