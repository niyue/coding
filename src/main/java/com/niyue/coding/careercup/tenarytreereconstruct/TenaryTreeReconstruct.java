package com.niyue.coding.careercup.tenarytreereconstruct;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// http://www.careercup.com/question?id=7756669
// Use two stacks to check if the last four nodes in the end can be combine into one node
// if the final four nodes cannot be combined, keep popping from stack 1 to stack 2
// if they can be combined, combine them into one sub tree and put all nodes in stack 2 back to stack 1
// the worse case is still O(n^2)
public class TenaryTreeReconstruct {
	public TreeNode reconstruct(String preorder) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		char[] preOrderNodes = preorder.toCharArray();
		for(int i = 0; i < preOrderNodes.length; i++) {
			TreeNode node = new TreeNode(preOrderNodes[i] == 'L');
			nodes.add(node);
		}
		while(nodes.size() > 1) {
			if(isCompleteTreeInTail(nodes)) {
				completeTree(nodes);
				nodes.addAll(stack);
				stack.clear();
			} else {
				stack.addFirst(nodes.remove(nodes.size() - 1));
			}
		}
		return nodes.get(0);
	}
	
	private boolean isCompleteTreeInTail(List<TreeNode> nodes) {
		boolean isCompleteTreeInTail = false;
		if(nodes.size() >= 4) {
			int length = nodes.size();
			TreeNode lastFour = nodes.get(length - 4);
			if(!lastFour.isLeaf && !lastFour.isComplete) {
				isCompleteTreeInTail = 
						nodes.get(length - 3).isComplete &&
						nodes.get(length - 2).isComplete &&
						nodes.get(length - 1).isComplete;
			}
		}
		return isCompleteTreeInTail;
	}
	
	private void completeTree(List<TreeNode> nodes) {
		int length = nodes.size();
		TreeNode parent = nodes.get(length - 4);
		parent.children = new TreeNode[]{ 
			nodes.get(length - 3), 
			nodes.get(length - 2), 
			nodes.get(length - 1)};
		parent.isComplete = true;
		nodes.remove(length - 1);
		nodes.remove(length - 2);
		nodes.remove(length - 3);
	}
}
