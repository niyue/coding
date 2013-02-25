package com.niyue.coding.leetcode.sumroottoleafnumbers;

import java.util.LinkedList;

// http://leetcode.com/onlinejudge#question_129
public class Solution {
	private int sum = 0;
    public int sumNumbers(TreeNode root) {
    	sum = 0;
        if(root != null) {
        	LinkedList<TreeNode> path = new LinkedList<TreeNode>();
        	path.add(root);
            visit(root, path);
        }
        
        return sum;
    }
      
    private void visit(TreeNode node, LinkedList<TreeNode> path) {
    	if(isLeaf(node)) {
    		sum += getNumberFromRootToLeaf(path);
    	} else {
    		if(node.left != null) {
    			path.addLast(node.left);
    			visit(node.left, path);
    			path.removeLast();
    		}
    		if(node.right != null) {
    			path.addLast(node.right);
    			visit(node.right, path);
    			path.removeLast();
    		}
    	}
    }
    
    private int getNumberFromRootToLeaf(LinkedList<TreeNode> path) {
        int number = 0;
        for(TreeNode node : path) {
        	number = number * 10 + node.val;
        }
        return number;
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
    public static class TreeNode {
   	 	public int val;
   	 	public TreeNode left;
   	 	public TreeNode right;
   	 	public TreeNode(int x) { val = x; }
    }
}
