package com.niyue.coding.leetcode.nextrightpointerii;

// http://leetcode.com/onlinejudge#question_117
public class Solution {
    public void connect(TreeLinkNode node) {
        if(node != null && !isLeaf(node)) {
        	TreeLinkNode siblingChild = siblingChild(node);
        	if(node.right != null) {
                node.right.next = siblingChild; 
            }
        	
            if(node.left != null) {
            	node.left.next = node.right != null ? node.right : siblingChild;
            }
            
            // NOTE: process right sub tree before left sub tree
            connect(node.right);    
        
            connect(node.left);    
        }
    }
    
    private TreeLinkNode siblingChild(TreeLinkNode node) {
        TreeLinkNode sibling = null;
        TreeLinkNode next = node.next;
        while(next != null) {
            if(next.left != null) {
                sibling = next.left;
                break;
            } else if(next.right != null) {
                sibling = next.right;
                break;
            } else {
                next = next.next;
            }
        }        
        return sibling;
    }
    
    private boolean isLeaf(TreeLinkNode node) {
        return node.left == null && node.right == null;
    }
    
    @SuppressWarnings("unused")
    private static class TreeLinkNode {
    	int val;
    	TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
}
