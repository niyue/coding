package com.niyue.coding.leetcode.nextrightpointer;

// http://leetcode.com/onlinejudge#question_116
public class Solution {
    public void connect(TreeLinkNode node) {
        if(node != null && !isLeaf(node)) {
            node.left.next = node.right;
            node.right.next = node.next == null ? null : node.next.left;
            connect(node.left);
            connect(node.right);
        }
    }
    
    private boolean isLeaf(TreeLinkNode node) {
        return node.left == null;
    }
    
    @SuppressWarnings("unused")
    private static class TreeLinkNode {
    	int val;
    	TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
}