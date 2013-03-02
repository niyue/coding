package com.niyue.coding.leetcode.flattenbinarytree;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_114
// Flatten a binary tree into a singly linked list 
// flatten to doubly linked list will make leetcode's online judge report time limit exceeded, I guess there is some infinite loop during leetcode's result verification for doubly linked list
public class Solution {
    public void flatten(TreeNode root) {
        toLinkedList(root);
    }
    
    private TreeNode[] toLinkedList(TreeNode node) {
        TreeNode[] firstAndLast = new TreeNode[2];
        firstAndLast[0] = node;
        firstAndLast[1] = node;
        
        if(node != null) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = null;
            node.right = null;
        
            if(left != null) {
                TreeNode[] firstAndLastFromLeft = toLinkedList(left);
                TreeNode leftFirst = firstAndLastFromLeft[0];
                TreeNode leftLast = firstAndLastFromLeft[1];
                node.right = leftFirst;
                //leftFirst.left = node;
                firstAndLast[1] = leftLast;
                
                if(right != null) {
                    TreeNode[] firstAndLastFromRight = toLinkedList(right);
                    TreeNode rightFirst = firstAndLastFromRight[0];
                    TreeNode rightLast = firstAndLastFromRight[1];
                    leftLast.right = rightFirst;
                    //rightFirst.left = leftLast;    
                    firstAndLast[1] = rightLast;
                }
            } else if(right != null) {
                TreeNode[] firstAndLastFromRight = toLinkedList(right);
                TreeNode rightFirst = firstAndLastFromRight[0];
                TreeNode rightLast = firstAndLastFromRight[1];
                node.right = rightFirst;
                //rightFirst.left = node;    
                firstAndLast[1] = rightLast;        
            }    
        }
        
        return firstAndLast;
    }
}
