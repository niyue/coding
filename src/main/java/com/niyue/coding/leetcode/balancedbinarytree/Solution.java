package com.niyue.coding.leetcode.balancedbinarytree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_110
// use iterative post order to avoid stack overflow problem when a tree is very deep in recursive implementation
public class Solution {
	private Map<TreeNode, Object[]> results;
    public boolean isBalanced(TreeNode root) {
    	results = new HashMap<TreeNode, Object[]>();
    	results.put(null, new Object[] {true, 0});
    	postOrder(root);
        return (Boolean) results.get(root)[0];            
    }

    // reverse the modified pre-order traversal (parent, right, left) to implement iterative post order traversal
    private void postOrder(TreeNode node) {
    	Deque<TreeNode> order = new LinkedList<TreeNode>();
    	if(node != null) {
    		Deque<TreeNode> stack = new LinkedList<TreeNode>();
    		stack.addFirst(node);
    		while(!stack.isEmpty()) {
    			TreeNode current = stack.removeFirst();
    			order.addFirst(current);
    			if(current.right != null) {
    				stack.addFirst(current.right);
    			}
    			if(current.left != null) {
    				stack.addFirst(current.left);
    			}
    		}
    	}
    	for(TreeNode n : order) {
    		visit(n);
    	}
    }
    
    private void visit(TreeNode node) {
    	Object[] leftTree = results.get(node.left);
		Object[] rightTree = results.get(node.right);
		
		boolean isBalanced = (Boolean) leftTree[0] && (Boolean) rightTree[0] &&
				Math.abs((Integer) rightTree[1] - (Integer) leftTree[1]) <= 1;
		int depth = 1 + Math.max((Integer)leftTree[1], (Integer)rightTree[1]);
		Object[] result = new Object[] {isBalanced, depth};
    	results.put(node, result);
    }
}
