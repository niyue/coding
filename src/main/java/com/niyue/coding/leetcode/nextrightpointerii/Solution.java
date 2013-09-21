package com.niyue.coding.leetcode.nextrightpointerii;

// http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
// http://leetcode.com/onlinejudge#question_117
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root != null) {
            TreeLinkNode next = nextSiblingWithChild(root);
            TreeLinkNode nextChild = nextChild(next);
            if(root.right != null) {
                root.right.next = nextChild;
            }
            if(root.left != null) {
                root.left.next = root.right != null ? root.right : nextChild;
            }
            // NOTE: process right sub tree before left sub tree
            connect(root.right);
            connect(root.left);
        }        
    }
    
    private TreeLinkNode nextSiblingWithChild(TreeLinkNode node) {
        TreeLinkNode next = node.next;
        while(next != null && next.left == null && next.right == null) {
            next = next.next;
        }
        return next;
    }

    private TreeLinkNode nextChild(TreeLinkNode node) {
    	return node == null ? null : node.left != null ? node.left : node.right;
    }
    
    @SuppressWarnings("unused")
    private static class TreeLinkNode {
    	int val;
    	TreeLinkNode left, right, next;
    	TreeLinkNode(int x) { val = x; }
    }
}
