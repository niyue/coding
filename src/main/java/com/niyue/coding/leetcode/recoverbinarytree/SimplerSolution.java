package com.niyue.coding.leetcode.recoverbinarytree;

import java.util.ArrayList;
import java.util.List;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_99
// A much simpler implementation compared to my original implementation. 
// instead of comparing three continuous nodes's relative order, it is enough to just compare two nodes (previous and the current node) every time
// just do in order traversal, keep tracks of the non increasing nodes and swap them after traversal
public class SimplerSolution {
    List<TreeNode> nodes;
    TreeNode previous;
    
    public void recoverTree(TreeNode root) {
        nodes = new ArrayList<TreeNode>();
        previous = null;
        
        visit(root);
        swap(nodes.get(0), nodes.get(nodes.size() - 1));
    }
    
    public void visit(TreeNode node) {
    	if(node != null) {
    		visit(node.left);
    		
    		if(previous != null && previous.val > node.val) {
    			nodes.add(previous);
    			nodes.add(node);
    		}
    		previous = node;
    		
    		visit(node.right);
    	}
    }
    
    private void swap(TreeNode one, TreeNode two) {
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
    }
}
